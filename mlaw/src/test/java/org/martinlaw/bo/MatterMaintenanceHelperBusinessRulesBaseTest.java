/**
 * 
 */
package org.martinlaw.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.kuali.rice.krad.maintenance.Maintainable;
import org.kuali.rice.krad.maintenance.MaintenanceDocument;
import org.kuali.rice.krad.service.DataDictionaryService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.martinlaw.MartinlawConstants;
import org.martinlaw.bo.courtcase.CourtCase;
/**
 * @author mugo
 *
 */
public class MatterMaintenanceHelperBusinessRulesBaseTest {

	private MatterMaintenanceHelperBusinessRulesBase rulesBase;
	private MaintenanceDocument document;
	private Maintainable maintainable;
	private MatterExtensionHelper maintHelper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rulesBase = new MatterMaintenanceHelperBusinessRulesBase();
		// mock the data dictionary svc since fetching it from KRADServiceLocatorWeb results in null pointer exception
		DataDictionaryService ddSvc = mock(DataDictionaryService.class);
		when(ddSvc.getAttributeLabel(CourtCase.class, MartinlawConstants.PropertyNames.MATTER_ID)).thenReturn("Court Case");
		rulesBase.getRulesHelper().setDataDictionaryService(ddSvc);
		
		document = mock(MaintenanceDocument.class);
		maintainable = mock(Maintainable.class);
		when(document.getNewMaintainableObject()).thenReturn(maintainable);
		maintHelper = mock(MatterExtensionHelper.class);
	}

	/**
	 * Test method for {@link org.martinlaw.bo.MatterMaintenanceHelperBusinessRulesBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.krad.document.Document)}.
	 *<p>Verify that only a maintenance doc will be accepted</p>
	 *//*
	@Test(expected=RuntimeException.class)
	public void testProcessCustomRouteDocumentBusinessRulesDocument_NotMaintenanceDoc() {
		rulesBase.processCustomRouteDocumentBusinessRules(new TransactionDoc());
	}*/
	
	/**
	 * tests {@link org.martinlaw.bo.MatterMaintenanceHelperBusinessRulesBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.krad.document.Document)}
	 * <p>verify that nulls in {@link org.kuali.rice.krad.maintenance.MaintenanceDocument#getNewMaintainableObject()} contains a data object
	 *  of type {@link org.martinlaw.bo.MatterExtensionHelper}</p>
	 */
	@Test(expected=RuntimeException.class)
	public void testProcessCustomRouteDocumentBusinessRulesDocument_NotMaintenanceHelper() {
		// return non org.martinlaw.bo.MatterExtensionHelper - a string (null will also generate the error)
		when(maintainable.getDataObject()).thenReturn("Joel 2:12-27");
		rulesBase.processCustomRouteDocumentBusinessRules(document);
	}
	
	/**
	 * tests {@link org.martinlaw.bo.MatterMaintenanceHelperBusinessRulesBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.krad.document.Document)}
	 * <p>verifies that global variables has an error when the matter id is invalid</p> 
	 */
	@Test
	public void testProcessCustomRouteDocumentBusinessRulesDocument_InvalidMatterId() {
		when(maintHelper.isMatterIdValid()).thenReturn(false);
		when(maintainable.getDataObject()).thenReturn(maintHelper);
		
		assertFalse("should have returned 'false'", rulesBase.processCustomRouteDocumentBusinessRules(document));
		assertTrue("there should be errors", GlobalVariables.getMessageMap().hasErrors());
		assertEquals("number of error messages expected differs", 1, GlobalVariables.getMessageMap().getErrorCount());
	}
	
	/**
	 * verifies that {@link org.martinlaw.bo.MatterMaintenanceHelperBusinessRulesBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.krad.document.Document)}
	 * returns true when {@link  org.martinlaw.bo.MatterExtensionHelper#isMatterIdValid()} is true 
	 */
	@Test
	public void testProcessCustomRouteDocumentBusinessRulesDocument_ValidMatterId() {
		when(maintHelper.isMatterIdValid()).thenReturn(true);
		when(maintainable.getDataObject()).thenReturn(maintHelper);
		assertTrue("should have returned 'true'", rulesBase.processCustomRouteDocumentBusinessRules(document));
	}

}
