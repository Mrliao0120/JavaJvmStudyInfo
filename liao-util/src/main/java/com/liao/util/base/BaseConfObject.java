package com.liao.util.base;



import com.liao.util.model.Tenant;
import com.liao.util.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author
 * @version $Id: BaseConfObject.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@MappedSuperclass
@Data
public abstract class BaseConfObject extends ToString {
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
    private Integer version = 1 ;

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
     * 租户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", insertable = true, updatable = false)

    private Tenant tenant;

    /**
     * 详细描述或备注
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", columnDefinition = "text", length = 65535)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }


}
