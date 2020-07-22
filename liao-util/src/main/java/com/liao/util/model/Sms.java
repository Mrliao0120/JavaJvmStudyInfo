package com.liao.util.model;




import com.liao.util.base.BaseMixUserObject;
import com.liao.util.enums.BooleanEnum;

import javax.persistence.*;
import java.util.Date;


/**
 * 短信实体
 */
@Entity
@Table(name = "core_sms")
public class Sms extends BaseMixUserObject {

    /**
     * module：记录是哪个模块发出的
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 指定发送时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 接收人号码
     */
    @Column(name = "sms_to_no",length = 1024000)
    private String toNo;

    /**
     * 接收人姓名
     */
    @Column(name = "sms_to_name",length = 1024000)
    private String toName;

    /**
     * 是否已经发送
     */
    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "is_send")
    private BooleanEnum isSend = BooleanEnum.NO;

    /**
     *  发送次数
     */
    @Column(name = "send_count")
    private Integer sendCount = 0;

    /**
     * 署名
     */
    private String sign;

    /**
     * 返回结果信息
     */
    @Column(name = "return_code",length = 1024)
    private String returnCode;

    /**
     * 模板ID
     */
    private String template;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getToNo() {
        return toNo;
    }

    public void setToNo(String toNo) {
        this.toNo = toNo;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public BooleanEnum getIsSend() {
        return isSend;
    }

    public void setIsSend(BooleanEnum isSend) {
        this.isSend = isSend;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }
}
