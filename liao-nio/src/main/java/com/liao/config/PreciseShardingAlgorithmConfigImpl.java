package com.liao.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/28 10:49
 * @Version 1.0
 * @Description
 */
public class PreciseShardingAlgorithmConfigImpl implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String dbName = "ds";
        Long val = preciseShardingValue.getValue();
        dbName += val;
        for (String each : collection) {
            if (each.equals(dbName)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
