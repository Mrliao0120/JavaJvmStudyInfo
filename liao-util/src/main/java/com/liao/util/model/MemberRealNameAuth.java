package com.liao.util.model;


import com.liao.util.base.BaseMixUserObject;

import com.liao.util.enums.AuditStatusEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "core_member_real_name_auth")
public class MemberRealNameAuth extends BaseMixUserObject {

    @OneToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "member_id",referencedColumnName = "id",unique = true)
    private Member member;

    @Column(name = "real_name", length = 88)
    @Length(min = 2, max = 38)
    //@NotBlank(message="真实姓名不能为空")
    private String realName;

    @Column(name = "id_card_no", length = 88)
    //@Length(min = 15,max = 18,message = "身份证号码错误")
    private String idCardNo;   //@TODO:后台审核时注意身份照号码的唯一性。

    @Temporal(TemporalType.DATE)
    @Column(name = "id_card_expire_date")
    private Date idCardExpireDate; //身份证到期时间

    @Column(name = "is_id_card_long_time_valid",
            columnDefinition = " bit(1) not null default false ")
    private boolean isIDCardLongTimeValid = false;

    @ManyToOne
    @JoinColumn(name = "id_card_front_pic_id")
    private Picture idCardFrontPic;       //身份证正面照

    @ManyToOne
    @JoinColumn(name = "id_card_back_pic_id", nullable = true)
    private Picture idCardBackPic;          //身份证背面照

    @ManyToOne
    @JoinColumn(name = "head_with_id_card_pic_id")
    private Picture headWithIDCardPic;        //手持身份证头部照 //也可以考虑使用onetoone cascade.all

    //    @ManyToOne
    //    @JoinColumn(name = "half_body_pic_id")
    //    private Picture halfBodyPic;       //半身照

    @Enumerated(EnumType.STRING)
    @Column(name = "audit_status", length = 58)
    private AuditStatusEnum auditStatus = AuditStatusEnum.AUDIT_WAIT;

    @Column(name = "auth_datetime")
    private Date authDatetime;       //验证发起时间

    @Column(name = "audit_datetime")
    private Date auditDatetime;       //审核处理时间

    @Column(name = "remark", length = 88)
    private String remark;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Date getIdCardExpireDate() {
        return idCardExpireDate;
    }

    public void setIdCardExpireDate(Date idCardExpireDate) {
        this.idCardExpireDate = idCardExpireDate;
    }

    public boolean isIDCardLongTimeValid() {
        return isIDCardLongTimeValid;
    }

    public void setIDCardLongTimeValid(boolean isIDCardLongTimeValid) {
        this.isIDCardLongTimeValid = isIDCardLongTimeValid;
    }

    public Picture getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(Picture idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    public Picture getIdCardBackPic() {
        return idCardBackPic;
    }

    public void setIdCardBackPic(Picture idCardBackPic) {
        this.idCardBackPic = idCardBackPic;
    }

    public Picture getHeadWithIDCardPic() {
        return headWithIDCardPic;
    }

    public void setHeadWithIDCardPic(Picture headWithIDCardPic) {
        this.headWithIDCardPic = headWithIDCardPic;
    }

    public AuditStatusEnum getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatusEnum auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuthDatetime() {
        return authDatetime;
    }

    public void setAuthDatetime(Date authDatetime) {
        this.authDatetime = authDatetime;
    }

    public Date getAuditDatetime() {
        return auditDatetime;
    }

    public void setAuditDatetime(Date auditDatetime) {
        this.auditDatetime = auditDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
