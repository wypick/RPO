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

package com.bmstu.drivers.manager.core.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.bmstu.drivers.manager.core.exception.NoSuchDriverException;

import com.bmstu.drivers.manager.core.model.Driver;

import com.bmstu.drivers.manager.core.model.impl.DriverImpl;
import com.bmstu.drivers.manager.core.model.impl.DriverModelImpl;

import com.bmstu.drivers.manager.core.service.persistence.DriverPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the driver service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Romanova
 * @see DriverPersistence
 * @see com.bmstu.drivers.manager.core.service.persistence.DriverUtil
 * @generated
 */
@ProviderType
public class DriverPersistenceImpl extends BasePersistenceImpl<Driver>
	implements DriverPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DriverUtil} to access the driver persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DriverImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DriverModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching drivers
	 */
	@Override
	public List<Driver> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Driver> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Driver> findByUuid(String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Driver> findByUuid(String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Driver> list = null;

		if (retrieveFromCache) {
			list = (List<Driver>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Driver driver : list) {
					if (!Objects.equals(uuid, driver.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DRIVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DriverModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByUuid_First(String uuid,
		OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {
		Driver driver = fetchByUuid_First(uuid, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriverException(msg.toString());
	}

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByUuid_First(String uuid,
		OrderByComparator<Driver> orderByComparator) {
		List<Driver> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByUuid_Last(String uuid,
		OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {
		Driver driver = fetchByUuid_Last(uuid, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriverException(msg.toString());
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByUuid_Last(String uuid,
		OrderByComparator<Driver> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Driver> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Driver[] findByUuid_PrevAndNext(long driverId, String uuid,
		OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {
		Driver driver = findByPrimaryKey(driverId);

		Session session = null;

		try {
			session = openSession();

			Driver[] array = new DriverImpl[3];

			array[0] = getByUuid_PrevAndNext(session, driver, uuid,
					orderByComparator, true);

			array[1] = driver;

			array[2] = getByUuid_PrevAndNext(session, driver, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Driver getByUuid_PrevAndNext(Session session, Driver driver,
		String uuid, OrderByComparator<Driver> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DRIVER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DriverModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(driver);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Driver> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drivers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Driver driver : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching drivers
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRIVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "driver.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "driver.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(driver.uuid IS NULL OR driver.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DRIVERID = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDriverId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID =
		new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, DriverImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDriverId",
			new String[] { Long.class.getName() },
			DriverModelImpl.DRIVERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DRIVERID = new FinderPath(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDriverId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the drivers where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the matching drivers
	 */
	@Override
	public List<Driver> findByDriverId(long driverId) {
		return findByDriverId(driverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Driver> findByDriverId(long driverId, int start, int end) {
		return findByDriverId(driverId, start, end, null);
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
	@Override
	public List<Driver> findByDriverId(long driverId, int start, int end,
		OrderByComparator<Driver> orderByComparator) {
		return findByDriverId(driverId, start, end, orderByComparator, true);
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
	@Override
	public List<Driver> findByDriverId(long driverId, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID;
			finderArgs = new Object[] { driverId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DRIVERID;
			finderArgs = new Object[] { driverId, start, end, orderByComparator };
		}

		List<Driver> list = null;

		if (retrieveFromCache) {
			list = (List<Driver>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Driver driver : list) {
					if ((driverId != driver.getDriverId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DRIVER_WHERE);

			query.append(_FINDER_COLUMN_DRIVERID_DRIVERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DriverModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(driverId);

				if (!pagination) {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first driver in the ordered set where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByDriverId_First(long driverId,
		OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {
		Driver driver = fetchByDriverId_First(driverId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("driverId=");
		msg.append(driverId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriverException(msg.toString());
	}

	/**
	 * Returns the first driver in the ordered set where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByDriverId_First(long driverId,
		OrderByComparator<Driver> orderByComparator) {
		List<Driver> list = findByDriverId(driverId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last driver in the ordered set where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByDriverId_Last(long driverId,
		OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {
		Driver driver = fetchByDriverId_Last(driverId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("driverId=");
		msg.append(driverId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriverException(msg.toString());
	}

	/**
	 * Returns the last driver in the ordered set where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByDriverId_Last(long driverId,
		OrderByComparator<Driver> orderByComparator) {
		int count = countByDriverId(driverId);

		if (count == 0) {
			return null;
		}

		List<Driver> list = findByDriverId(driverId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the drivers where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 */
	@Override
	public void removeByDriverId(long driverId) {
		for (Driver driver : findByDriverId(driverId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching drivers
	 */
	@Override
	public int countByDriverId(long driverId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DRIVERID;

		Object[] finderArgs = new Object[] { driverId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRIVER_WHERE);

			query.append(_FINDER_COLUMN_DRIVERID_DRIVERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(driverId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DRIVERID_DRIVERID_2 = "driver.driverId = ?";

	public DriverPersistenceImpl() {
		setModelClass(Driver.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the driver in the entity cache if it is enabled.
	 *
	 * @param driver the driver
	 */
	@Override
	public void cacheResult(Driver driver) {
		entityCache.putResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverImpl.class, driver.getPrimaryKey(), driver);

		driver.resetOriginalValues();
	}

	/**
	 * Caches the drivers in the entity cache if it is enabled.
	 *
	 * @param drivers the drivers
	 */
	@Override
	public void cacheResult(List<Driver> drivers) {
		for (Driver driver : drivers) {
			if (entityCache.getResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
						DriverImpl.class, driver.getPrimaryKey()) == null) {
				cacheResult(driver);
			}
			else {
				driver.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all drivers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DriverImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the driver.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Driver driver) {
		entityCache.removeResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverImpl.class, driver.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Driver> drivers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Driver driver : drivers) {
			entityCache.removeResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
				DriverImpl.class, driver.getPrimaryKey());
		}
	}

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	@Override
	public Driver create(long driverId) {
		Driver driver = new DriverImpl();

		driver.setNew(true);
		driver.setPrimaryKey(driverId);

		String uuid = PortalUUIDUtil.generate();

		driver.setUuid(uuid);

		return driver;
	}

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver remove(long driverId) throws NoSuchDriverException {
		return remove((Serializable)driverId);
	}

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver remove(Serializable primaryKey) throws NoSuchDriverException {
		Session session = null;

		try {
			session = openSession();

			Driver driver = (Driver)session.get(DriverImpl.class, primaryKey);

			if (driver == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDriverException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(driver);
		}
		catch (NoSuchDriverException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Driver removeImpl(Driver driver) {
		driver = toUnwrappedModel(driver);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(driver)) {
				driver = (Driver)session.get(DriverImpl.class,
						driver.getPrimaryKeyObj());
			}

			if (driver != null) {
				session.delete(driver);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (driver != null) {
			clearCache(driver);
		}

		return driver;
	}

	@Override
	public Driver updateImpl(Driver driver) {
		driver = toUnwrappedModel(driver);

		boolean isNew = driver.isNew();

		DriverModelImpl driverModelImpl = (DriverModelImpl)driver;

		if (Validator.isNull(driver.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			driver.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (driver.isNew()) {
				session.save(driver);

				driver.setNew(false);
			}
			else {
				driver = (Driver)session.merge(driver);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DriverModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { driverModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { driverModelImpl.getDriverId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DRIVERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((driverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { driverModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { driverModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((driverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						driverModelImpl.getOriginalDriverId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DRIVERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID,
					args);

				args = new Object[] { driverModelImpl.getDriverId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DRIVERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRIVERID,
					args);
			}
		}

		entityCache.putResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
			DriverImpl.class, driver.getPrimaryKey(), driver, false);

		driver.resetOriginalValues();

		return driver;
	}

	protected Driver toUnwrappedModel(Driver driver) {
		if (driver instanceof DriverImpl) {
			return driver;
		}

		DriverImpl driverImpl = new DriverImpl();

		driverImpl.setNew(driver.isNew());
		driverImpl.setPrimaryKey(driver.getPrimaryKey());

		driverImpl.setUuid(driver.getUuid());
		driverImpl.setDriverId(driver.getDriverId());
		driverImpl.setDriverName(driver.getDriverName());
		driverImpl.setDescription(driver.getDescription());

		return driverImpl;
	}

	/**
	 * Returns the driver with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDriverException {
		Driver driver = fetchByPrimaryKey(primaryKey);

		if (driver == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDriverException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return driver;
	}

	/**
	 * Returns the driver with the primary key or throws a {@link NoSuchDriverException} if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver findByPrimaryKey(long driverId) throws NoSuchDriverException {
		return findByPrimaryKey((Serializable)driverId);
	}

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	@Override
	public Driver fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
				DriverImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Driver driver = (Driver)serializable;

		if (driver == null) {
			Session session = null;

			try {
				session = openSession();

				driver = (Driver)session.get(DriverImpl.class, primaryKey);

				if (driver != null) {
					cacheResult(driver);
				}
				else {
					entityCache.putResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
						DriverImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
					DriverImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return driver;
	}

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	@Override
	public Driver fetchByPrimaryKey(long driverId) {
		return fetchByPrimaryKey((Serializable)driverId);
	}

	@Override
	public Map<Serializable, Driver> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Driver> map = new HashMap<Serializable, Driver>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Driver driver = fetchByPrimaryKey(primaryKey);

			if (driver != null) {
				map.put(primaryKey, driver);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
					DriverImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Driver)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DRIVER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Driver driver : (List<Driver>)q.list()) {
				map.put(driver.getPrimaryKeyObj(), driver);

				cacheResult(driver);

				uncachedPrimaryKeys.remove(driver.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DriverModelImpl.ENTITY_CACHE_ENABLED,
					DriverImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the drivers.
	 *
	 * @return the drivers
	 */
	@Override
	public List<Driver> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Driver> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Driver> findAll(int start, int end,
		OrderByComparator<Driver> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Driver> findAll(int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Driver> list = null;

		if (retrieveFromCache) {
			list = (List<Driver>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DRIVER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DRIVER;

				if (pagination) {
					sql = sql.concat(DriverModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Driver>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the drivers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Driver driver : findAll()) {
			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DRIVER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DriverModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the driver persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DriverImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DRIVER = "SELECT driver FROM Driver driver";
	private static final String _SQL_SELECT_DRIVER_WHERE_PKS_IN = "SELECT driver FROM Driver driver WHERE driverId IN (";
	private static final String _SQL_SELECT_DRIVER_WHERE = "SELECT driver FROM Driver driver WHERE ";
	private static final String _SQL_COUNT_DRIVER = "SELECT COUNT(driver) FROM Driver driver";
	private static final String _SQL_COUNT_DRIVER_WHERE = "SELECT COUNT(driver) FROM Driver driver WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "driver.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Driver exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Driver exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DriverPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}