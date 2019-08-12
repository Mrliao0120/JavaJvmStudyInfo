package com.liao.jvm.oom;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/12 16:28
 * @Version 1.0
 * @Description  多线程测试  电脑不好不要测试！！！！
 */
public class JavaVMMulitiThering {



    private void dontStop(){
        while (true){

        }
    }

    private void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }

    }

    /**
     * vm args: -Xss2m
     * @param args
     */
    public static void main(String[] args) {
        JavaVMMulitiThering  javaVMMulitiThering=new JavaVMMulitiThering();
        javaVMMulitiThering.stackLeakByThread();
    }


}
