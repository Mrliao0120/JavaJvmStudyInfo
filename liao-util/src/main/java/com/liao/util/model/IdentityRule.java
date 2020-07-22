package com.liao.util.model;



import com.liao.util.base.BaseConfObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 唯一键生成控制
 *
 * @author
 * @version $Id: IdentityRule.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_identity_rule")
public class IdentityRule extends BaseConfObject implements Serializable {
    //规则编码
    @Column(name = "rule_code", length = 58, nullable = false)
    private String ruleCode;

    //规则名称
    @Column(name = "rule_name", length = 64, nullable = false)
    private String ruleName;

    //当前值
    @Column(name = "current_value", nullable = false)
    private Integer currentValue;

    //编号长度
    @Column(name = "rule_length", nullable = false)
    private Integer ruleLength;

    //编号前缀
    @Column(name = "rule_prefix", length = 58)
    private String rulePrefix;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getRuleLength() {
        return ruleLength;
    }

    public void setRuleLength(Integer ruleLength) {
        this.ruleLength = ruleLength;
    }

    public String getRulePrefix() {
        return rulePrefix;
    }

    public void setRulePrefix(String rulePrefix) {
        this.rulePrefix = rulePrefix;
    }

}
