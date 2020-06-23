package com.heque.eat.express.pojo.fsi;

import java.util.Date;

public class FoodStoreInfo {
    private Long id;

    private String storeName;

    private String storeCity;

    private String storeAddress;

    private Float shippingFee;

    private String storePhoneArea;

    private Long storePhoneNumber;

    private String noonTakeFoodTime;

    private String nightTakeFoodTime;

    private String storeImg;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private String remark;

    private Double latitude;

    private Double longitude;

    private Integer status;
    
    private Long parentStoreId; //如果是取餐点->所属门店Id,如果是门店->null
    
    private String provideStyle;//门店提供的供餐方式（门店有两种，取餐点只有一种）

    private Integer isdel;

    private Integer feeType;//门店售餐类型   1-点餐模式   2-自助模式   3-兼容模式


    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getStorePhoneArea() {
        return storePhoneArea;
    }

    public void setStorePhoneArea(String storePhoneArea) {
        this.storePhoneArea = storePhoneArea;
    }

    public Long getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(Long storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getNoonTakeFoodTime() {
        return noonTakeFoodTime;
    }

    public void setNoonTakeFoodTime(String noonTakeFoodTime) {
        this.noonTakeFoodTime = noonTakeFoodTime;
    }

    public String getNightTakeFoodTime() {
        return nightTakeFoodTime;
    }

    public void setNightTakeFoodTime(String nightTakeFoodTime) {
        this.nightTakeFoodTime = nightTakeFoodTime;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

	public Long getParentStoreId() {
		return parentStoreId;
	}

	public void setParentStoreId(Long parentStoreId) {
		this.parentStoreId = parentStoreId;
	}

	public String getProvideStyle() {
		return provideStyle;
	}

	public void setProvideStyle(String provideStyle) {
		this.provideStyle = provideStyle;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
}