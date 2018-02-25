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

package com.bmstu.drivers.manager.core.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.bmstu.drivers.manager.core.model.Driver;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Driver in entity cache.
 *
 * @author Romanova
 * @see Driver
 * @generated
 */
@ProviderType
public class DriverCacheModel implements CacheModel<Driver>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DriverCacheModel)) {
			return false;
		}

		DriverCacheModel driverCacheModel = (DriverCacheModel)obj;

		if (driverId == driverCacheModel.driverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, driverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Driver toEntityModel() {
		DriverImpl driverImpl = new DriverImpl();

		if (uuid == null) {
			driverImpl.setUuid(StringPool.BLANK);
		}
		else {
			driverImpl.setUuid(uuid);
		}

		driverImpl.setDriverId(driverId);

		if (driverName == null) {
			driverImpl.setDriverName(StringPool.BLANK);
		}
		else {
			driverImpl.setDriverName(driverName);
		}

		if (description == null) {
			driverImpl.setDescription(StringPool.BLANK);
		}
		else {
			driverImpl.setDescription(description);
		}

		driverImpl.resetOriginalValues();

		return driverImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		driverId = objectInput.readLong();
		driverName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(driverId);

		if (driverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long driverId;
	public String driverName;
	public String description;
}