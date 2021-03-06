/**
 * 
 */
package org.martinlaw.test.type;

/*
 * #%L
 * mlaw
 * %%
 * Copyright (C) 2013 Eric Njogu (kunadawa@gmail.com)
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


import org.junit.Test;
import org.martinlaw.bo.Type;
import org.martinlaw.bo.MatterAnnexType;
import static org.junit.Assert.assertTrue;

/**
 * various tests for {@link MatterAnnexType}
 * @author mugo
 *
 */
public class MatterAnnexTypeBOTest extends TypeBoTestBase {

	@Override
	public Class<? extends Type> getDataObjectClass() {
		return MatterAnnexType.class;
	}

	@Override
	public String getDocTypeName() {
		return "MatterAnnexTypeMaintenanceDocument";
	}

	@Override
	public Type getExpectedOnRetrieve() {
		MatterAnnexType annexType = new MatterAnnexType();
		annexType.setDescription("default annex type -  any document");
		annexType.setName("document");
		annexType.setId(11001l);
		
		return annexType;
	}

	@Override
	protected void populateAdditionalFieldsForCrud(Type type) {
		MatterAnnexType annexType = (MatterAnnexType)type;
		annexType.setRequiresApproval(true);
	}

	@Override
	protected void additionalTestsForRetrievedObject(Type type) {
		testCrudCreated(type);
	}

	@Override
	protected void testCrudCreated(Type type) {
		MatterAnnexType annexType = (MatterAnnexType)type;
		assertTrue("requires approval should be true", annexType.getRequiresApproval());
	}

	@Override
	protected void testCrudDeleted(Type type) {
		// DO nothing
	}
	
	@Test
	/**
	 * test that matter annex type key values returns the correct number
	 */
	public void testMatterAnnexTypeKeyValues() {
		final String dataObjectName = "matter annex type(s)";
		final int expectedCourtCaseScopeCount = 3;
		final int expectedContractScopeCount = 0;
		final int expectedConveyanceScopeCount = 2;
		final int expectedEmptyScopeCount = 6;
		final int expectedMatterScopeCount = 0;
		final int expectedLandCaseScopeCount = 0;
		
		getTestUtils().testScopeKeyValues(dataObjectName, expectedCourtCaseScopeCount,
				expectedContractScopeCount, expectedConveyanceScopeCount,
				expectedEmptyScopeCount, expectedMatterScopeCount,
				expectedLandCaseScopeCount, getDataObjectClass());
	}
}
