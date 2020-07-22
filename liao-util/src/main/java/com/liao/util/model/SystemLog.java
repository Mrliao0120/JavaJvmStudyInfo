package com.liao.util.model;


import com.liao.util.base.ToString;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mu.jie on 2017/7/6.
 */
@Entity
@Table(name = "core_system_log")
public class SystemLog extends ToString {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 版本(用于乐观锁控制)
     */
    @Version
    private Integer version = 1 ;

    /** 创建时间 */
    @Column(name = "create_datetime", insertable = true, updatable = false)
    private Date createDatetime = new Date();

    /** 请求方法 */
    @Enumerated(EnumType.STRING)
    @Column(name = "method")
    private RequestMethod method;

    /** 来源 */
    @Column(name = "source")
    private String source;

    /** url */
    @Column(name = "url")
    private String url;

    /** 内容 */
    @Column(name = "content",columnDefinition = "longtext")
    private String content;

    /**
     * 是否逻辑删除
     */
    @Column(name = "is_deleted", columnDefinition = " bit(1) not null default false ")
    private boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

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

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
