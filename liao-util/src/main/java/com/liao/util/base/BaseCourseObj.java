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
 * @version $Id: BizCourseObject.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@MappedSuperclass
public abstract class BaseCourseObj extends ToString {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 是否逻辑删除
     */
    @Column(name = "is_deleted", columnDefinition = " bit(1) not null default false ")
    private boolean deleted = false;

    /**
     * 当前状态
     */
    @Column(name = "status", length = 58)
    private String status;

    /**
     * 状态创建人
     */
    @Any(metaColumn = @Column(name = "status_creator_type", length = 58), fetch = FetchType.LAZY)
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = User.class, value = CommonConstants.USER_TYPE_COMMON),
                    @MetaValue(targetEntity = Member.class,
                            value = CommonConstants.USER_TYPE_MEMBER)
            })
    @JoinColumn(name = "status_creator_id", updatable = false)

    private Object statusCreator;

    /**
     * 状态创建时间
     */
    @Column(name = "status_create_datetime")
    private Date statusCreateDatetime = new Date();

    /**
     * 此字段数据库会创建，用来管理员给其备注用
     * <p/>
     * 状态备注：json格式
     * {action:   ,   detail:  }
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "status_memo", columnDefinition = "text", length = 65535)
    private String statusMemo;

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
     * 这个统一为业务创建时间，也就是业务无需再添加时间字段，比如：成功支付时间。
     * 使用应用服务器时间。  内网NTP一定要配置，保持数据库服务器和应用服务器时间保持一致
     */
    @Column(name = "create_datetime", insertable = true, updatable = false)
    private Date createDatetime = new Date();

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getStatusCreator() {
        return statusCreator;
    }

    public void setStatusCreator(Object statusCreator) {
        this.statusCreator = statusCreator;
    }

    public Date getStatusCreateDatetime() {
        return statusCreateDatetime;
    }

    public void setStatusCreateDatetime(Date statusCreateDatetime) {
        this.statusCreateDatetime = statusCreateDatetime;
    }

    public String getStatusMemo() {
        return statusMemo;
    }

    public void setStatusMemo(String statusMemo) {
        this.statusMemo = statusMemo;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
