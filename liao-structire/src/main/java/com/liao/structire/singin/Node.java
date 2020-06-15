package com.liao.structire.singin;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 09:39
 * @Version 1.0
 * @Description  单向链表 数据结构实体
 */
public class Node {
    //数据
    private Object data;

    private Node nextData;

    public Node(Node nextData) {
        this.nextData = nextData;
    }


    public Node(Object object, Node nextDataVal) {
        data = object;
        nextData = nextDataVal;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNextData() {
        return nextData;
    }

    public void setNextData(Node nextData) {
        this.nextData = nextData;
    }
}
