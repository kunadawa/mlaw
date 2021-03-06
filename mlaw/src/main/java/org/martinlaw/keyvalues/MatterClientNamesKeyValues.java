/**
 * 
 */
package org.martinlaw.keyvalues;

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


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KRADServiceLocator;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.rice.krad.web.form.InquiryForm;
import org.martinlaw.bo.Matter;
import org.martinlaw.bo.MatterClient;
import org.martinlaw.bo.MatterConsideration;
import org.martinlaw.bo.MatterTxDocBase;
import org.martinlaw.web.MatterTxForm;

/**
 * generate client names (value) and principal names (key) for use e.g. on fee TX docs
 * 
 * @author mugo
 *
 */
public class MatterClientNamesKeyValues extends UifKeyValuesFinderBase {
	private BusinessObjectService businessObjectService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6846503154489611649L;

	/* (non-Javadoc)
	 * @see org.kuali.rice.krad.uif.control.UifKeyValuesFinder#getKeyValues(org.kuali.rice.krad.uif.view.ViewModel)
	 */
	/**
	 * unit test in {@link org.martinlaw.test.contract.ContractTransactionDocBOTest#testClientNamesKeyValues()}
	 */
	@Override
	public List<KeyValue> getKeyValues(ViewModel model) {
		List<KeyValue> keyValues = new ArrayList<KeyValue>();
		Matter matter = null;
		if (model instanceof MatterTxForm) {
			MatterTxForm form = (MatterTxForm) model;
			if (form.getDocument() != null) {
				MatterTxDocBase doc = ((MatterTxDocBase)form.getDocument());
				if (doc.isMatterIdValid()) {
					matter = getBusinessObjectService().findBySinglePrimaryKey(
						Matter.class, doc.getMatterId());
				}
			}
		} else if (model instanceof InquiryForm) {
			InquiryForm form = (InquiryForm) model;
			if (form.getDataObject() instanceof Matter) {
				matter = (Matter) form.getDataObject();
			} else if (form.getDataObject() instanceof MatterConsideration) {
				matter = ((MatterConsideration) form.getDataObject()).getMatter();
			}
		}
		if (matter != null && matter.getClients() != null && !matter.getClients().isEmpty()) {
			for (Object clientObj: matter.getClients()) {
				MatterClient client = (MatterClient)clientObj;
				String value = client.getPerson().getName();
				if (StringUtils.isEmpty(value)) {
					value = client.getPrincipalName();
				}
				keyValues.add(new ConcreteKeyValue(client.getPrincipalName(), value));
			}
		}
		return keyValues;
	}

	/**
	 * mock friendly reference to business object service
	 * @return the businessObjectService
	 */
	public BusinessObjectService getBusinessObjectService() {
		if (businessObjectService == null) {
			return KRADServiceLocator.getBusinessObjectService();
		}
		return businessObjectService;
	}

	/**
	 * @param businessObjectService the businessObjectService to set
	 */
	public void setBusinessObjectService(BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}
}
