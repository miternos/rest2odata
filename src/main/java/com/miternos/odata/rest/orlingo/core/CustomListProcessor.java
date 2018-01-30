package com.miternos.odata.rest.orlingo.core;

import org.apache.olingo.odata2.annotation.processor.core.ListsProcessor;
import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource;
import org.apache.olingo.odata2.annotation.processor.core.datasource.ValueAccess;

/**
 * Created by miternos on 7/13/17.
 */
public class CustomListProcessor extends ListsProcessor {
    public CustomListProcessor(DataSource dataSource, ValueAccess valueAccess) {
        super(dataSource, valueAccess);
    }

    public DataSource getDataSource(){
        return this.dataSource;
    }
}
