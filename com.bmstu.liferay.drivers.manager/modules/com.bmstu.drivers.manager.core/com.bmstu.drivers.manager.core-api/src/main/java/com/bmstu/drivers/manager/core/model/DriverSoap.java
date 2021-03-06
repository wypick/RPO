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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service_builder.service.http.DriverServiceSoap}.
 *
 * @author Romanova
 * @see service_builder.service.http.DriverServiceSoap
 * @generated
 */
@ProviderType
public class DriverSoap implements Serializable {
	public static DriverSoap toSoapModel(Driver model) {
		DriverSoap soapModel = new DriverSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDriverId(model.getDriverId());
		soapModel.setDriverName(model.getDriverName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DriverSoap[] toSoapModels(Driver[] models) {
		DriverSoap[] soapModels = new DriverSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DriverSoap[][] toSoapModels(Driver[][] models) {
		DriverSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DriverSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DriverSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DriverSoap[] toSoapModels(List<Driver> models) {
		List<DriverSoap> soapModels = new ArrayList<DriverSoap>(models.size());

		for (Driver model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DriverSoap[soapModels.size()]);
	}

	public DriverSoap() {
	}

	public long getPrimaryKey() {
		return _driverId;
	}

	public void setPrimaryKey(long pk) {
		setDriverId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDriverId() {
		return _driverId;
	}

	public void setDriverId(long driverId) {
		_driverId = driverId;
	}

	public String getDriverName() {
		return _driverName;
	}

	public void setDriverName(String driverName) {
		_driverName = driverName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _driverId;
	private String _driverName;
	private String _description;
}