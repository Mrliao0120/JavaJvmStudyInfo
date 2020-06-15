package com.liao.structire.singin;

import java.util.Objects;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 09:45
 * @Version 1.0
 * @Description
 */
public class SingleOperation {

    //头
   private Node head;
   //当前位置
   private Node current;

   private int  size;

     SingleOperation() {
        head=current=new Node(null);
        this.size=0;
    }



    public  void  index(int i){
         if (i<-1||size<-1){
                return;
         }
         if (i==-1){
             return;
         }
         //当前位置指向头部的下一个位置
         this.current=head.getNextData();

         int j=0;
         //如果头部的下一个位置不为空的话证明还有值没循环完毕  并且J如果小于I个那么也是值为空
         while ((current!=null)&&j<i){
             current=current.getNextData();
             j++;
         }

    }



    public  void  inser(int i,Object object){
        if (i<0||i>size){
            return;
        }
        //通过初始化设置  获取到要设置的值得上个节点  那么上个节点的nextData值肯定是空的
        index(i-1);
        //设置下个节点的值  设置值的节点
        current.setNextData(new Node(object,current.getNextData()));
        size++;
    }


    public Object delete(int i){
        if (size==0){
            return null;
        }
        if (i<0||i>size){
            return null;
        }
        //通过初始化设置  获取到要设置的值得上个节点   那么上个节点的nextData值肯定是空的
        index(i-1);
        //获取当前删除的数据
        Object data = current.getNextData().getData();
        //设置值   将当前节点的值设置为要删除的下个值得值
        // 比如  1  2  3  当前删除2  current当前是1 设置值肯定是2的下个值 3
        current.setNextData(current.getNextData().getNextData());
        size--;

        return data;
    }

    public  Object  get(int i){
        index(i);
        Object data = current.getData();
        if (Objects.nonNull(data)){
            return data;
        }
        return null;
    }




}
