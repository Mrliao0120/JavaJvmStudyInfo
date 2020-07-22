package com.liao.util.model;



import com.liao.util.base.BaseMixUserObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * token 验证助手
 *
 * @author
 * @version $Id: TokenAuthAider.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_token_auth_aider")
public class TokenAuthAider extends BaseMixUserObject implements Serializable {
    public static final String SNS_TYPE_SMS   = "sms";  //sms类型
    public static final String SNS_TYPE_EMAIL = "email";  //电子邮箱类型

    //用户类型，参考枚举类
    @Column(name = "user_type", length = 58)
    private String userType;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "sns_type", length = 58)
    private String snsType;   // sms or email

    @Column(name = "sns_no", length = 88)
    private String snsNO;  // 手机号码或email号码

    @Column(name = "auth_purpose", length = 58)
    private String authPurpose;  // 验证码用途：找回密码验证，注册验证，安全验证

    @Column(name = "auth_sn", length = 64)
    private String authSN;  //发送的验证码

    @Column(name = "auth_datetime")
    private Date authDatetime;       //验证发起时间

    @Column(name = "auth_expired_datetime")
    private Date authExpiredDatetime;  //验证过期时间，即需要重新验证。

    @Column(name = "is_valid_token", columnDefinition = " bit(1) not null default true ")
    private boolean isValidToken = true;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthSN() {
        return authSN;
    }

    public void setAuthSN(String authSN) {
        this.authSN = authSN;
    }

    public String getAuthPurpose() {
        return authPurpose;
    }

    public void setAuthPurpose(String authPurpose) {
        this.authPurpose = authPurpose;
    }

    public Date getAuthDatetime() {
        return authDatetime;
    }

    public void setAuthDatetime(Date authDatetime) {
        this.authDatetime = authDatetime;
    }

    public Date getAuthExpiredDatetime() {
        return authExpiredDatetime;
    }

    public void setAuthExpiredDatetime(Date authExpiredDatetime) {
        this.authExpiredDatetime = authExpiredDatetime;
    }

    public String getSnsType() {
        return snsType;
    }

    public void setSnsType(String snsType) {
        this.snsType = snsType;
    }

    public String getSnsNO() {
        return snsNO;
    }

    public void setSnsNO(String snsNO) {
        this.snsNO = snsNO;
    }

    public boolean isValidToken() {
        return isValidToken;
    }

    public void setValidToken(boolean isValidToken) {
        this.isValidToken = isValidToken;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
