package com.miternos.odata.rest.orlingo.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miternos.odata.rest.orlingo.model.DimLocation;
import io.swagger.client.ApiException;
import io.swagger.client.api.LocationApi;
import io.swagger.client.model.SigmaSensationDTOGeneralPagedResponseSigmaSensationDTOLocationLocationListResponse;
import io.swagger.client.model.SigmaSensationDTOLocationLocationListResponse;

import java.util.*;

/**
 * Created by miternos on 7/12/17.
 */
public class LocationService extends AbstractService {

    private static LocationApi locationApi;

    private static LocationService instance ;

    public static synchronized LocationService getInstance(){
        if ( instance == null ){
            instance = new LocationService();
            locationApi = new LocationApi();
            locationApi.getApiClient().addDefaultHeader("Authorization","Bearer " + bearerKey);
            locationApi.getApiClient().addDefaultHeader("X-DeviceNetwork",xDeviceNetwork);
        }

        return instance;
    }

    public String getLocations(){

        String response = "";

        try {

            // Remove all locations
            removeFromDataStore(DimLocation.class);

            // Rest call to get data
            SigmaSensationDTOGeneralPagedResponseSigmaSensationDTOLocationLocationListResponse resp = locationApi
                    .locationGet(xDeviceNetwork, null, null, null, null, null);

            Gson gson = new GsonBuilder().create();

            // Create entities in Odata
            Map<UUID,SigmaSensationDTOLocationLocationListResponse> responseMap = new HashMap<UUID, SigmaSensationDTOLocationLocationListResponse>();

            for ( SigmaSensationDTOLocationLocationListResponse row : resp.getRows()){
                responseMap.put(row.getId(),row);
            }

            for ( SigmaSensationDTOLocationLocationListResponse row : responseMap.values()){
                DimLocation locationOne =  new DimLocation();
                locationOne.setDeviceNetworkId(xDeviceNetwork);
                locationOne.setLocationId(row.getId().toString());

                List<String> locationNames = new ArrayList<String>();

                SigmaSensationDTOLocationLocationListResponse curr = row;
                while ( curr.getParentLocationId() != null && locationNames.size() < 6){
                    locationNames.add(curr.getName());
                    curr = responseMap.get(curr.getParentLocationId());
                }
                locationNames.add(curr.getName());

                int depth = locationNames.size();
                locationOne.setLocationLevel1(depth >= 1 ? locationNames.get(depth-1) : "- This Level -");
                locationOne.setLocationLevel2(depth >= 2 ? locationNames.get(depth-2) : "- This Level -");
                locationOne.setLocationLevel3(depth >= 3 ? locationNames.get(depth-3) : "- This Level -");
                locationOne.setLocationLevel4(depth >= 4 ? locationNames.get(depth-4) : "- This Level -");
                locationOne.setLocationLevel5(depth >= 5 ? locationNames.get(depth-5) : "- This Level -");
                locationOne.setLocationLevel6(depth >= 6 ? locationNames.get(depth-6) : "- This Level -");

                StringBuffer sb = new StringBuffer();
                for (int i = locationNames.size(); i > 0; i--) {
                    sb.append(locationNames.get(i-1));
                    if ( i > 1 )
                        sb.append("->");
                }

                locationOne.setLocation(sb.toString());
                writeRawObject(locationOne);
            }


        } catch (ApiException e) {
            e.printStackTrace();
        }

        return response;
    }

}
