package com.liao.concurrency.conllen;

import java.util.concurrent.ThreadFactory;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2021/1/26 17:25
 * @Version 1.0
 * @Description
 */
public class ThreadFactoryAware implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
