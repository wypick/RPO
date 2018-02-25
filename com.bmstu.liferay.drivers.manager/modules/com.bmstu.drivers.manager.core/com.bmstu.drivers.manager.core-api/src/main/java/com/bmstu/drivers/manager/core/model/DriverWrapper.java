/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bmstu.drivers.manager.core.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Driver}.
 * </p>
 *
 * @author Romanova
 * @see Driver
 * @generated
 */
@ProviderType
public class DriverWrapper implements Driver, ModelWrapper<Driver> {
	public DriverWrapper(Driver driver) {
		_driver = driver;
	}

	@Override
	public Class<?> getModelClass() {
		return Driver.class;
	}

	@Override
	public String getModelClassName() {
		return Driver.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("driverId", getDriverId());
		attributes.put("driverName", getDriverName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _driver.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _driver.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _driver.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _driver.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.bmstu.drivers.manager.core.model.Driver> toCacheModel() {
		return _driver.toCacheModel();
	}

	@Override
	public int compareTo(com.bmstu.drivers.manager.core.model.Driver driver) {
		return _driver.compareTo(driver);
	}

	@Override
	public int hashCode() {
		return _driver.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _driver.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DriverWrapper((Driver)_driver.clone());
	}

	/**
	* Returns the description of this driver.
	*
	* @return the description of this driver
	*/
	@Override
	public java.lang.String getDescription() {
		return _driver.getDescription();
	}

	/**
	* Returns the driver name of this driver.
	*
	* @return the driver name of this driver
	*/
	@Override
	public java.lang.String getDriverName() {
		return _driver.getDriverName();
	}

	/**
	* Returns the uuid of this driver.
	*
	* @return the uuid of this driver
	*/
	@Override
	public java.lang.String getUuid() {
		return _driver.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _driver.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _driver.toXmlString();
	}

	/**
	* Returns the driver ID of this driver.
	*
	* @return the driver ID of this driver
	*/
	@Override
	public long getDriverId() {
		return _driver.getDriverId();
	}

	/**
	* Returns the primary key of this driver.
	*
	* @return the primary key of this driver
	*/
	@Override
	public long getPrimaryKey() {
		return _driver.getPrimaryKey();
	}

	@Override
	public com.bmstu.drivers.manager.core.model.Driver toEscapedModel() {
		return new DriverWrapper(_driver.toEscapedModel());
	}

	@Override
	public com.bmstu.drivers.manager.core.model.Driver toUnescapedModel() {
		return new DriverWrapper(_driver.toUnescapedModel());
	}

	@Override
	public void persist() {
		_driver.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_driver.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this driver.
	*
	* @param description the description of this driver
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_driver.setDescription(description);
	}

	/**
	* Sets the driver ID of this driver.
	*
	* @param driverId the driver ID of this driver
	*/
	@Override
	public void setDriverId(long driverId) {
		_driver.setDriverId(driverId);
	}

	/**
	* Sets the driver name of this driver.
	*
	* @param driverName the driver name of this driver
	*/
	@Override
	public void setDriverName(java.lang.String driverName) {
		_driver.setDriverName(driverName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_driver.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_driver.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_driver.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_driver.setNew(n);
	}

	/**
	* Sets the primary key of this driver.
	*
	* @param primaryKey the primary key of this driver
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_driver.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_driver.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this driver.
	*
	* @param uuid the uuid of this driver
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_driver.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DriverWrapper)) {
			return false;
		}

		DriverWrapper driverWrapper = (DriverWrapper)obj;

		if (Objects.equals(_driver, driverWrapper._driver)) {
			return true;
		}

		return false;
	}

	@Override
	public Driver getWrappedModel() {
		return _driver;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _driver.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _driver.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_driver.resetOriginalValues();
	}

	private final Driver _driver;
}