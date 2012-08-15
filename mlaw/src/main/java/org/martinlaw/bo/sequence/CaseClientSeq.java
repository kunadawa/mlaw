package org.martinlaw.bo.sequence;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * used to get hibernate to create a sequence file for {@link org.martinlaw.bo.CourtCaseFee}
 * 
 * @author mugo
 *
 */

@Entity
@Table(name="martinlaw_court_case_client_id_s")
public class CaseClientSeq {
	@Id
	@Column(columnDefinition="bigint auto_increment")
	private BigInteger id;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
}