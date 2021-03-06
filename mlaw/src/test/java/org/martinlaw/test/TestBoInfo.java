package org.martinlaw.test;

import org.martinlaw.bo.Type;
/**
 * holds methods that classes inheriting from test classes need to implement
 * @author mugo
 *
 */
public interface TestBoInfo {

	/**
	 * 
	 * @return the class to be tested
	 */
	public abstract Class<? extends Type> getDataObjectClass();

	/**
	 * @return the document type name
	 */
	public abstract String getDocTypeName();

}