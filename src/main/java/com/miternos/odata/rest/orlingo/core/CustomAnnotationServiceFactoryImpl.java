package com.miternos.odata.rest.orlingo.core;

import org.apache.olingo.odata2.annotation.processor.core.datasource.AnnotationInMemoryDs;
import org.apache.olingo.odata2.annotation.processor.core.datasource.AnnotationValueAccess;
import org.apache.olingo.odata2.annotation.processor.core.edm.AnnotationEdmProvider;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.rt.RuntimeDelegate;

import java.util.Collection;

/**
 * Created by miternos on 7/13/17.
 */
public class CustomAnnotationServiceFactoryImpl implements CustomAnnotationServiceFactory.AnnotationServiceFactoryInstance {

    public CustomAnnotationServiceFactoryImpl() {
    }

    public ODataService createAnnotationService(String modelPackage) throws ODataException {
        AnnotationEdmProvider edmProvider = new AnnotationEdmProvider(modelPackage);
        AnnotationInMemoryDs dataSource = new CustomAnnotationInMemoryDs(modelPackage);
        AnnotationValueAccess valueAccess = new AnnotationValueAccess();
        return RuntimeDelegate.createODataSingleProcessorService(edmProvider, new CustomListProcessor(dataSource, valueAccess));
    }

    public ODataService createAnnotationService(Collection<Class<?>> annotatedClasses) throws ODataException {
        AnnotationEdmProvider edmProvider = new AnnotationEdmProvider(annotatedClasses);
        AnnotationInMemoryDs dataSource = new CustomAnnotationInMemoryDs(annotatedClasses);
        AnnotationValueAccess valueAccess = new AnnotationValueAccess();
        return RuntimeDelegate.createODataSingleProcessorService(edmProvider, new CustomListProcessor(dataSource, valueAccess));
    }
}
