package com.liao.util.model;



import com.liao.util.base.BaseConfObject;

import javax.persistence.*;

/**
 * 组织机构
 *
 * @author
 * @version $Id: BizCourseObject.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_org")
public class Org extends BaseConfObject {

    /**
     * 部门名称
     */
    @Column(nullable = false, length = 120)
    private String name;

    /**
     * 父部门，顶层是null
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Org parent;

    /**
     * 显示时排序
     */
    @Column(name = "seq_no", length = 8)
    private Integer seqNo;

    /**
     * 部门级别，一般是在部门树里面的层级，顶层是1
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 从祖先到自己的顺序id全路径，分隔符为 /，以自己的id结尾
     * <p/>
     * 包含本身的id
     */
    @Column(name = "id_full_path", length = 255)
    private String idFullPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIdFullPath() {
        return idFullPath;
    }

    public void setIdFullPath(String idFullPath) {
        this.idFullPath = idFullPath;
    }
}
