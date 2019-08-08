package com.example.other.mybatisplus;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wxq
 * @date 2018-10-31
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
