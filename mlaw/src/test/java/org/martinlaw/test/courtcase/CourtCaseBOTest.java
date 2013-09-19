/**
 * 
 */
package org.martinlaw.test.courtcase;

import org.martinlaw.bo.Matter;
import org.martinlaw.bo.courtcase.CourtCase;

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
	



/**
 * test the data dictionary
 * 
 * @author mugo
 */
//@BaselineTestCase.BaselineMode(BaselineTestCase.Mode.NONE)
public class CourtCaseBOTest extends CourtCaseBoTestBase {

	@Override
	public Class<? extends Matter> getDataObjectClass() {
		return CourtCase.class;
	}

	@Override
	public Long getDataObjectPrimaryKey() {
		return new Long(1001);
	}

	@Override
	public int getExpectedLookupCount() {
		return 4;
	}
}
