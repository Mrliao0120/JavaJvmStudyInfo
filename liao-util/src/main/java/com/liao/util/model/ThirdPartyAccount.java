package com.liao.util.model;


import com.liao.util.base.BaseConfObject;
import com.liao.util.enums.ThirdPartyAccountTypeEnum;


import javax.persistence.*;

/**
 * 第三方账户
 * Created by mu.jie on 2017/5/11.
 */
@Entity
@Table(name = "core_third_party_account", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "identity"})})
public class ThirdPartyAccount extends BaseConfObject {

    /**
     * 第三方账户名称
     */
    @Column(name = "name", length = 1024)
    private String name;

    /**
     * 第三方账户类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 20, updatable = false, nullable = false)
    private ThirdPartyAccountTypeEnum accountType;

    /**
     * 第三方账户唯一标识
     */
    @Column(name = "identity", length = 66, updatable = false, nullable = false)
    private String accountIdentity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThirdPartyAccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(ThirdPartyAccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public String getAccountIdentity() {
        return accountIdentity;
    }

    public void setAccountIdentity(String accountIdentity) {
        this.accountIdentity = accountIdentity;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
