package com.liao.util.model;



import com.liao.util.base.BaseMixUserObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * sns发送模版，电子邮件和短信模版现在因为国家监管都放出去了，现在只能做站内信旺旺qq等模版了
 *
 * @author
 * @version $Id: SnsTemplate.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_sns_template")
public class SnsTemplate extends BaseMixUserObject implements Serializable {
    public static final String CATEGORY_EMAIL = "email";  //电子邮件类型
    public static final String CATEGORY_SMS = "sms";  //sms类型

    public static final String PURPOSE_REG_VERIFY = "reg_verify"; //注册校验
    public static final String PURPOSE_EMAIL_MODIFY = "email_modify"; //邮箱校验
    public static final String PURPOSE_MOBILE_MODIFY = "mobile_modify"; //手机校验
    public static final String PURPOSE_PASSWORD_FORGOT = "password_forgot"; //密码找回

    /**
     * sns类型  :email , sms   ,email ,  ww, pfMsg
     */
    @Column(name = "sns_category", length = 58)
    private String snsCategory;

    /**
     * 模板目的
     * <p/>
     * password_recovery:找回密码
     * register_activate:账号激活
     * password_update_notify:密码修改通知
     */
    @Column(name = "purpose", length = 58)
    private String purpose;

    @Column(name = "title", length = 200)
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", columnDefinition = "text", length = 65535)
    private String content;

    public String getSnsCategory() {
        return snsCategory;
    }

    public void setSnsCategory(String snsCategory) {
        this.snsCategory = snsCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
