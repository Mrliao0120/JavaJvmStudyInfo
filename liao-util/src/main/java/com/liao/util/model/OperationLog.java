package com.liao.util.model;




import com.liao.util.base.ToString;

import com.liao.util.enums.OperationTypeEnum;
import com.liao.util.utils.CommonConstants;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhang.wen.chao on 2017/7/21 17:12.
 */

/**
 * 操作日志
 */
@Entity
@Table(name = "core_operation_log")
public class OperationLog extends ToString {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * ip地址
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 操作人
     */
    @Any(metaColumn = @Column(name = "operation_owner", length = 58, updatable = false),
            fetch = FetchType.LAZY)
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = User.class, value = CommonConstants.USER_TYPE_COMMON),
                    @MetaValue(targetEntity = Member.class,
                            value = CommonConstants.USER_TYPE_MEMBER)
            })
    @JoinColumn(name = "operator_id", updatable = false)
    private Object operator;

    /**
     * 栏目
     */
    @Column(name = "module")
    private String module;

    /**
     * 操作时间
     */
    @Column(name = "operation_datetime", updatable = false)
    private Date operationDatetime = new Date();

    /**
     * 操作类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationTypeEnum operationType;

    @Column(name = "content")
    private String content;

    public OperationLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getOperator() {
        return operator;
    }

    public void setOperator(Object operator) {
        this.operator = operator;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Date getOperationDatetime() {
        return operationDatetime;
    }

    public void setOperationDatetime(Date operationDatetime) {
        this.operationDatetime = operationDatetime;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
