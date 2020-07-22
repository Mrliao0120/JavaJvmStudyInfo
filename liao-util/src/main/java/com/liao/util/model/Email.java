package com.liao.util.model;


import com.liao.util.base.BaseMixUserObject;


import com.liao.util.enums.BooleanEnum;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 邮件实体
 */
@Entity
@Table(name = "core_email")
public class Email extends BaseMixUserObject {

    /**
     * module：记录是哪个模块发出的
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 2147483647)
    private String content;

    /**
     * 发送人
     */
    private String sender;

    /**
     * 接收人,多用户用;隔开，如a@163.com;b@qq.com
     */
    @Column(name = "email_to",length = 1024000)
    private String to;

    /**
     * 抄送人
     */
    @Column(name = "email_cc",length = 1024000)
    private String cc;

    /**
     * 密送
     */
    @Column(name = "email_bcc",length = 1024000)
    private String bcc;

    /**
     * 是否已经发送
     */
    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "is_send")
    private BooleanEnum isSend = BooleanEnum.NO;

    /**
     * 是否发送成功
     */
    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "is_success")
    private BooleanEnum isSuccess;

    /**
     * 返回结果信息
     */
    @Column(name = "return_code",length = 1024)
    private String returnCode;

    /**
     * 邮件-附件关联表
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "core_email_attach",
            joinColumns = { @JoinColumn(name = "email_id") },
            inverseJoinColumns = @JoinColumn(name = "attach_id")
    )
    private Set<Attach> attachSet = new HashSet<>();

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public BooleanEnum getIsSend() {
        return isSend;
    }

    public void setIsSend(BooleanEnum isSend) {
        this.isSend = isSend;
    }

    public BooleanEnum getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(BooleanEnum isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Set<Attach> getAttachSet() {
        return attachSet;
    }

    public void setAttachSet(Set<Attach> attachSet) {
        this.attachSet = attachSet;
    }
}
