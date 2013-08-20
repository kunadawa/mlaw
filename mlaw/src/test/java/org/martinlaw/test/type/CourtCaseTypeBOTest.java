/**
 * 
 */
package org.martinlaw.test.type;

import org.martinlaw.bo.BaseDetail;
import org.martinlaw.bo.Scope;
import org.martinlaw.bo.courtcase.CourtCaseType;

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

/**
 * test various BO ops for {@link CourtCaseType}
 * 
 * @author mugo
 * 
 */
public class CourtCaseTypeBOTest extends BaseDetailBoTestBase {
	private CourtCaseType kaseType;
	@Override
	public Class<? extends BaseDetail> getDataObjectClass() {
		return CourtCaseType.class;
	}

	/**
	 * 
	 */
	public CourtCaseTypeBOTest() {
		kaseType = new CourtCaseType();
		kaseType.setId(10003l);
		kaseType.setName("commercial");
		kaseType.setDescription("any biz mambo");
	}

	@Override
	public BaseDetail getExpectedOnRetrieve() {
		return kaseType;
	}

	@Override
	public String getDocTypeName() {
		return "CourtCaseTypeMaintenanceDocument";
	}

	@Override
	public Class<? extends Scope> getScopeClass() {
		return null;//does not apply
	}

	/* (non-Javadoc)
	 * @see org.martinlaw.test.type.BaseDetailBoTestBase#testScopeAttributes()
	 */
	@Override
	public void testScopeAttributes() {
		// do nothing as transaction type has no scope
	}

	/* (non-Javadoc)
	 * @see org.martinlaw.test.type.BaseDetailBoTestBase#testScopeCollectionDD()
	 */
	@Override
	public void testScopeCollectionDD() {
		// do nothing as transaction type has no scope
	}
}
