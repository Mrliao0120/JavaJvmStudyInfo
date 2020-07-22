package com.liao.util.model;


import com.liao.util.base.BaseMixUserObject;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.liao.util.utils.RandomNumberUtil.randomUUIDString;


/**
 * 会员
 *
 * @author
 * @version $Id: Member.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_member")
public class Member extends BaseMixUserObject implements Serializable {
    /**
     * token,唯一标识,替代userId
     */
    @Column(length = 255, unique = true, insertable = true, updatable = false)
    private String token = randomUUIDString();

    /**
     * 用户名，唯一
     */
//    @NotEmpty(message = "用户名不能为空")
    @Column(length = 100, unique = true, nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false, length = 66)
    private String password;

    /**
     * 重复密码
     */
    @Transient
    private String confirmPassword;

    /**
     * 手机号码
     */
    @Column(length = 50)
    private String mobile;

    /**
     * 电子邮箱
     */
    @Column(name = "email", length = 108)
    private String email;

    /**
     * 会员logo路径
     */
    @ManyToOne
    @JoinColumn(name = "logo_id")
    private Picture logo;

    /**
     * 最近登录ip
     */
    @Column(name = "last_login_ip", length = 64)
    private String lastLoginIP;

    /**
     * 最近登录时间
     */
    @Column(name = "last_login_datetime")
    private Date lastLoginDatetime = new Date();

    /**
     * 账户过期
     */
    @Column(name = "is_account_expired", columnDefinition = " bit(1) not null default false ")
    private boolean accountExpired = false;

    /**
     * 账户锁定
     */
    @Column(name = "is_account_locked", columnDefinition = " bit(1) not null default false ")
    private boolean accountLocked = false;

    /**
     * 密码过期
     */
    @Column(name = "is_credential_expired", columnDefinition = " bit(1) not null default false ")
    private boolean credentialsExpired = false;

    /**
     * 会员扩展表
     */
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MemberExt memberExt;

    /**
     * 身份认证表
     */
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    private MemberRealNameAuth memberRealNameAuth;


    public Member() {
    }

    public Member(final String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public MemberExt getMemberExt() {
        return memberExt;
    }

    public void setMemberExt(MemberExt memberExt) {
        this.memberExt = memberExt;
    }

    public Picture getLogo() {
        return logo;
    }

    public void setLogo(Picture logo) {
        this.logo = logo;
    }

    public MemberRealNameAuth getMemberRealNameAuth() {
        return memberRealNameAuth;
    }

    public void setMemberRealNameAuth(MemberRealNameAuth memberRealNameAuth) {
        this.memberRealNameAuth = memberRealNameAuth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }

        final Member member = (Member) o;

        return !(username != null ? !username.equals(member.getUsername()) : member.getUsername() != null);
    }

    @Override
    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }


    /**
     * 以短格式的方式输出对象属性
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
