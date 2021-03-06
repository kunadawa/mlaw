/**
 * 
 */
package org.martinlaw.bo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.martinlaw.bo.conveyance.Conveyance;

/**
 * @author mugo
 *
 */
public class ScopeTest {

	private Scope scope;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		scope = new Scope();
		scope.setQualifiedClassName(Conveyance.class.getCanonicalName());
	}

	/**
	 * Test method for {@link org.martinlaw.bo.StatusScope#getSimpleClassName()}.
	 */
	@Test
	public void testGetSimpleClassName() {
		assertNotNull("simple class name should not be null", scope.getSimpleClassName());
		assertEquals("simple class name differs", Conveyance.class.getSimpleName(), scope.getSimpleClassName());
	}

}
