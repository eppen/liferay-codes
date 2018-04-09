/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.cignexdatamatics.wrm.service.base;

import com.cignexdatamatics.wrm.service.RoomFacilityMappingLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class RoomFacilityMappingLocalServiceClpInvoker {
	public RoomFacilityMappingLocalServiceClpInvoker() {
		_methodName0 = "addRoomFacilityMapping";

		_methodParameterTypes0 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping"
			};

		_methodName1 = "createRoomFacilityMapping";

		_methodParameterTypes1 = new String[] {
				"com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK"
			};

		_methodName2 = "deleteRoomFacilityMapping";

		_methodParameterTypes2 = new String[] {
				"com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK"
			};

		_methodName3 = "deleteRoomFacilityMapping";

		_methodParameterTypes3 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchRoomFacilityMapping";

		_methodParameterTypes9 = new String[] {
				"com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK"
			};

		_methodName10 = "getRoomFacilityMapping";

		_methodParameterTypes10 = new String[] {
				"com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK"
			};

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getRoomFacilityMappings";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getRoomFacilityMappingsCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateRoomFacilityMapping";

		_methodParameterTypes14 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping"
			};

		_methodName15 = "updateRoomFacilityMapping";

		_methodParameterTypes15 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping", "boolean"
			};

		_methodName74 = "getBeanIdentifier";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "setBeanIdentifier";

		_methodParameterTypes75 = new String[] { "java.lang.String" };

		_methodName80 = "findAllMappingbyRoomId";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "findAllMappingbyFacilitiesId";

		_methodParameterTypes81 = new String[] { "long" };

		_methodName82 = "addRoomFacilityMapping";

		_methodParameterTypes82 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping"
			};

		_methodName83 = "remove";

		_methodParameterTypes83 = new String[] {
				"com.cignexdatamatics.wrm.model.RoomFacilityMapping"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.addRoomFacilityMapping((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.createRoomFacilityMapping((com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.deleteRoomFacilityMapping((com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.deleteRoomFacilityMapping((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.fetchRoomFacilityMapping((com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK)arguments[0]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.getRoomFacilityMapping((com.cignexdatamatics.wrm.service.persistence.RoomFacilityMappingPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.getRoomFacilityMappings(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.getRoomFacilityMappingsCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.updateRoomFacilityMapping((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.updateRoomFacilityMapping((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			RoomFacilityMappingLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.findAllMappingbyRoomId(((Long)arguments[0]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.findAllMappingbyFacilitiesId(((Long)arguments[0]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return RoomFacilityMappingLocalServiceUtil.addRoomFacilityMapping((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			RoomFacilityMappingLocalServiceUtil.remove((com.cignexdatamatics.wrm.model.RoomFacilityMapping)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
}