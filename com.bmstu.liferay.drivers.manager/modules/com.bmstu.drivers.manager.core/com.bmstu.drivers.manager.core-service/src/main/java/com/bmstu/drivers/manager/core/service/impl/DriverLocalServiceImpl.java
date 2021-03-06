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

package com.bmstu.drivers.manager.core.service.impl;

import com.bmstu.drivers.manager.core.service.base.DriverLocalServiceBaseImpl;

import com.bmstu.drivers.manager.core.model.Driver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the driver local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bmstu.drivers.manager.core.service.DriverLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Romanova
 * @see DriverLocalServiceBaseImpl
 * @see com.bmstu.drivers.manager.core.service.DriverLocalServiceUtil
 */
public class DriverLocalServiceImpl extends DriverLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.bmstu.drivers.manager.core.service.DriverLocalServiceUtil} to access the driver local service.
	 */
	
	@Override
	public Driver addDriver(long driverId, String driverName, String description, ServiceContext serviceContext) throws PortalException {
		driverName = nullToEmpty(driverName);
		description = nullToEmpty(description);
		
		valideteId(driverId);

	
		Driver driver = driverPersistence.create(counterLocalService.increment());

		driver.setDriverId(driverId);
		driver.setDriverName(driverName);
		driver.setDescription(description);

		driverPersistence.update(driver);

		return driver;
	}
	
	private void valideteId(long driverId) throws PortalException {
		if (!driverPersistence.findByDriverId(driverId).isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	private String nullToEmpty(String string) {
		return string == null ? "" : string;
	}
}