/**
 * 
 */
package org.martinlaw.test.courtcase;

/*
 * #%L
 * mlaw
 * %%
 * Copyright (C) 2012 Eric Njogu (kunadawa@gmail.com)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
import org.martinlaw.bo.courtcase.CourtCase;
import org.martinlaw.test.KewTestsBase;

/**
 * @author mugo
 *
 */
public class CourtCaseRoutingTest extends KewTestsBase {
	private Logger log = Logger.getLogger(getClass());
	
	@Test
	/**
	 * test that routing a court case maintenance document works as expected
	 * 
	 * @throws WorkflowException
	 */
	public void testCaseMaintenanceRouting() throws WorkflowException {
		//set up test status
		//getBoSvc().delete((List)getBoSvc().findAll(CourtCaseStatus.class));
		Status status = new Status();
		status.setStatus("Testing");
		status.setType(Status.ANY_TYPE.getKey());
		getBoSvc().save(status);
		status.refresh();
		assertNotNull(status.getId());
		//create new case bo
		CourtCase caseBo = new CourtCase();
		String localReference = "local-ref-1";
		caseBo.setLocalReference(localReference);
		caseBo.setCourtReference("high-court-211");
		caseBo.setName("Flesh Vs Spirit (Lifetime)");
		caseBo.setStatus(status);
		// side step validation error - error.required
		caseBo.setStatusId(status.getId());
		try {
			testMaintenanceRouting("CaseMaintenanceDocument", caseBo);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("localReference", localReference);
			Collection<CourtCase> cases = KRADServiceLocator.getBusinessObjectService().findMatching(CourtCase.class, params);
			assertEquals(1, cases.size());
			for (CourtCase cse: cases) {
				assertEquals(localReference,cse.getLocalReference());
				assertEquals("high-court-211",cse.getCourtReference());
				assertNotNull(cse.getStatus());
				log.info("created status with id " + cse.getStatus().getId());
			}
		} catch (Exception e) {
			log.error("test failed", e);
			fail("test failed");
		}
	}
	

}
