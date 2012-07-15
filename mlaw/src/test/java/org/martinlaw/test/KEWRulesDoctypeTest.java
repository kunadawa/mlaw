/**
 * 
 */
package org.martinlaw.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.kuali.rice.kew.api.KewApiServiceLocator;
import org.kuali.rice.kew.api.rule.Rule;
import org.kuali.rice.kew.doctype.service.DocumentTypeService;
import org.kuali.rice.kew.service.KEWServiceLocator;

/**
 * @author mugo
 *
 */
public class KEWRulesDoctypeTest extends KewTestsBase {
	/**
	 * convenience method to retrive obj ref 
	 */
	private org.kuali.rice.kew.api.rule.RuleService getRuleSvc() {
		return KewApiServiceLocator.getRuleService();
	}
	/**
	 * convenience method to retrive obj ref 
	 */
	private DocumentTypeService getDocTypeSvc() {
		return KEWServiceLocator.getDocumentTypeService();
	}
	@Test
	public void testCaseRule() {
		Rule rule = getRuleSvc().getRuleByName("org.martinlaw.rules.case");
		assertEquals("Routing rule for case maintenance", rule.getDescription());
		assertEquals("org.martinlaw.defaultApprovalTemplate",rule.getRuleTemplate().getName());
	}
	@Test
	@Ignore
	public void testConveyanceRule() {
		Rule rule = getRuleSvc().getRuleByName("org.martinlaw.rules.conveyance");
		assertEquals("Routing rule for conveyance maintenance", rule.getDescription());
	}
	
	@Test
	@Ignore("status routes to final, there is no need for a rule")
	public void testCaseStatusRule () {
		Rule rule = getRuleSvc().getRuleByName("org.martinlaw.rules.status");
		assertEquals("Routing rule for case status maintenance", rule.getDescription());
	}
	
	@Test
	public void testConveyanceTypeRule() {
		Rule rule = getRuleSvc().getRuleByName("org.martinlaw.rules.conveyanceType");
		assertEquals("Routing rule for ConveyanceTypeDocument maintenance", rule.getDescription());
	}
	
	@Test
	public void testCaseDoctype() {
		assertNotNull(getDocTypeSvc().findByName("CaseMaintenanceDocument"));
	}
	
	@Test
	public void testConveyanceDocType() {
		assertNotNull(getDocTypeSvc().findByName("ConveyanceMaintenanceDocument"));
	}
	
	@Test
	public void testCaseStatusDocType() {
		assertNotNull(getDocTypeSvc().findByName("StatusMaintenanceDocument"));
	}
	
	@Test
	public void testConveyanceTypeDocType() {
		assertNotNull(getDocTypeSvc().findByName("ConveyanceTypeMaintenanceDocument"));
	}
	
	@Test()
	@Ignore("will maintained as part of conveyance type")
	public void testConveyanceAnnexTypeDocType() {
		assertNotNull(getDocTypeSvc().findByName("ConveyanceAnnexTypeDocument"));
	}
}
