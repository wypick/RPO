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

package com.bmstu.drivers.manager.core.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DriverLocalService}.
 *
 * @author Romanova
 * @see DriverLocalService
 * @generated
 */
@ProviderType
public class DriverLocalServiceWrapper implements DriverLocalService,
	ServiceWrapper<DriverLocalService> {
	public DriverLocalServiceWrapper(DriverLocalService driverLocalService) {
		_driverLocalService = driverLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _driverLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _driverLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _driverLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _driverLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _driverLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of drivers.
	*
	* @return the number of drivers
	*/
	@Override
	public int getDriversCount() {
		return _driverLocalService.getDriversCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _driverLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _driverLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.drivers.manager.core.model.impl.DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _driverLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.drivers.manager.core.model.impl.DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _driverLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the drivers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.drivers.manager.core.model.impl.DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @return the range of drivers
	*/
	@Override
	public java.util.List<com.bmstu.drivers.manager.core.model.Driver> getDrivers(int start,
		int end) {
		return _driverLocalService.getDrivers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _driverLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _driverLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the driver to the database. Also notifies the appropriate model listeners.
	*
	* @param driver the driver
	* @return the driver that was added
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver addDriver(
		com.bmstu.drivers.manager.core.model.Driver driver) {
		return _driverLocalService.addDriver(driver);
	}

	@Override
	public com.bmstu.drivers.manager.core.model.Driver addDriver(long driverId,
			java.lang.String driverName, java.lang.String description, 
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		return _driverLocalService.addDriver(driverId, driverName, description, serviceContext);
	}
	
	/**
	* Creates a new driver with the primary key. Does not add the driver to the database.
	*
	* @param driverId the primary key for the new driver
	* @return the new driver
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver createDriver(long driverId) {
		return _driverLocalService.createDriver(driverId);
	}

	/**
	* Deletes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param driverId the primary key of the driver
	* @return the driver that was removed
	* @throws PortalException if a driver with the primary key could not be found
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver deleteDriver(long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _driverLocalService.deleteDriver(driverId);
	}

	/**
	* Deletes the driver from the database. Also notifies the appropriate model listeners.
	*
	* @param driver the driver
	* @return the driver that was removed
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver deleteDriver(
		com.bmstu.drivers.manager.core.model.Driver driver) {
		return _driverLocalService.deleteDriver(driver);
	}

	@Override
	public com.bmstu.drivers.manager.core.model.Driver fetchDriver(long driverId) {
		return _driverLocalService.fetchDriver(driverId);
	}

	/**
	* Returns the driver with the primary key.
	*
	* @param driverId the primary key of the driver
	* @return the driver
	* @throws PortalException if a driver with the primary key could not be found
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver getDriver(long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _driverLocalService.getDriver(driverId);
	}

	/**
	* Updates the driver in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param driver the driver
	* @return the driver that was updated
	*/
	@Override
	public com.bmstu.drivers.manager.core.model.Driver updateDriver(
		com.bmstu.drivers.manager.core.model.Driver driver) {
		return _driverLocalService.updateDriver(driver);
	}

	@Override
	public DriverLocalService getWrappedService() {
		return _driverLocalService;
	}

	@Override
	public void setWrappedService(DriverLocalService driverLocalService) {
		_driverLocalService = driverLocalService;
	}

	private DriverLocalService _driverLocalService;
}