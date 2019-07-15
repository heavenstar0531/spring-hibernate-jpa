package com.tirmizee.core.hibernate.dialect;

import java.sql.Types;

import org.hibernate.dialect.Oracle9iDialect;
import org.hibernate.type.StandardBasicTypes;

public class OracleDialect extends Oracle9iDialect {

	public OracleDialect() {
		super();
		/*registerColumnType(Types.INTEGER, "number($p)");
		registerColumnType(Types.NUMERIC, "number($p,$s)");
		registerColumnType(Types.DECIMAL, "number($p,$s)");*/
	}
	
}
