package com.miternos.odata.rest.orlingo.interceptor;

import com.miternos.odata.rest.orlingo.service.LocationService;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * Created by miternos on 7/12/17.
 */
public class OlingoJaxrsInInterceptor extends AbstractPhaseInterceptor {

    public OlingoJaxrsInInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) {

        String requestUri = (String)message.get("org.apache.cxf.request.uri");
        String requestMethod = (String)message.get("org.apache.cxf.request.method");

        if ( requestMethod.equals("GET") ){
            String[] uriArr = requestUri.split("/");
            String resourceName = uriArr[uriArr.length-1];

            if ( resourceName.equals("DimLocation" )){
                LocationService.getInstance().getLocations(); //Get Locations and put to odata
            }


        }

    }

    public void handleFault(Message messageParam) {
    }
}
