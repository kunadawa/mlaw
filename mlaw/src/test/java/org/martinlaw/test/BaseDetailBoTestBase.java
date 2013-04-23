package org.martinlaw.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.martinlaw.bo.BaseDetail;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * holds common tests for children of {@link BaseDetail}
 * @author mugo
 *
 */
public abstract class BaseDetailBoTestBase extends MartinlawTestsBase implements TestBoInfo {

	public BaseDetailBoTestBase() {
		super();
	}

	/**
	 * tests that non nullable fields are validated by the db
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test(expected = DataIntegrityViolationException.class)
	public void testTypeNullableFields() throws InstantiationException, IllegalAccessException {
		BaseDetail type = getDataObjectClass().newInstance();
		getBoSvc().save(type);
	}

	/**
	 * tests data dictionary entries
	 */
	@Test
	public void testBaseDetailAttributes() {
		testBoAttributesPresent(getDataObjectClass().getCanonicalName());
		verifyMaintDocDataDictEntries(getDataObjectClass());
	}

	/**
	 * tests retrieving a BO with pk 1001l
	 */
	@Test
	public void testBaseDetailRetrieve() {
		// retrieve object populated via sql script
		BaseDetail type = getBoSvc().findBySinglePrimaryKey(
				getDataObjectClass(), getExpectedOnRetrieve().getId());
		assertNotNull("retrieved '" + getDataObjectClass() + "' should not be null", type);
		assertEquals("name differs", getExpectedOnRetrieve().getName(), type.getName());
		assertEquals("description differs", getExpectedOnRetrieve().getDescription(), type.getDescription());
	}

	/**
	 * tests CRUD for the bo class provided in {@link #getDataObjectClass()}
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void testContractTypeCRUD() throws InstantiationException, IllegalAccessException {
		// C
		BaseDetail type = getDataObjectClass().newInstance();
		String name = "test type";
		type.setName(name);
		getBoSvc().save(type);
		// R
		type.refresh();
		assertEquals("name does not match", name, type.getName());
		// U
		type.setDescription("test description");
		type.refresh();
		assertNotNull("description should not be null", type.getDescription());
		// D
		getBoSvc().delete(type);
		assertNull(getBoSvc().findBySinglePrimaryKey(getDataObjectClass(),	type.getId()));
	}

	/**
	 * tests that the document type name can be found
	 */
	@Test
	public void testBaseDetailDocType() {
		assertNotNull("document type should not be null", getDocTypeSvc().findByName(getDocTypeName()));
	}
	
	/**
	 * 
	 * @return a bo containing the expected values to be compared to the bo retrieved from the db 
	 */
	public abstract BaseDetail getExpectedOnRetrieve();
}