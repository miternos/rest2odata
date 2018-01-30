package com.miternos.odata.rest.orlingo.core;

import org.apache.olingo.odata2.annotation.processor.core.datasource.AnnotationInMemoryDs;
import org.apache.olingo.odata2.annotation.processor.core.datasource.DataStore;
import org.apache.olingo.odata2.api.exception.ODataException;

import java.util.*;

/**
 * Created by miternos on 7/13/17.
 */
public class CustomAnnotationInMemoryDs extends AnnotationInMemoryDs {


    public CustomAnnotationInMemoryDs(Collection<Class<?>> annotatedClasses) throws ODataException {
        super(annotatedClasses);
    }

    public CustomAnnotationInMemoryDs(Collection<Class<?>> annotatedClasses, boolean persistInMemory) throws
                                                                                                      ODataException {
        super(annotatedClasses, persistInMemory);
    }

    public CustomAnnotationInMemoryDs(String packageToScan) throws ODataException {
        super(packageToScan);
    }

    public CustomAnnotationInMemoryDs(String packageToScan, boolean persistInMemory) throws ODataException {
        super(packageToScan, persistInMemory);
    }

    /***
     * Method to remove all objects of a <code>clazz</code> from datasource
     *
     * Not a permemanent solution for production env. due to performance
     * @param clazz
     */
    public void remove(Class clazz){

        DataStore<Object> dhs = this.getDataStore(clazz);
        Iterator<Object> it = dhs.read().iterator();
        List<Object> list = new ArrayList<Object>();
        while ( it.hasNext())
            list.add(it.next());

        for ( Object o : list ){
            dhs.delete(o);
        }
    }

}
