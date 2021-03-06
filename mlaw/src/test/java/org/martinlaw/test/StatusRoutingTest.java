/**
 * 
 */
package org.martinlaw.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.KRADServiceLocator;
import org.martinlaw.bo.Type;
import org.martinlaw.bo.Status;
import org.martinlaw.bo.Scope;
import org.martinlaw.test.type.TypeRoutingTestBase;

/**
 * test routing for {@link Status}
 * @author mugo
 *
 */
public class StatusRoutingTest extends TypeRoutingTestBase {
	private Logger log = Logger.getLogger(getClass());
	
	@Test
	public void testCaseStatusMaintenanceRouting() throws WorkflowException {
		//testTransactionalRouting("CaseStatusMaintenanceDocument");
		Type status = new Status();
		String statusText = "deadlock";
		status.setName(statusText);
		Scope statusScope = new Scope();
		statusScope.setQualifiedClassName("org.martinlaw.Aclass");
		status.getScope().add(statusScope);
		try {
			testMaintenanceRoutingInitToFinal(getDocTypeName(), status);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", statusText);
			Collection<Status> result = KRADServiceLocator.getBusinessObjectService().findMatching(Status.class, params);
			assertNotNull("status should have been persisted", result);
			assertEquals("status should have been persisted", 1, result.size());
			
		} catch (Exception e) {
			log.error("test failed", e);
			fail("test failed");
		}
	}

	public String getDocTypeName() {
		return "StatusMaintenanceDocument";
	}

	/* (non-Javadoc)
	 * @see org.martinlaw.test.KewTestsBase#testInitiatorFYI()
	 */
	/**
	 * routes to final, so this test is not applicable
	 */
	@Override
	public void testInitiatorFYI() {
		// do nothing
	}

	@Override
	public Class<? extends Type> getDataObjectClass() {
		return Status.class;
	}
}
