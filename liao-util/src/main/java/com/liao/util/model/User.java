package com.liao.util.model;



import com.liao.util.base.BaseConfObject;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.liao.util.utils.RandomNumberUtil.randomUUIDString;


/**
 * @author
 * @version $Id: User.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_user")
public class User extends BaseConfObject implements Serializable {

    public static final String ADMIN = "admin";

    /**
     * token,唯一标识,替代userId
     */
    @Column(length = 255, unique = true, insertable = true, updatable = false)
    private String token = randomUUIDString();

    /**
     * 用户名，唯一
     */
    @NotEmpty(message = "用户名不能为空")
    @Column(length = 100, unique = true, nullable = false)
    private String username;

    /**
     * 所属部门
     */
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Org org;





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
     * 用户角色关联
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "core_user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roleSet = new HashSet<>();

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

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserExt userExt;

    public User() {
    }

    public User(final String username) {
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

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
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

    public UserExt getUserExt() {
        return userExt;
    }

    public void setUserExt(UserExt userExt) {
        this.userExt = userExt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        final User servant = (User) o;

        return !(username != null ? !username.equals(servant.getUsername()) : servant.getUsername() != null);
    }

    @Override
    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }


}
