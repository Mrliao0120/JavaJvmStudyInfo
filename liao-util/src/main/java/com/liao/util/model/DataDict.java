package com.liao.util.model;


import com.liao.util.base.ToString;
import com.liao.util.enums.BooleanEnum;
import com.liao.util.enums.DictDataTypeEnum;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * 数据字典
 * 使用的时候，先去找自己租户的数据，没有的话再找平台配置的字典数据。
 *
 * @author
 * @version $Id: DataDict.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_data_dict" , uniqueConstraints = {@UniqueConstraint(columnNames={"tenant_id", "code"},name = "uk_dd_tid_code")})
public class DataDict extends ToString {

    /** 数据字典编码，相当于Key值， 如 industry_type */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "assigned")
    @GeneratedValue(generator = "idGenerator")
    @Column(nullable = false, length = 200, name = "code")
    private String code;

    /** 模块名称，如 core、cms、oa 等系统 */
    @Column(length = 58, name = "module_name")
    private String moduleName;

    /** 父字典；顶层为null  */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private DataDict parent;

    /** 数据字典值, 如行业类型  */
    @NotBlank(message = "数据字典值不能为空")
    @Column(length = 100, name = "value")
    private String value;

    /** 数据字典扩展值，如行业类型=6 */
    @Column(length = 100, name = "value_ext")
    private String valueExt;

    /**
     * 数据类型 0单一值 1列表值
     * 单一值一般是系统参数，比如：密码失败锁定重试次数，某项业务的费率等，涉及到影响业务。列表值一般用于 下拉 平铺展示不会影响系统业务。
     */
    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "data_type")
    private DictDataTypeEnum dataType;

    /** 是否租户数据字典 */
    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "is_tenant")
    private BooleanEnum isTenant;

    /**
     * 是否固定不允许删除编辑<p/>
     * 值允许修改
     */
    @Column(name = "is_fixed", columnDefinition = " bit(1) not null default false ")
    private boolean fixed = false;

    /**  显示顺序(数字小的在前面) */
    @Column(name = "seq_no")
    private Integer seqNo;

    /** 版本(用于乐观锁控制)  */
    @Version
    private Integer version = 1;

    /** 启用或禁用  */
    @Column(name = "is_enabled", columnDefinition = " bit(1) not null default true ")
    private boolean enabled = true;

    /** 是否逻辑删除  */
    @Column(name = "is_deleted", columnDefinition = " bit(1) not null default false ")
    private boolean deleted = false;

    /** 创建人  */
    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = true, updatable = false)
    private User creator;

    /**
     * 这个统一为业务创建时间，也就是业务无需再添加时间字段，比如：成功支付时间。
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     */
    @Column(name = "create_datetime", insertable = true, updatable = false)
    private Date createDatetime = new Date();

    /** 修改人  */
    @ManyToOne
    @JoinColumn(name = "modifier_id")
    private User modifier;

    /**
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     * 在数据库中需要添加一个 不可见自更新 timestamp型字段，用于核对业务和数据库时间
     */
    @Column(name = "modify_datetime")
    private Date modifyDatetime;

    /** 租户  */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", insertable = true, updatable = false)
    private Tenant tenant;

    /**  详细描述或备注  */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", columnDefinition = "text", length = 65535)
    private String description;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataDict getParent() {
        return parent;
    }

    public void setParent(DataDict parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public DictDataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DictDataTypeEnum dataType) {
        this.dataType = dataType;
    }

    public BooleanEnum getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(BooleanEnum isTenant) {
        this.isTenant = isTenant;
    }

    public String getValueExt() {
        return valueExt;
    }

    public void setValueExt(String valueExt) {
        this.valueExt = valueExt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
