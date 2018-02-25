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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Driver service. Represents a row in the &quot;com.bmstu.drivers.manager.core_Driver&quot; database table, with each column mapped to a property of this class.
 *
 * @author Romanova
 * @see DriverModel
 * @see com.bmstu.drivers.manager.core.model.impl.DriverImpl
 * @see com.bmstu.drivers.manager.core.model.impl.DriverModelImpl
 * @generated
 */
@ImplementationClassName("com.bmstu.drivers.manager.core.model.impl.DriverImpl")
@ProviderType
public interface Driver extends DriverModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.bmstu.drivers.manager.core.model.impl.DriverImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Driver, Long> DRIVER_ID_ACCESSOR = new Accessor<Driver, Long>() {
			@Override
			public Long get(Driver driver) {
				return driver.getDriverId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Driver> getTypeClass() {
				return Driver.class;
			}
		};
}