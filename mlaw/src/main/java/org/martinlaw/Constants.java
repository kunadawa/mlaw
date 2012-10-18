/**
 * 
 */
package org.martinlaw;

/**
 * holds constants
 * 
 * @author mugo
 *
 */
public class Constants {
	public class DocTypes {
		public final static String CONTRACT_WORK = "ContractWorkDocument";
		public static final String COURTCASE_WORK = "CourtCaseWorkDocument";
		public static final String OPINION_WORK = "OpinionWorkDocument";
		public static final String CONVEYANCE_WORK = "ConveyanceWorkDocument";
	}
	
	public class RequestMappings {
		public final static String WORK = "work";
	}
	
	public class PropertyNames {
		public final static String MATTER_ID = "matterId";
	}
	
	public class MessageKeys {
		public final static String ERROR_NOT_INITIATOR = "error.notInitiator";
	}
}
