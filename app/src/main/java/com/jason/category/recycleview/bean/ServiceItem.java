package com.jason.category.recycleview.bean;

import java.io.Serializable;

/**
 * 服务
 *
 */
public class ServiceItem implements Serializable {

	/**
	 * 服务图标
	 */
	public String servicePicUrl;
	/**
	 * 服务地址
	 */
	public String serviceUrl;
	/**
	 * 服务地址
	 */
	public String siteId;
	/**
	 * 服务地址
	 */
	public String serviceId;
	/**
	 * 0普通用户访问、1需要登陆、2需要实名认证
	 */
	public String level;

	public String columnName;
    public String columnId;
    public String serviceName;
    /**
     * 是否选中
     */
    public boolean isSelected;
	
    public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    public void setLevel(String level) {
        this.level = level;
    }


    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public void setServicePicUrl(String servicePicUrl) {
        this.servicePicUrl = servicePicUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

}
