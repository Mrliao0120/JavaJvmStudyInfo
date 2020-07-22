/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.model;

import com.liao.util.base.BaseCourseObj;


import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 平台账户：开在三方的账户，可能还会涉及线上、线下保证金，然后发生责任时还会涉及保证金的借贷。
 *
 * @author Jonathan.jin
 * @version $Id: PlatformAccount.java, v 0.1 2017/5/16 9:17 Jonathan.jin Exp $
 */
public class PlatformAccount extends BaseCourseObj {

    /** 平台账户类型：微信支付影子账户、支付宝影子账户、XXX银行的银子账户、所有渠道的总账户,未来可能还会涉及子账户 */
    private String accountType;

    /** 账户余额 */
    private BigDecimal accountBalance;

    /** 账户余额更新时间 */
    private Date balanceModifyDatetime;

    /** 借方发生额 */
    @Column(precision = 14, scale = 2)
    private BigDecimal debitAmount;

    /** 贷方发生额 */
    @Column(precision = 14, scale = 2)
    private BigDecimal creditAmount;

    /** 是否托管 */
    private boolean trustFlag;

    /** 托管机构：比如 XXX银行 支付宝 微信 等  */
    private String trustOrg;

    /**  托管机构编码：     */
    private String trustOrgCode;

    /** 开在三方的账号  */
    private String thirdPartAccountNo;

    private String thirdPartAccountCreateDatetime;

    /** 开在三方的账号状态  */
    private String thirdPartAccountStatus;

    @Column(name = "status")
    private String status;

    /** 当前状态创建人  */
    @Column(name = "status_creator_id")
    private Long statusCreatorID;

    @Column(name = "status_create_datetime")
    private Date statusCreateDatetime;

    /** 状态备注 */
    @Column(name = "status_memo", length = 2048)
    private String statusMemo;



}
