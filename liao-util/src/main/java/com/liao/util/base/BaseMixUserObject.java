package com.liao.util.base;






import com.liao.util.model.Member;
import com.liao.util.model.Tenant;
import com.liao.util.model.User;
import com.liao.util.utils.CommonConstants;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.util.Date;

/**
 * @author
 * @version $Id: BaseMixUserObject.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@MappedSuperclass
public abstract class BaseMixUserObject extends ToString {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 版本(用于乐观锁控制)
     */
//    @Version
//    private Integer version;

    /**
     * 是否逻辑删除
     */
    @Column(name = "is_deleted", columnDefinition = " bit(1) not null default false ")
    private boolean deleted = false;

    /**
     * 记录业务创建人
     */
    @Any(metaColumn = @Column(name = "creator_type", length = 58, updatable = false),
            fetch = FetchType.LAZY)
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = User.class, value = CommonConstants.USER_TYPE_COMMON),
                    @MetaValue(targetEntity = Member.class,
                            value = CommonConstants.USER_TYPE_MEMBER)
            })
    @JoinColumn(name = "creator_id", updatable = false)
    private Object creator;

    /**
     * 记录业务创建人
     */
    @Any(metaColumn = @Column(name = "modifier_type", length = 58), fetch = FetchType.LAZY)
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = User.class, value = CommonConstants.USER_TYPE_COMMON),
                    @MetaValue(targetEntity = Member.class,
                            value = CommonConstants.USER_TYPE_MEMBER)
            })
    @JoinColumn(name = "modifier_id")

    private Object modifier;

    /**
     * 这个统一为业务创建时间，也就是业务无需再添加时间字段，比如：成功支付时间。
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     */
    @Column(name = "create_datetime", insertable = true, updatable = false)
    private Date createDatetime = new Date();

    /**
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     * 在数据库中需要添加一个 不可见自更新 timestamp型字段，用于核对业务和数据库时间
     */
    @Column(name = "modify_datetime")
    private Date modifyDatetime = new Date();

    /**
     * 租户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", insertable = true, updatable = false)
    private Tenant tenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Object getModifier() {
        return modifier;
    }

    public void setModifier(Object modifier) {
        this.modifier = modifier;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
