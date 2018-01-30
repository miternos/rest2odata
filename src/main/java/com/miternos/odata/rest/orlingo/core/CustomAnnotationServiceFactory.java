package com.miternos.odata.rest.orlingo.core;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.exception.ODataException;

import java.util.Collection;

/**
 * Created by miternos on 7/13/17.
 */
public abstract class CustomAnnotationServiceFactory {
    private static final String IMPLEMENTATION = "CustomAnnotationServiceFactoryImpl";

    public CustomAnnotationServiceFactory() {
    }

    private static CustomAnnotationServiceFactory.AnnotationServiceFactoryInstance getInstance() {
        try {
            Class<?> clazz = Class.forName(IMPLEMENTATION);
            Object object = clazz.newInstance();
            CustomAnnotationServiceFactory.AnnotationServiceFactoryInstance delegate = (CustomAnnotationServiceFactory.AnnotationServiceFactoryInstance)object;
            return delegate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ODataService createAnnotationService(String modelPackage) throws ODataException {
        return getInstance().createAnnotationService(modelPackage);
    }

    public static ODataService createAnnotationService(Collection<Class<?>> annotatedClasses) throws ODataException {
        return getInstance().createAnnotationService(annotatedClasses);
    }

    public interface AnnotationServiceFactoryInstance {
        ODataService createAnnotationService(String var1) throws ODataException;

        ODataService createAnnotationService(Collection<Class<?>> var1) throws ODataException;
    }
}
