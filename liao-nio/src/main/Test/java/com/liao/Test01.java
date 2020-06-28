package com.liao;

import com.liao.dao.TOrderMapper;
import com.liao.pojo.TOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/24 16:43
 * @Version 1.0
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    TOrderMapper tOrderMapper;

    @Test
    public void  set(){
        TOrder tOrder=new TOrder();
        for (int i = 0; i < 100; i++) {
            tOrder.setStatus("2");
            tOrder.setUserId(i);
            tOrderMapper.insertSelective(tOrder);
        }
    }


    @Test
    public void  set2(){
        Example example=new Example(TOrder.class);
        Example.Criteria exampleCriteria = example.createCriteria();
        Long id=484010215226736641L;
        exampleCriteria.andEqualTo("orderId",id);
        TOrder tOrder = tOrderMapper.selectOneByExample(example);
        System.out.println(tOrder);
    }
}
