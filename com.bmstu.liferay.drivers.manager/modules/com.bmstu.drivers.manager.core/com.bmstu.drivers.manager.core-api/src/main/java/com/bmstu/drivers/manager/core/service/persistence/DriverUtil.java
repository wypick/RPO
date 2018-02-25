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

package com.bmstu.drivers.manager.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import com.bmstu.drivers.manager.core.model.Driver;

import java.util.List;

/**
 * The persistence utility for the driver service. This utility wraps {@link com.bmstu.drivers.manager.core.service.persistence.impl.DriverPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Romanova
 * @see DriverPersistence
 * @see com.bmstu.drivers.manager.core.service.persistence.impl.DriverPersistenceImpl
 * @generated
 */
@ProviderType
public class DriverUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Driver driver) {
		getPersistence().clearCache(driver);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Driver> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Driver> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Driver> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Driver> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Driver update(Driver driver) {
		return getPersistence().update(driver);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Driver update(Driver driver, ServiceContext serviceContext) {
		return getPersistence().update(driver, serviceContext);
	}

	/**
	* Returns all the drivers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching drivers
	*/
	public static List<Driver> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the drivers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @return the range of matching drivers
	*/
	public static List<Driver> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the drivers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching drivers
	*/
	public static List<Driver> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Driver> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drivers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching drivers
	*/
	public static List<Driver> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Driver> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first driver in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching driver
	* @throws NoSuchDriverException if a matching driver could not be found
	*/
	public static Driver findByUuid_First(java.lang.String uuid,
		OrderByComparator<Driver> orderByComparator)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first driver in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching driver, or <code>null</code> if a matching driver could not be found
	*/
	public static Driver fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Driver> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last driver in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching driver
	* @throws NoSuchDriverException if a matching driver could not be found
	*/
	public static Driver findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Driver> orderByComparator)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last driver in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching driver, or <code>null</code> if a matching driver could not be found
	*/
	public static Driver fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Driver> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the drivers before and after the current driver in the ordered set where uuid = &#63;.
	*
	* @param driverId the primary key of the current driver
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next driver
	* @throws NoSuchDriverException if a driver with the primary key could not be found
	*/
	public static Driver[] findByUuid_PrevAndNext(long driverId,
		java.lang.String uuid, OrderByComparator<Driver> orderByComparator)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence()
				   .findByUuid_PrevAndNext(driverId, uuid, orderByComparator);
	}

	/**
	* Removes all the drivers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of drivers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching drivers
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the drivers where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @return the matching drivers
	*/
	public static List<Driver> findByDriverId(long driverId) {
		return getPersistence().findByDriverId(driverId);
	}

	/**
	* Returns a range of all the drivers where driverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param driverId the driver ID
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @return the range of matching drivers
	*/
	public static List<Driver> findByDriverId(long driverId, int start, int end) {
		return getPersistence().findByDriverId(driverId, start, end);
	}

	/**
	* Returns an ordered range of all the drivers where driverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param driverId the driver ID
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching drivers
	*/
	public static List<Driver> findByDriverId(long driverId, int start,
		int end, OrderByComparator<Driver> orderByComparator) {
		return getPersistence()
				   .findByDriverId(driverId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drivers where driverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param driverId the driver ID
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching drivers
	*/
	public static List<Driver> findByDriverId(long driverId, int start,
		int end, OrderByComparator<Driver> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDriverId(driverId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first driver in the ordered set where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching driver
	* @throws NoSuchDriverException if a matching driver could not be found
	*/
	public static Driver findByDriverId_First(long driverId,
		OrderByComparator<Driver> orderByComparator)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().findByDriverId_First(driverId, orderByComparator);
	}

	/**
	* Returns the first driver in the ordered set where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching driver, or <code>null</code> if a matching driver could not be found
	*/
	public static Driver fetchByDriverId_First(long driverId,
		OrderByComparator<Driver> orderByComparator) {
		return getPersistence()
				   .fetchByDriverId_First(driverId, orderByComparator);
	}

	/**
	* Returns the last driver in the ordered set where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching driver
	* @throws NoSuchDriverException if a matching driver could not be found
	*/
	public static Driver findByDriverId_Last(long driverId,
		OrderByComparator<Driver> orderByComparator)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().findByDriverId_Last(driverId, orderByComparator);
	}

	/**
	* Returns the last driver in the ordered set where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching driver, or <code>null</code> if a matching driver could not be found
	*/
	public static Driver fetchByDriverId_Last(long driverId,
		OrderByComparator<Driver> orderByComparator) {
		return getPersistence().fetchByDriverId_Last(driverId, orderByComparator);
	}

	/**
	* Removes all the drivers where driverId = &#63; from the database.
	*
	* @param driverId the driver ID
	*/
	public static void removeByDriverId(long driverId) {
		getPersistence().removeByDriverId(driverId);
	}

	/**
	* Returns the number of drivers where driverId = &#63;.
	*
	* @param driverId the driver ID
	* @return the number of matching drivers
	*/
	public static int countByDriverId(long driverId) {
		return getPersistence().countByDriverId(driverId);
	}

	/**
	* Caches the driver in the entity cache if it is enabled.
	*
	* @param driver the driver
	*/
	public static void cacheResult(Driver driver) {
		getPersistence().cacheResult(driver);
	}

	/**
	* Caches the drivers in the entity cache if it is enabled.
	*
	* @param drivers the drivers
	*/
	public static void cacheResult(List<Driver> drivers) {
		getPersistence().cacheResult(drivers);
	}

	/**
	* Creates a new driver with the primary key. Does not add the driver to the database.
	*
	* @param driverId the primary key for the new driver
	* @return the new driver
	*/
	public static Driver create(long driverId) {
		return getPersistence().create(driverId);
	}

	/**
	* Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param driverId the primary key of the driver
	* @return the driver that was removed
	* @throws NoSuchDriverException if a driver with the primary key could not be found
	*/
	public static Driver remove(long driverId)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().remove(driverId);
	}

	public static Driver updateImpl(Driver driver) {
		return getPersistence().updateImpl(driver);
	}

	/**
	* Returns the driver with the primary key or throws a {@link NoSuchDriverException} if it could not be found.
	*
	* @param driverId the primary key of the driver
	* @return the driver
	* @throws NoSuchDriverException if a driver with the primary key could not be found
	*/
	public static Driver findByPrimaryKey(long driverId)
		throws com.bmstu.drivers.manager.core.exception.NoSuchDriverException {
		return getPersistence().findByPrimaryKey(driverId);
	}

	/**
	* Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param driverId the primary key of the driver
	* @return the driver, or <code>null</code> if a driver with the primary key could not be found
	*/
	public static Driver fetchByPrimaryKey(long driverId) {
		return getPersistence().fetchByPrimaryKey(driverId);
	}

	public static java.util.Map<java.io.Serializable, Driver> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the drivers.
	*
	* @return the drivers
	*/
	public static List<Driver> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the drivers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @return the range of drivers
	*/
	public static List<Driver> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the drivers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of drivers
	*/
	public static List<Driver> findAll(int start, int end,
		OrderByComparator<Driver> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drivers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DriverModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drivers
	* @param end the upper bound of the range of drivers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of drivers
	*/
	public static List<Driver> findAll(int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the drivers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of drivers.
	*
	* @return the number of drivers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DriverPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DriverPersistence, DriverPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DriverPersistence.class);
}