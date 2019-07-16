package com.tirmizee.core.hibernate.dialect;

import org.hibernate.dialect.Oracle9iDialect;

public class OracleDialect extends Oracle9iDialect {

	public OracleDialect() {
		super();
		/*registerColumnType(Types.INTEGER, "number($p)");
		registerColumnType(Types.NUMERIC, "number($p,$s)");
		registerColumnType(Types.DECIMAL, "number($p,$s)");*/
	}
	
}
