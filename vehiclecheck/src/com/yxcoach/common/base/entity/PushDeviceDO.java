package com.yxcoach.common.base.entity;

import java.util.Date;

/**
 * 
 * @Description  推送设备
 * Created by yangzhipeng on 2017年7月5日
 */
public class PushDeviceDO extends BaseModel {

    private static final long serialVersionUID = 4843037485030341574L;
    private Integer id;
    private String mobile;//用户电话
    private String clientSystem;//客户端系统
    private String clientVersion;//客户端版本
    private String deviceToken;//设备号
    private String account;//用户别名
    private Date gmtCreate;
    private Date gmtModify;
    private Integer version;
    private Integer visible;//是否可用


    private String clientType;//用户/司机

    public PushDeviceDO() {
    }

    public String getAccount() {
        return account;
    }

    public PushDeviceDO setAccount(String account) {
        this.account = account;
        return this;
    }



    public String getClientSystem() {
        return clientSystem;
    }

    public PushDeviceDO setClientSystem(String clientSystem) {
        this.clientSystem = clientSystem;
        return this;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public PushDeviceDO setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
        return this;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public PushDeviceDO setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public PushDeviceDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public PushDeviceDO setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public PushDeviceDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public PushDeviceDO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public PushDeviceDO setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public Integer getVisible() {
        return visible;
    }

    public PushDeviceDO setVisible(Integer visible) {
        this.visible = visible;
        return this;
    }

    public String getClientType() {
        return clientType;
    }

    public PushDeviceDO setClientType(String clientType) {
        this.clientType = clientType;
        return this;
    }

   

   /* *//**
     * 版本检测构造推送设备信息
     * @param request
     *//*
    public PushDeviceDO(ClientVersionRequest request) {
        this.setVisible(VisibleTypeEnum.VISIBLE.getType())
                .setClientSystem(request.getClientSystem())
                .setClientVersion(request.getClientVersion())
                .setDeviceToken(request.getDeviceToken())
                .setMobile(request.getMobile())
                .setClientType(request.getClientType().toLowerCase())
        ;
    }
    *//**
     * 用户登录构造推送设备信息
     * @param request
     *//*
    public PushDeviceDO(UserRequest request) {
        this.setVisible(VisibleTypeEnum.VISIBLE.getType())
                .setClientSystem(request.getClientSystem())
                .setClientVersion(request.getClientVersion())
                .setDeviceToken(request.getDeviceToken())
                .setMobile(request.getMobile())
                .setClientType(request.getClientType().toLowerCase())
        ;
    }
    *//**
     * 司机登陆构造推送设备信息
     * @param request
     *//*
    public PushDeviceDO(DriverRequest request) {
        this.setVisible(VisibleTypeEnum.VISIBLE.getType())
                .setClientSystem(request.getClientSystem())
                .setClientVersion(request.getClientVersion())
                .setDeviceToken(request.getDeviceToken())
                .setMobile(request.getMobile())
                .setClientType(request.getClientType().toLowerCase())
        ;
    }*/
}
