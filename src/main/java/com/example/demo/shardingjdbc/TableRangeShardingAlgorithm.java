package com.example.demo.shardingjdbc;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wxq
 * @date 2018-11-01
 */
public class TableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> rangeShardingValue) {
        int size = availableTargetNames.size();
        Collection<String> collect = new ArrayList<>();
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        for (Long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % size + "")) {
                    collect.add(each);
                }
            }
        }
        return collect;
    }
}
