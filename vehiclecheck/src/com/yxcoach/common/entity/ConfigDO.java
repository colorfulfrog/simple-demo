package com.yxcoach.common.entity;

import java.util.Date;

import com.yxcoach.common.base.entity.BaseModel;

/**
 * 
 */
public class ConfigDO extends BaseModel {
    private static final long serialVersionUID = -1167770510027575597L;
    /**
     * id
     */
    private Long id;
    /**
     * 配置类型
     */
    private String type;
    /**
     * key
     */
    private String configKey;
    /**
     * value
     */
    private String value;
    /**
     * 乐观锁控制
     */
    private Integer version;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;
    /**
     * 属性描述
     */
    private String description;


    /**
     * 可见 visible=1
     * 不可见 visible=2
     */
    private int visible;

    public Long getId() {
        return id;
    }

    public ConfigDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public ConfigDO setType(String type) {
        this.type = type;
        return this;
    }

    public String getConfigKey() {
        return configKey;
    }

    public ConfigDO setConfigKey(String configKey) {
        this.configKey = configKey;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ConfigDO setValue(String value) {
        this.value = value;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public ConfigDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public ConfigDO setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public ConfigDO setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConfigDO setDescription(String description) {
        this.description = description;
        return this;
    }



    public int getVisible() {
        return visible;
    }

    public ConfigDO setVisible(int visible) {
        this.visible = visible;
        return this;
    }
}
