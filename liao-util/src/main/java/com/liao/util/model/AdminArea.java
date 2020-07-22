package com.liao.util.model;

import com.liao.util.base.BaseConfObject;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 省市县区行政区划
 *
 * @author
 * @version $Id: AdminArea.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_admin_area")
public class AdminArea extends BaseConfObject implements Serializable {
    /**
     * 截至到2016年底的直辖市
     */
    public static List<Long> municipalityIDList = new ArrayList<Long>();

    static {
        municipalityIDList.add(110000L);
        municipalityIDList.add(120000L);
        municipalityIDList.add(310000L);
        municipalityIDList.add(500000L);
    }

    /**
     * 父新政区划；顶层为null
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private AdminArea parent;

    /**
     * province:省
     * city:市
     * district: 区
     * logic:逻辑节点，不如市辖区 县 旗等。
     * street
     */
    @Column(length = 58, nullable = false)
    private String type;

    /**
     * 基本应该是放拼音，为了支持汉语拼音模糊查询智能联想用。
     */
    @Column(length = 44, nullable = false)
    private String name;

    @Column(length = 200)
    private String value;    //北京，我们可以手工把一个名字给改了。

    @Column(columnDefinition = " int(3) not null default 1")
    private Integer level;

    @Column(name = "seq_no", length = 8)
    private Integer seqNo;

    @Column(name = "full_id_path", length = 100)
    private String fullIDPath;  //use _ to split the id

    @Column(name = "full_value_path", length = 200)
    private String fullValuePath;  //浙江省-杭州市-西湖区

    @Column(name = "latitude")
    private Double latitude;     //纬度

    @Column(name = "longitude")
    private Double longitude;   //经度

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<AdminArea> childRen = new ArrayList<AdminArea>();*/

    public AdminArea getParent() {
        return parent;
    }

    public void setParent(AdminArea parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getFullIDPath() {
        return fullIDPath;
    }

    public void setFullIDPath(String fullIDPath) {
        this.fullIDPath = fullIDPath;
    }

    public String getFullValuePath() {
        return fullValuePath;
    }

    public void setFullValuePath(String fullValuePath) {
        this.fullValuePath = fullValuePath;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
