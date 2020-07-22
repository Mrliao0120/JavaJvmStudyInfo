package com.liao.util.model;



import com.liao.util.base.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 租户
 *
 * @author
 * @version $Id: Tenant.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_tenant")
public class Tenant extends ToString {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 版本(用于乐观锁控制)
     */
    @Version
    private Integer version;

    /**
     * 租户名称---也就是公司名称
     */
    @NotBlank
    @Column(name = "name", length = 100)
    private String name;

    /**
     * 租户编码, @TODO: 编码规则要定下来
     */
    @Column(name = "code", length = 58,unique = true, nullable = false)
    private String code;

    /**
     * 公司logo路径
     */
    @ManyToOne
    @JoinColumn(name = "logo_id")
    private Picture logo;

    /**
     * 省
     */
    @ManyToOne
    @JoinColumn(name = "province_id")
    private AdminArea province;

    /**
     * 市
     */
    @ManyToOne
    @JoinColumn(name = "city_id")
    private AdminArea city;

    /**
     * 区或县
     */
    @ManyToOne
    @JoinColumn(name = "district_id")
    private AdminArea district;

    /**
     * 联系地址(街道等信息)
     */
    @Column(name = "address", length = 108)
    private String address;

    /**
     * 联系人姓名
     */
    @Column(name = "contact_name", length = 88)
    private String contactName;

    /**
     * 联系号码:手机或固话
     */
    @Column(name = "contact_tel", length = 66)
    private String contactTel;


    /**
     * 启用或禁用
     */
    @Column(name = "is_enabled", columnDefinition = " bit(1) not null default true ")
    private boolean enabled = true;

    /**
     * 是否逻辑删除
     */
    @Column(name = "is_deleted", columnDefinition = " bit(1) not null default false ")
    private boolean deleted = false;

    /**
     * 创建人
     */
    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = true, updatable = false)
    private User creator;

    /**
     * 这个统一为业务创建时间，也就是业务无需再添加时间字段，比如：成功支付时间。
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     */
    @Column(name = "create_datetime", insertable = true, updatable = false)
    private Date createDatetime = new Date();

    /**
     * 修改人
     */
    @ManyToOne
    @JoinColumn(name = "modifier_id")
    private User modifier;

    /**
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     * 在数据库中需要添加一个 不可见自更新 timestamp型字段，用于核对业务和数据库时间
     */
    @Column(name = "modify_datetime")
    private Date modifyDatetime;

    /**
     * 详细描述或备注
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", columnDefinition = "text", length = 65535)
    private String description;

    /**
     * 租户资源关联
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "core_tenant_resource",
            joinColumns = { @JoinColumn(name = "tenant_id") },
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> resourceSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture getLogo() {
        return logo;
    }

    public void setLogo(Picture logo) {
        this.logo = logo;
    }

    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }

    public AdminArea getProvince() {
        return province;
    }

    public void setProvince(AdminArea province) {
        this.province = province;
    }

    public AdminArea getCity() {
        return city;
    }

    public void setCity(AdminArea city) {
        this.city = city;
    }

    public AdminArea getDistrict() {
        return district;
    }

    public void setDistrict(AdminArea district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

}