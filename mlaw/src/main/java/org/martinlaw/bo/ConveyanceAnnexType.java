/**
 * 
 */
package org.martinlaw.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * defines a type of conveyance annex (attachment) as will be referred to by a conveyance type
 * e.g. land board approval or lease agreement
 * 
 * @author mugo
 *
 */
@Entity
@Table(name="martinlaw_convey_annex_type_t")
public class ConveyanceAnnexType extends BaseDetail {
	/**
	 * 
	 */
	private static final long serialVersionUID = 971771175104844067L;
	@Id
	@Column(name="convey_annex_type_id")
	Long id;
	
	/**
	 * get the primary key
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
