package com.liao.util.model;



import com.liao.util.base.BaseMixUserObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 非站内行 的 外部  sns发送记录
 *
 * @author
 * @version $Id: OutsideSnsSendHis.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_outside_sns_send_his")
public class OutsideSnsSendHis extends BaseMixUserObject implements Serializable {
    public static final String STATUS_SEND_SUCCESS = "ok";
    public static final String STATUS_SEND_FAILED = "failed";
    public static final String STATUS_RESEND = "resend";
    /**
     * sns类别：sms,email,ww,qq,sina_weibo ,other
     */
    @Column(name = "sns_category", length = 58)
    private String snsCategory;

    /**
     * 发送目的：register,find_pwd
     */
    @Column(name = "send_purpose", length = 58)
    private String sendPurpose;

    /** 外部 邮件短信等sns类型的交互的主体  */
    @Column(name = "title", length = 200)
    private String title;

    /** sns内容 */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", columnDefinition = "text", length = 65535)
    private String content;

    //接手人类型，对于很少使用的，就无需采用 Any注解了
    @Column(name = "receiver_type", length = 58)
    private String receiverType;

    @Column(name = "receiver_id")
    private Long receiverID;

    //接收人 sns号码
    @Column(name = "receiver_sns_no", length = 100)
    private String receiverSnsNO;

    /**
     * success,failed
     */
    @Column(length = 58)
    private String status;

    @Column(name = "send_datetime")
    private Date sendDatetime = new Date();

    @Column(name = "status_result", length = 225)
    private String statusResult;

    public String getSnsCategory() {
        return snsCategory;
    }

    public void setSnsCategory(String snsCategory) {
        this.snsCategory = snsCategory;
    }

    public String getSendPurpose() {
        return sendPurpose;
    }

    public void setSendPurpose(String sendPurpose) {
        this.sendPurpose = sendPurpose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public Long getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(Long receiverID) {
        this.receiverID = receiverID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverSnsNO() {
        return receiverSnsNO;
    }

    public void setReceiverSnsNO(String receiverSnsNO) {
        this.receiverSnsNO = receiverSnsNO;
    }

    public String getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(String statusResult) {
        this.statusResult = statusResult;
    }

}
