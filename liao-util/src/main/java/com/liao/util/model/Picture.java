package com.liao.util.model;


import com.liao.util.base.BaseMixUserObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 图片存库
 *
 * @author
 * @version $Id: Picture.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_picture")
public class Picture extends BaseMixUserObject implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(Picture.class);

    //图形存储相对路径
    @Column(name = "relative_folder")
    private String relativeFolder;

    //新生成的唯一图片名称
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    //图片原始名字
    @Column(name = "org_name", length = 125)
    private String orgName;

    //图片存放在第三方的相对url。
    @Column(name = "remote_relative_url", length = 300)
    private String remoteRelativeUrl;

    //  图片大小
    @Column(length = 8)
    private Integer size;

    /**
     * 图片所属类型
     * user_logo:用户头像
     */
    @Column(name = "host_type", length = 58)
    private String hostType;

    //图片宿主 id
    @Column(name = "host_id")
    private Long hostID;

    @Column(length = 6)
    private Integer width;

    @Column(length = 6)
    private Integer height;

    /** 图片所属系统名 */
    @Column(name = "system", length = 58)
    private String system;

    //照片描述
    @Column(name = "description", length = 255)
    private String description;

    public String getRelativeFolder() {
        return relativeFolder;
    }

    public void setRelativeFolder(String relativeFolder) {
        this.relativeFolder = relativeFolder;
    }

    public String getRemoteRelativeUrl() {
        return remoteRelativeUrl;
    }

    public void setRemoteRelativeUrl(String remoteRelativeUrl) {
        this.remoteRelativeUrl = remoteRelativeUrl;
    }

    @Transient
    public String getLocaleUrl() {
        return relativeFolder.endsWith("/") ? relativeFolder + name : relativeFolder + "/" + name;
    }

    /**
     * 这块后面会修改逻辑，就是根据一个变量决定从本地读还是远程读，第一期默认从本机读
     *
     * @return
     */
    @Transient
    public String getPicUrl() {
        return relativeFolder.endsWith("/") ? relativeFolder + name : relativeFolder + "/" + name;
    }

    //返回以长边为标准
    @Transient
    public String getFormatPicSize(int formatHeight, int formatWidth) {
        try {
            if (height / width > formatHeight / formatWidth) {
                return "height='" + formatHeight + "'";
            } else {
                return "width='" + formatWidth + "'";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public Long getHostID() {
        return hostID;
    }

    public void setHostID(Long hostID) {
        this.hostID = hostID;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
