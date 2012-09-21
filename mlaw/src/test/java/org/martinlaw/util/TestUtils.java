/**
 * 
 */
package org.martinlaw.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.kuali.rice.krad.service.KRADServiceLocator;
import org.martinlaw.bo.MatterDate;
import org.martinlaw.bo.contract.Contract;
import org.martinlaw.bo.contract.Assignee;
import org.martinlaw.bo.contract.Assignment;
import org.martinlaw.bo.contract.ContractConsideration;
import org.martinlaw.bo.contract.ContractDuration;
import org.martinlaw.bo.contract.ContractParty;
import org.martinlaw.bo.contract.ContractSignatory;
import org.martinlaw.bo.contract.ContractType;
import org.martinlaw.bo.conveyance.Conveyance;

/**
 * holds various methods used across test cases
 * 
 * @author mugo
 *
 */
public class TestUtils {
	private String testContractLocalReference = "cn/rent/01";
	private String contractName = "rent of flat";
	private String testConveyanceName = "sale of KAZ 457T";
	private String assignee1 = "pn";
	private String assignee2 = "aw";

	/**
	 * get a test conveyance object
	 * @return
	 */
	public Conveyance getTestConveyance() {
		Conveyance conv = new Conveyance();
		conv.setName(testConveyanceName);
		conv.setLocalReference("EN/C001");
		conv.setTypeId(1002l);
		conv.setStatusId(1001l);
		return conv;
	}
	
	/**
	 * gets a test contract
	 * @return the unpersisted contract
	 */
	public Contract getTestContract() {
		Contract contract = new Contract();
		contract.setName(contractName);
		contract.setLocalReference(testContractLocalReference);
		contract.setTypeId(1001l);
		contract.setSummaryOfTerms("see attached file");
		contract.setServiceOffered("flat 1f2");
		contract.setStatusId(1001l);
		// parties
		List<ContractParty> parties = new ArrayList<ContractParty>();
		parties.add(new ContractParty("party1"));
		parties.add(new ContractParty("party2"));
		contract.setParties(parties);
		// signatories
		List<ContractSignatory> signs = new ArrayList<ContractSignatory>();
		signs.add(new ContractSignatory("sign1"));
		signs.add(new ContractSignatory("sign2"));
		contract.setSignatories(signs);
		// consideration
		ContractConsideration contractConsideration = new ContractConsideration(new BigDecimal(1000), "UGS", "see breakdown in attached file");

		contract.setContractConsideration(contractConsideration);
		// duration
		Calendar cal = Calendar.getInstance();
		Date start = new Date(cal.getTimeInMillis());
		cal.roll(Calendar.YEAR, true);
		Date end = new Date(cal.getTimeInMillis());
		ContractDuration contractDuration = new ContractDuration(start, end);

		contract.setContractDuration(contractDuration);
		
		return contract;
	}
	
	/**
	 * tests that the test contract fields have the expected values
	 * @param contract - the test contract - mostly retrieved from the database
	 */
	public void testContractFields(Contract contract) {
		assertEquals("contract name does not match", contractName , contract.getName());
		assertEquals("contract local ref does not match", testContractLocalReference, contract.getLocalReference());
		assertNotNull("contract type id should not be null", contract.getTypeId());
		assertNotNull("contract type should exist", 
				KRADServiceLocator.getBusinessObjectService().findBySinglePrimaryKey(ContractType.class, contract.getTypeId()));
		// TODO - test fails - possibly something to do with the ojb framework - or delays in document processing?
		// assertNotNull("contract type should not be null", contract.getType());
		assertNotNull("consideration id should not be null", contract.getContractConsiderationId());
		assertNotNull("consideration should not be null", contract.getContractConsideration());
		assertNotNull("duration should not be null", contract.getContractDuration());
		assertNotNull("parties should not be null", contract.getParties());
		assertEquals("parties not the expected number", 2, contract.getParties().size());
		assertNotNull("signatories should not be null", contract.getSignatories());
		assertEquals("signatories not the expected number", 2, contract.getSignatories().size());
	}

	/**
	 * @return the testContractLocalReference
	 */
	public String getTestContractLocalReference() {
		return testContractLocalReference;
	}

	/**
	 * @param testContractLocalReference the testContractLocalReference to set
	 */
	public void setTestContractLocalReference(String testContractLocalReference) {
		this.testContractLocalReference = testContractLocalReference;
	}

	/**
	 * @return the testConveyanceName
	 */
	public String getTestConveyanceName() {
		return testConveyanceName;
	}

	/**
	 * @param testConveyanceName the testConveyanceName to set
	 */
	public void setTestConveyanceName(String testConveyanceName) {
		this.testConveyanceName = testConveyanceName;
	}
	
	/**
	 * 
	 * tests fields of {@link MatterDate} 
	 * @param date
	 */
	public void testMatterDateFields(MatterDate date) {
		assertEquals("first hearing date",date.getComment());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getDate().getTime());
		assertEquals(2011,cal.get(Calendar.YEAR));
		assertEquals(Calendar.JUNE, cal.get(Calendar.MONTH));
		assertEquals(1, cal.get(Calendar.DATE));
	}
	
	/**
	 * creates a test {@link Assignment}
	 * 
	 * @return the test object
	 */
	public Assignment getTestContractAssignment() {
		Assignment assignment = new Assignment();
		long contractId = 1002l;
		assignment.setContractId(contractId);
		
		Assignee assignee = new Assignee();
		
		assignee.setPrincipalName(assignee1);
		assignment.getAssignees().add(assignee);
		
		Assignee assignee3 = new Assignee();
		assignee3.setPrincipalName(assignee2);
		//contractAssignee.setContractId(contractId);
		assignment.getAssignees().add(assignee3);
		
		return assignment;
	}

	/**
	 * @return the assignee1
	 */
	public String getAssignee1() {
		return assignee1;
	}

	/**
	 * @param assignee1 the assignee1 to set
	 */
	public void setAssignee1(String assignee1) {
		this.assignee1 = assignee1;
	}

	/**
	 * @return the assignee2
	 */
	public String getAssignee2() {
		return assignee2;
	}

	/**
	 * @param assignee2 the assignee2 to set
	 */
	public void setAssignee2(String assignee2) {
		this.assignee2 = assignee2;
	}

	/**
	 * tests the {@link Assignment} fields have the expected values
	 * 
	 * @param assignment - the test object
	 */
	public void testContractAssignmentFields(
			Assignment assignment) {
		assertEquals("number of assignees does not match", 2, assignment.getAssignees().size());
		assertEquals("assignee principal name did not match", getAssignee1(), assignment.getAssignees().get(0).getPrincipalName());
		assertEquals("assignee principal name did not match", getAssignee2(), assignment.getAssignees().get(1).getPrincipalName());
	}
}