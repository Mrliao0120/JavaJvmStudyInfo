package com.liao.util.model;

import com.liao.util.base.BaseConfObject;
import com.liao.util.enums.ResourceTypeEnum;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源
 *
 * @author Jonathan.jin
 * @version $Id: Resource.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_resource")
public class Resource extends BaseConfObject implements Serializable {

    /**
     * 资源类型:菜单、模块、操作（按钮，文字链接等）
     *
     * @see
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 58)
    private ResourceTypeEnum type;

    /**
     * 一般是中文资源名称，用于显示，诸如：商户管理（菜单类型）、新增商户
     */
    @NotBlank(message = "资源中文名不能为空")
    @Length(max = 200, message = "资源名称长度不能超过200")
    @Column(name = "name", length = 255)
    private String name;

    /**
     * 资源编码
     */
    @NotBlank(message = "资源编码不能为空")
    @Column(name = "code", length = 58, unique = true)
    private String code;

    /**
     * 父资源，顶层节点的父亲是null
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Resource parent;

    /**
     * 从祖先到自己的顺序id全路径，分隔符为 /，以自己的id结尾
     * <p>
     * 包含本身的id
     */
    @Column(name = "id_full_path", length = 255)
    private String idFullPath;

    /**
     * 图标
     * 比如菜单资源，有些地方是需要显示啥图标的
     * 如果是fp_:打头表示全路径，如果是code_打头，表示我们约定了用啥图标
     */
    @Column(name = "icon", length = 200)
    private String icon;

    /**
     * 配置的是系统内部的uri 资源，不能是完整的URL或者带ContextPath，否则会被绕过去或者不能迁移去掉ContextPath
     */
    @NotBlank(message = "uri不能为空")
    @Column(name = "uri", length = 255)
    private String uri;

    /**
     * 用于过滤http协议请求的 method
     */
    @Column(name = "http_method", length = 58)
    private String httpMethod;

    /**
     * 显示时排序
     */
//    @NotNull(message = "显示时排序不能为空")
    @Column(name = "seq_no", length = 8)
    private Integer seqNo = 0;

    /**
     * 权限提示，诸如：user:view,user:edit,user:*
     */
//    @NotBlank(message = "权限不能为空")
//    @Column(name = "permission", length = 200)
//    private String permission;

    /**
     * 是否属于租户资源
     */
    @Column(name = "is_belong_to_tenant", columnDefinition = " bit(1) not null default false ")
    private boolean belongToTenant = false;

    public ResourceTypeEnum getType() {
        return type;
    }

    public void setType(ResourceTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public String getIdFullPath() {
        return idFullPath;
    }

    public void setIdFullPath(String idFullPath) {
        this.idFullPath = idFullPath;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public boolean isBelongToTenant() {
        return belongToTenant;
    }

    public void setBelongToTenant(boolean belongToTenant) {
        this.belongToTenant = belongToTenant;
    }
}
