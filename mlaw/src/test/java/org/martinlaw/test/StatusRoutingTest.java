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
import org.martinlaw.bo.Status;
import org.martinlaw.bo.StatusScope;

/**
 * test routing for {@link Status}
 * @author mugo
 *
 */
public class StatusRoutingTest extends KewTestsBase {
	private Logger log = Logger.getLogger(getClass());
	
	@Test
	public void testCaseStatusMaintenanceRouting() throws WorkflowException {
		//testTransactionalRouting("CaseStatusMaintenanceDocument");
		Status status = new Status();
		String statusText = "deadlock";
		status.setStatus(statusText);
		StatusScope statusScope = new StatusScope();
		statusScope.setQualifiedClassName("org.martinlaw.Aclass");
		status.getScope().add(statusScope);
		try {
			testMaintenanceRoutingInitToFinal("StatusMaintenanceDocument", status);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", statusText);
			Collection<Status> result = KRADServiceLocator.getBusinessObjectService().findMatching(Status.class, params);
			assertNotNull("status should have been persisted", result);
			assertEquals("status should have been persisted", 1, result.size());
			
		} catch (Exception e) {
			log.error("test failed", e);
			fail("test failed");
		}
	}
}
