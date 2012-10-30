/**
 * 
 */
package org.martinlaw.bo.conveyance;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.martinlaw.bo.MatterClient;


/**
 * associates a conveyance to a kuali person
 * 
 * @author mugo
 * 
 */
@Entity(name="convey_client")
@Table(name="martinlaw_convey_client_t")
public class Client extends MatterClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800087268722126582L;

}