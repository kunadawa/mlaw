/**
 * 
 */
package org.martinlaw.test.contract;

/*
 * #%L
 * mlaw
 * %%
 * Copyright (C) 2012, 2013 Eric Njogu (kunadawa@gmail.com)
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.martinlaw.MartinlawConstants;
import org.martinlaw.bo.MatterConsideration;
import org.martinlaw.bo.contract.Contract;
import org.martinlaw.bo.contract.ContractDuration;
import org.martinlaw.bo.contract.ContractParty;
import org.martinlaw.bo.contract.ContractSignatory;
import org.martinlaw.test.MartinlawTestsBase;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * test various BO ops for {@link Contract}
 * 
 * @author mugo
 * 
 */
public class ContractBOTest extends MartinlawTestsBase {
	private Log log = LogFactory.getLog(getClass());
	@Test(expected = DataIntegrityViolationException.class)
	/**
	 * tests that non nullable fields are checked
	 */
	public void testContractTypeNullableFields() {
		Contract contract = new Contract();
		getBoSvc().save(contract);
	}

	@Test
	/**
	 * test that the {@link Contract} is loaded into the data dictionary
	 */
	public void testContractAttributes() {
		testBoAttributesPresent(Contract.class.getCanonicalName());
		Class<Contract> dataObjectClass = Contract.class;
		verifyMaintDocDataDictEntries(dataObjectClass);
	}

	@Test
	/**
	 * tests retrieving from date inserted via sql
	 */
	public void testContractRetrieve() {
		// retrieve object populated via sql script
		Contract contract = getBoSvc().findBySinglePrimaryKey(Contract.class, 1005l);
		assertNotNull("contract should exist in database", contract);
		assertEquals("contract name not the expected value", "buru ph2 h24", contract.getName());
		assertNotNull("matter type should not be null", contract.getType());
		assertEquals("matter type name does not match", "rent agreement", contract.getType().getName());
		assertNotNull("contract duration should not be null" ,contract.getContractDuration());
		assertNotNull("contract duration start date should not be null", contract.getContractDuration().getStartDate());
		assertNotNull("contract duration end date should not be null", contract.getContractDuration().getEndDate());
		assertNotNull("client principal name should not be null", contract.getClientPrincipalName());
		getTestUtils().testMatterClient(contract, "Client");
		// assignees
		assertNotNull("assignees should not be null", contract.getAssignees());
		assertEquals("number of assignees differs", 1, contract.getAssignees().size());
		assertEquals("assignee name differs", "alice_wanjiru", contract.getAssignees().get(0).getPrincipalName());
		
		getTestUtils().testRetrievedConsiderationFields(contract.getConsiderations().get(0));
		
		getTestUtils().testWorkList(contract.getWork());
		getTestUtils().testMatterClient(contract, "Client");
	}

	@Test
	/**
	 * test CRUD for {@link Contract}
	 */
	public void testContractCRUD() {
		// C
		Contract contract = getTestUtils().getTestContract();
		try {
			/*List<Consideration> considerations = new ArrayList<Consideration>();
			considerations.add((Consideration) getTestUtils().getTestConsideration(Consideration.class));
			contract.setConsiderations(considerations);*/
		} catch (Exception e) {
			fail("could not add consideration");
			log.error(e);
		}
		
		getBoSvc().save(contract);
		// R
		contract.refresh();
		getTestUtils().testContractFields(contract);
		assertNotNull("considerations should not be null", contract.getConsiderations());
		assertEquals("default number of considerations differs", 2, contract.getConsiderations().size());
		assertNotNull("client object should not be null", contract.getClient());
		assertNotNull("client principal name should not be null", contract.getClientPrincipalName());
		// U
		String serviceOffered = "flat 3f2";
		contract.setServiceOffered(serviceOffered);
		contract.refresh();
		assertEquals("contract svc offered does not match after update", serviceOffered, contract.getServiceOffered());
		// D
		getBoSvc().delete(contract);
		assertNull("contract should not exist", getBoSvc().findBySinglePrimaryKey(Contract.class, contract.getId()));
		// the two default considerations should have been deleted
		assertNull("consideration should not exist", getBoSvc().findBySinglePrimaryKey(
				MatterConsideration.class, contract.getConsiderations().get(0).getId()));
		assertNull("consideration should not exist", getBoSvc().findBySinglePrimaryKey(
				MatterConsideration.class, contract.getConsiderations().get(1).getId()));
		assertNull("duration should not exist", getBoSvc().findBySinglePrimaryKey(ContractDuration.class, contract.getId()));
		
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("contractId", contract.getId());
		assertEquals("contract signatories should have been deleted", 0, getBoSvc().findMatching(ContractSignatory.class, criteria).size());
		assertEquals("contract parties should have been deleted", 0, getBoSvc().findMatching(ContractParty.class, criteria).size());
		
	}
	
	@Test
	/**
	 * tests that the document type is loaded ok
	 */
	public void testContractDocType() {
		assertNotNull("document type should not be null", getDocTypeSvc().findByName(MartinlawConstants.DocTypes.CONTRACT ));
	}
}
