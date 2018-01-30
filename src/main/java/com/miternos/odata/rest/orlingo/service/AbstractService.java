package com.miternos.odata.rest.orlingo.service;

import com.miternos.odata.rest.orlingo.core.CustomAnnotationInMemoryDs;
import com.miternos.odata.rest.orlingo.core.CustomListProcessor;
import com.miternos.odata.rest.orlingo.processor.AnnotationSampleServiceFactory;
import io.swagger.client.ApiClient;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataProcessor;

/**
 * Created by miternos on 7/12/17.
 */
public abstract class AbstractService {

    //ToDo should be in a config file or input param
    public static String xDeviceNetwork = "613b7124-e2db-4e76-9feb-102a869bd497" ;
    public static String bearerKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkbklkIjoiMDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwIiwicGVybWlzc2lvbnMiOm51bGwsImlzcyI6ImFwcGlvdHdlYmFwaSIsImF1ZCI6ImFwcGlvdHdlYmFwaSIsImV4cCI6MTYwMTQ2NDQyNSwibmJmIjoxNDk4ODIxMjM5LCJpYXQiOjE0OTg4MjEyMzksIm5hbWUiOiJjYXJsb3MiLCJ0b2tlblR5cGUiOiJhY2Nlc3NUb2tlbiIsInVzZXJJZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC0wMDAwLTAwMDAwMDAwMDAwMCJ9.hBJ8upN4Zzf1E3mG4sgslVXXNnH32KMWOSZgHGcvGak=";


    protected void writeRawObject(Object o){
        Class clazz = o.getClass();
        try {
            ODataProcessor processor = ((ODataService) AnnotationSampleServiceFactory.getOdataService()).getProcessor() ;
            if ( processor instanceof CustomListProcessor){
                CustomListProcessor customProcessor = (CustomListProcessor)processor ;
                CustomAnnotationInMemoryDs dataSource = ((CustomAnnotationInMemoryDs) customProcessor.getDataSource());
                dataSource.getDataStore(clazz).create(o);
            }
        } catch (ODataException e) {
            e.printStackTrace();
        }
    }



    protected void removeFromDataStore(Class clazz) {
        try {
            ODataProcessor processor = ((ODataService) AnnotationSampleServiceFactory.getOdataService()).getProcessor() ;
            if ( processor instanceof CustomListProcessor){
                CustomListProcessor customProcessor = (CustomListProcessor)processor ;
                CustomAnnotationInMemoryDs dataSource = ((CustomAnnotationInMemoryDs) customProcessor.getDataSource());
                dataSource.remove(clazz);
            }
        } catch (ODataException e) {
            e.printStackTrace();
        }
    }





}
