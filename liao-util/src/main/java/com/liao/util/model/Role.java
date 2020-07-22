package com.liao.util.model;


import com.liao.util.base.BaseConfObject;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @version $Id: Role.java, v 0.1 2015/9/11 18:47 Jonathan.jin   Exp $
 */
@Entity
@Table(name = "core_role")
public class Role extends BaseConfObject implements Serializable {

    public static final String SUPER_MANAGER = "超级管理员";

    /**
     * 角色名称,一般为中文，表述意思用
     */
    @NotEmpty(message = "角色名称不能为空")
    @Column(length = 20)
    private String name;

    /**
     * 角色编码
     */
    @Column(name = "code", length = 58)
    private String code;

    /**
     * 角色资源关联
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "core_role_resource",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> resourceSet = new HashSet<>();

    public Role() {
    }

    public Role(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);
    }

    @Override
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }


}
