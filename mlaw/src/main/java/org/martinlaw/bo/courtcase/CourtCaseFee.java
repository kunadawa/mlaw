/**
 * 
 */
package org.martinlaw.bo.courtcase;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.martinlaw.bo.MatterFee;

/**
 * CourtCaseFee represents a fee paid to a lawyer by a client for a court case
 * @author mugo
 */
@Entity
@Table(name="martinlaw_court_case_fee_t")

public class CourtCaseFee extends MatterFee {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5139498341007335334L;
}
