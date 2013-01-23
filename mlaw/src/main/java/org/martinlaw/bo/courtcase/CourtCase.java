/**
 * 
 */
package org.martinlaw.bo.courtcase;

/*
 * #%L
 * mlaw
 * %%
 * Copyright (C) 2012 Eric Njogu (kunadawa@gmail.com)
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.martinlaw.bo.Matter;



/**
 * represents a court case
 * 
 * @author mugo
 */
@Entity
@Table(name="martinlaw_court_case_t")
public class CourtCase extends Matter<Assignee, Work, ClientFee, Client, Consideration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431403352189825050L;
	
	/**
	 * court number - could be initially null as we await to file the papers in court
	 * 
	 */
	@Column(name="court_reference", length=20) 
	private String courtReference;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},  mappedBy="courtCaseId")
	private List<CourtCaseWitness> witnesses;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},  mappedBy="matterId")
	private List<MyDate> dates;
	
	public CourtCase() {
		super();
		//initialize collections
		setClients(new ArrayList<Client>());
		setWitnesses(new ArrayList<CourtCaseWitness>());
		setDates(new ArrayList<MyDate>());
	}
	/**
	 * @return the courtReference
	 */
	public String getCourtReference() {
		return courtReference;
	}
	/**
	 * @param courtReference the courtReference to set
	 */
	public void setCourtReference(String courtReference) {
		this.courtReference = courtReference;
	}
	
	/**
	 * @return the witnesses
	 */
	public List<CourtCaseWitness> getWitnesses() {
		return witnesses;
	}
	/**
	 * @param witnesses the witnesses to set
	 */
	public void setWitnesses(List<CourtCaseWitness> witnesses) {
		this.witnesses = witnesses;
	}
	/**
	 * @param dates the dates to set
	 */
	public void setDates(List<MyDate> myDates) {
		this.dates = myDates;
	}
	/**
	 * @return the dates
	 */
	public List<MyDate> getDates() {
		return dates;
	}
	/**
	 * @return the clients
	 */
	
	@Override
	public Class<Work> getWorkClass() {
		return Work.class;
	}
	@Override
	public Class<ClientFee> getFeeClass() {
		return ClientFee.class;
	}
}
