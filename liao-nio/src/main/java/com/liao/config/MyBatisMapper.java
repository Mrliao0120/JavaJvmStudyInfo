package com.liao.config;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * @ProjectName ys-fenxiang
 * @Author LHB
 * @Data 2020/5/20 10:26
 * @Version 1.0
 * @Description
 */
public interface MyBatisMapper<T>  extends BaseMapper<T>,ExampleMapper<T>,RowBoundsMapper<T>,Marker {
}
