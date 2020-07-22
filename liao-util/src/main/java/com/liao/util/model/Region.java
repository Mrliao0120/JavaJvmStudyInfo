package com.liao.util.model;


import com.liao.util.base.BaseMixUserObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 区域表
 * Created by Administrator on 2017/9/18 0018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ava_region")
public class Region extends BaseMixUserObject implements Serializable {

    /**
     * 名字
     */
    @Column(name = "name",nullable = false, length = 255)
    private String name;
    /**
     *上级ID
     */
    @ManyToOne
    @JoinColumn(name = "region_id")
    private  Region  regionId;
}
