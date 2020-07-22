package com.liao.util.model;


import com.liao.util.enums.GenderEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员扩展
 *
 * @author Jonathan.jin
 * @version $Id: MemberExt.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 * @TODO：使用枚举加1个或多个大的JSON串来存各种可扩展的爱好，各种联系方式等。
 */
@Entity
@Table(name = "core_member_ext")
public class MemberExt implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "foreignGenerator")
    @GenericGenerator(name = "foreignGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "member"))
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Member member;

    /**
     * 自我介绍
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "introduce", columnDefinition = "text")
    private String introduce;

    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 20)
    private GenderEnum gender;


    /**
     * 昵称
     */
    @Column(name = "nick_name", length = 1024)
    private String nickName;


    /**
     * 真实姓名
     */
    @Column(name = "real_name", length = 100)
    private String realName;

/*    @ManyToOne
    @JoinColumn(name = "root_country_id")
    private AdminArea country;   //籍贯国家 ，目前该值自动全部是中国，没有别的国家选择*/

    /**
     * 籍贯-省
     */
    @ManyToOne
    @JoinColumn(name = "root_province_id")
    private AdminArea province;

    /**
     * 籍贯-市
     */
    @ManyToOne
    @JoinColumn(name = "root_city_id")
    private AdminArea city;

    /**
     * 籍贯-县或区
     */
    @ManyToOne
    @JoinColumn(name = "root_district_id")
    private AdminArea district;

    /**
     * 居住地-省
     */
    @ManyToOne
    @JoinColumn(name = "resident_province_id")
    private AdminArea residentProvince;

    /**
     * 居住地-市
     */
    @ManyToOne
    @JoinColumn(name = "resident_city_id")
    private AdminArea residentCity;

    /**
     * 居住地-县或区
     */
    @ManyToOne
    @JoinColumn(name = "resident_district_id")
    private AdminArea residentDistrict;

    /**
     * 联系地址
     */
    @Column(name = "address", length = 200)
    private String address;

    /**
     * 邮政编码
     */
    @Column(name = "postal_code")
    private String postalCode;


    /**
     * 身高
     */
    @Column(length = 3)
    private Integer height;

    /**
     * 体重
     */
    @Column(length = 3)
    private Integer weight;

    /**
     * 腰围
     */
    @Column(length = 3)
    private Integer waist;

    /**
     * 臀围
     */
    @Column(length = 3)
    private Integer hip;

    /**
     * 胸围
     */
    @Column(length = 3)
    private Integer chest;

    /**
     * 腿长
     */
    @Column(length = 3)
    private Integer leg;

    /**
     * 肩膀长
     */
    @Column(length = 3)
    private Integer shoulder;

    /**
     * 血型
     * 为防止偏差可以使用select，让用户选择
     */
    @Column(name = "blood_type", length = 16)
    private String bloodType;

    /**
     * 阳历生日 然后自动计算星座和阴历生日
     */
    @Column(name = "birthday", length = 10)
    private String birthday;

    /**
     * 用户名签名
     */
    @Column(name = "user_name_sign", length = 255)
    private String userNameSign;

    /**
     * 发帖签名
     */
    @Column(name = "post_sign", length = 88)
    private String postSign;

    /**
     * 喜欢的运动
     */
    @Column(name = "loved_sports", length = 255)
    private String lovedSports;

    /**
     * 喜欢的电影
     */
    @Column(name = "loved_movies", length = 255)
    private String lovedMovies;

    /**
     * 喜欢的音乐
     */
    @Column(name = "loved_musics", length = 255)
    private String lovedMusics;

    /**
     * 喜欢的食物
     */
    @Column(name = "loved_foods", length = 255)
    private String lovedFoods;

    /**
     * 喜欢的书
     */
    @Column(name = "loved_books", length = 255)
    private String lovedBooks;

    /**
     * 喜欢的游戏
     */
    @Column(name = "loved_games", length = 255)
    private String lovedGames;

    /**
     * 微信
     */
    @Column(name = "we_chat", length = 255)
    private String weChat;

    @Column(name = "createDatetime")
    private Date createDatetime = new Date();

/*    @OneToOne(mappedBy="owner",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private UserSpace userSpace;   // sns 化的用户空间*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AdminArea getProvince() {
        return province;
    }

    public void setProvince(AdminArea province) {
        this.province = province;
    }

    public AdminArea getCity() {
        return city;
    }

    public void setCity(AdminArea city) {
        this.city = city;
    }

    public AdminArea getDistrict() {
        return district;
    }

    public void setDistrict(AdminArea district) {
        this.district = district;
    }

    public AdminArea getResidentProvince() {
        return residentProvince;
    }

    public void setResidentProvince(AdminArea residentProvince) {
        this.residentProvince = residentProvince;
    }

    public AdminArea getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(AdminArea residentCity) {
        this.residentCity = residentCity;
    }

    public AdminArea getResidentDistrict() {
        return residentDistrict;
    }

    public void setResidentDistrict(AdminArea residentDistrict) {
        this.residentDistrict = residentDistrict;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHip() {
        return hip;
    }

    public void setHip(Integer hip) {
        this.hip = hip;
    }

    public Integer getChest() {
        return chest;
    }

    public void setChest(Integer chest) {
        this.chest = chest;
    }

    public Integer getLeg() {
        return leg;
    }

    public void setLeg(Integer leg) {
        this.leg = leg;
    }

    public Integer getShoulder() {
        return shoulder;
    }

    public void setShoulder(Integer shoulder) {
        this.shoulder = shoulder;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserNameSign() {
        return userNameSign;
    }

    public void setUserNameSign(String userNameSign) {
        this.userNameSign = userNameSign;
    }

    public String getPostSign() {
        return postSign;
    }

    public void setPostSign(String postSign) {
        this.postSign = postSign;
    }

    public String getLovedSports() {
        return lovedSports;
    }

    public void setLovedSports(String lovedSports) {
        this.lovedSports = lovedSports;
    }

    public String getLovedMovies() {
        return lovedMovies;
    }

    public void setLovedMovies(String lovedMovies) {
        this.lovedMovies = lovedMovies;
    }

    public String getLovedMusics() {
        return lovedMusics;
    }

    public void setLovedMusics(String lovedMusics) {
        this.lovedMusics = lovedMusics;
    }

    public String getLovedFoods() {
        return lovedFoods;
    }

    public void setLovedFoods(String lovedFoods) {
        this.lovedFoods = lovedFoods;
    }

    public String getLovedBooks() {
        return lovedBooks;
    }

    public void setLovedBooks(String lovedBooks) {
        this.lovedBooks = lovedBooks;
    }

    public String getLovedGames() {
        return lovedGames;
    }

    public void setLovedGames(String lovedGames) {
        this.lovedGames = lovedGames;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
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
