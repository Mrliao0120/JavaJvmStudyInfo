package com.liao.util.model;



import com.liao.util.base.BaseConfObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典
 * 使用的时候，先去找自己租户的数据，没有的话再找平台配置的字典数据。
 *
 * @author
 * @version $Id: ModuleManage.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_module_manage")
public class ModuleManage extends BaseConfObject implements Serializable {

    /** 模块名称，如 core、cms、oa 等系统  */
    @Column(length = 58, name = "module_name")
    private String moduleName;

    /** 模块状态:使用enabled 属性来控制，如果enabled=true则为装载，否则为已卸载 */
/*    @Enumerated(value = EnumType.STRING)
    @Column(length = 58, name = "module_status")
    private ModuleStatusEnum moduleStatus;*/

    /** 最近一次启动登记时间 */
    @Column(name = "latest_register_datetime")
    private Date latestSRegisterDatetime;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getLatestSRegisterDatetime() {
        return latestSRegisterDatetime;
    }

    public void setLatestSRegisterDatetime(Date latestSRegisterDatetime) {
        this.latestSRegisterDatetime = latestSRegisterDatetime;
    }
}
