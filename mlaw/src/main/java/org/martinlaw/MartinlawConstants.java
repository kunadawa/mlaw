/**
 * 
 */
package org.martinlaw;

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
 * holds constants
 * 
 * @author mugo
 *
 */
public class MartinlawConstants {
	
	public final static String MODULE_NAMESPACE_CODE = "MARTINLAW";
	public final static String VCALENDAR_TEMPLATE_FILE = "vcalendar-template.txt";
	public final static String VCALENDAR_NOTIFICATION_TEMPLATE_MSG_FILE = "vcalendar-ntfcn-msg.txt";
	public final static String EVENT_NOTIFICATION_TEMPLATE_XML = "event-notification-template.xml";
	public final static String VCALENDAR_UID_PATTERN = "^[\\d].*-[\\S].*@mlaw.co.ke$";
	public final static String OPENID_TYPE_CODE = "OPENID";
	public class DocTypes {
		public final static String CONTRACT_WORK = "ContractWorkDocument";
		public static final String COURTCASE_WORK = "CourtCaseWorkDocument";
		public static final String OPINION_WORK = "OpinionWorkDocument";
		public static final String CONVEYANCE_WORK = "ConveyanceWorkDocument";
		public static final String CONTRACT_TRANSACTION = "ContractTransactionDocument";
		public static final String CONVEYANCE_TRANSACTION = "ConveyanceTransactionDocument";
		public static final String COURTCASE_TRANSACTION = "CourtCaseTransactionDocument";
		public static final String OPINION_TRANSACTION = "OpinionTransactionDocument";
		public static final String CONTRACT = "ContractMaintenanceDocument";
	}
	
	public class RequestMappings {
		public final static String TX = "tx";
	}
	
	public class PropertyNames {
		public final static String MATTER_ID = "matterId";
	}
	
	public class MessageKeys {
		public final static String ERROR_NOT_ASSIGNED = "error.notAssigned";
	}
	public class Options {
		public final static String RESTRICT_WORK_TO_ASSIGNEES = "restrict_work_to_assignees";
	}
	
	public class ViewIds {
		public final static String CONTRACT_TRANSACTION = "contract_transaction_doc_view";
		public static final String CONTRACT_WORK = "contract_work_doc_view";
		public static final String CONVEYANCE_WORK = "conveyance_work_doc_view";
		public static final String COURTCASE_WORK = "courtcase_work_doc_view";
		public static final String OPINION_WORK = "opinion_work_doc_view";
		public static final String CONVEYANCE_TRANSACTION = "conveyance_transaction_doc_view";
		public static final String COURTCASE_TRANSACTION = "courtcase_transaction_doc_view";
		public static final String OPINION_TRANSACTION = "opinion_transaction_doc_view";
	}
	
	/**
	 * strings to substitute into the date notification
	 * @see org.martinlaw.bo.MatterEventMaintainable#doRouteStatusChange(DocumentHeader)
	 * @author mugo
	 *
	 */
	public class NotificationTemplatePlaceholders {
		public final static String EDIT_ACTION = "modified";
		public final static String NEW_ACTION = "created";
		public final static String CALENDAR_CHANNEL_NAME = "mLaw Calendar";
		public final static String CALENDAR_PRODUCER_NAME = CALENDAR_CHANNEL_NAME;
	}
	
	/**
	 * keys to replace into the date notification template
	 * @see org.martinlaw.bo.MatterEventMaintainable#doRouteStatusChange(DocumentHeader)
	 * @author mugo
	 *
	 */
	public class NotificationTemplateParameters {
		public final static String ACTION = "action";
		public final static String UID = "uid";
		public final static String CHANNEL_NAME = "channel_name";
		public final static String PRODUCER_NAME = "producer_name";
		public final static String TITLE = "title";
		public final static String MESSAGE = "message";
		public final static String DESCRIPTION = "description";
		public final static String LOCATION = "location";
		public final static String STARTDATETIME = "startDateTime";
		public final static String STOPDATETIME = "stopDateTime";
		public static final String SUMMARY = "summary";
	}
}
