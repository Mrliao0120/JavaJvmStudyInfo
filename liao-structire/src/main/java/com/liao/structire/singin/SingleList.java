package com.liao.structire.singin;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 09:39
 * @Version 1.0
 * @Description  单向链表 数据结构实体
 */
public class SingleList {
    //数据
    private int data=0;

    private SingleList  nextData;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleList getNextData() {
        return nextData;
    }

    public void setNextData(SingleList nextData) {
        this.nextData = nextData;
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "data=" + data +
                ", nextData=" + nextData +
                '}';
    }
}
