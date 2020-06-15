package com.liao.structire.singin;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 09:45
 * @Version 1.0
 * @Description
 */
public class SingleOperation {

    private SingleList head=new SingleList();

    public  SingleList   initList(int i){
        if (i==0){
            head.setData(i);
            head.setNextData(null);
            return head;
        }
        return head;

    }



    public void add(int i){
        if (i<0){
            return;
        }
        SingleList singleList = initList(i);
        if (i>0){
            SingleList list =new SingleList();
            list.setData(i);
            while (singleList.getNextData()!=null){
                singleList=singleList.getNextData();
            }
            singleList.setNextData(list);
        }


    }


    public void  delete(int i){
        if (i<0){
            return;
        }


    }


    public SingleList  get(int i){
        SingleList singleList=head;
        for (int j = 0; j < i-1; j++) {
            singleList.getNextData();
        }
        return singleList;
    }




}
