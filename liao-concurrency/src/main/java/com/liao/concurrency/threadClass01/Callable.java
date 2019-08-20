package com.liao.concurrency.threadClass01;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/20 09:59
 * @Version 1.0
 * @Description
 */
public interface Callable<V> {

    V Call() throws Exception;

}
