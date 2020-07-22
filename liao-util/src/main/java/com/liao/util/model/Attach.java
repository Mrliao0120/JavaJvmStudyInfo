package com.liao.util.model;

import com.liao.util.base.BaseMixUserObject;
import com.liao.util.enums.FileTypeEnum;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jonathan on 2017/2/9.
 * 附件表
 */
@Entity
@Table(name = "core_attach")
public class Attach extends BaseMixUserObject implements Serializable {
    //所在文件夹
    @Column(name = "relative_folder")
    private String relativeFolder;

    //原始名
    @Column(name = "org_name", length = 125)
    private String orgName;

    //现文件名
    @Column(length = 125)
    private String name;

    // 后缀
    @Column(name = "suffix_name", length = 125)
    private String suffixName;

    // 前缀
    @Column(name = "prefix_name", length = 125)
    private String prefixName;

    // 附件大小
    private Long size;

    // 描述
    @Column(name = "description", length = 255)
    private String description;

    //文件类型
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FileTypeEnum type;

    //相对路径
    @Column(name = "relative_path")
    private String relativePath;


    @Transient
    public String getLocaleUrl() {
        return relativeFolder.endsWith("/") ? relativeFolder + name : relativeFolder + "/" + name;
    }

    @Transient
    public String getSizeFormat() {
        String sizeStr;
        if (size < 1024) sizeStr = size + "B";
        else if (size < 1024 * 1024) sizeStr = size / 1024 + "KB";
        else if (size < 1024 * 1024 * 1024) sizeStr = size / 1024 / 1024 + "MB";
        else if (size < 1024 * 1024 * 1024 * 1024) sizeStr = size / 1024 / 1024 / 1024 + "GB";
        else sizeStr = "未知大小";
        return sizeStr;
    }

    public String getRelativeFolder() {
        return relativeFolder;
    }

    public void setRelativeFolder(String relativeFolder) {
        this.relativeFolder = relativeFolder;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FileTypeEnum getType() {
        return type;
    }

    public void setType(FileTypeEnum type) {
        this.type = type;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
