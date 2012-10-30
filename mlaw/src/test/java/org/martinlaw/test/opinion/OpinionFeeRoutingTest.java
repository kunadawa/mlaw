/**
 * 
 */
package org.martinlaw.test.opinion;

import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.test.SQLDataLoader;
import org.martinlaw.Constants;
import org.martinlaw.bo.MatterTxDocBase;
import org.martinlaw.test.TxRoutingTestBase;

/**
 * tests {@link org.martinlaw.bo.opinion.ClientFee} routing
 * 
 * @author mugo
 *
 */
public class OpinionFeeRoutingTest extends TxRoutingTestBase {

	/* (non-Javadoc)
	 * @see org.martinlaw.test.MartinlawTestsBase#setUpInternal()
	 */
	@Override
	protected void setUpInternal() throws Exception {
		super.setUpInternal();
		GlobalVariables.setUserSession(new UserSession("clerk1"));
		setDocType(Constants.DocTypes.OPINION_FEE);
		setWorkDoc((MatterTxDocBase) KRADServiceLocatorWeb.getDocumentService().getNewDocument(getDocType()));
	}
	
	@Override
	protected void loadSuiteTestData() throws Exception {
		super.loadSuiteTestData();
		new SQLDataLoader("classpath:org/martinlaw/scripts/opinion-test-data.sql", ";").runSql();
	}
}