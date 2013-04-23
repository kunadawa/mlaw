package org.martinlaw.bo;

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


import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * associates a transaction with a matter
 * 
 * @author mugo
 *
 */
@MappedSuperclass
public abstract class MatterTransaction extends MatterExtensionHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -818929880498017758L;
	@Id
	@Column(name = "transaction_id")
	Long id;
	@Column(scale = 2, precision = 10, nullable = false)
	private BigDecimal amount;
	@Column(name = "transaction_date", nullable = false)
	private Date date;
	@Column(name = "client_principal_name", length = 100, nullable = false)
	private String clientPrincipalName;
	@Column(name = "consideration_id", nullable = false)
	private long considerationId;
/*	@OneToOne
	@JoinColumn(name = "consideration_id", nullable = false, updatable = false)
	private K consideration;*/
	@Transient
	private long transactionTypeId;
	@OneToOne
	@JoinColumn(name = "transaction_type_id", nullable = false, updatable = false)
	private TransactionType transactionType;

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

	public MatterTransaction() {
		super();
	}

	/**
	 * e.g. 20,000.50
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * e.g. 12-Jun-2011o[
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * gets the principal name of the client who made this payment
	 * 
	 * @return the clientPrincipalName
	 */
	public String getClientPrincipalName() {
		return clientPrincipalName;
	}

	/**
	 * @param clientPrincipalName the clientPrincipalName to set
	 */
	public void setClientPrincipalName(String clientPrincipalName) {
		this.clientPrincipalName = clientPrincipalName;
	}

	/**
	 * @return the considerationId
	 */
	public long getConsiderationId() {
		return considerationId;
	}

	/**
	 * @param considerationId the considerationId to set
	 */
	public void setConsiderationId(long considerationId) {
		this.considerationId = considerationId;
	}

	/**
	 * this is less complex than adding consideration as a generic type to the class def since all we need from consideration
	 * is to show some additional fields below the chosen consideration id field e.g. consideration type, amount
	 * @return the consideration
	 */
	public abstract MatterConsideration getConsideration();

	/**
	 * @return the transactionTypeId
	 */
	public long getTransactionTypeId() {
		return transactionTypeId;
	}

	/**
	 * @param transactionTypeId the transactionTypeId to set
	 */
	public void setTransactionTypeId(long transactionTypeid) {
		this.transactionTypeId = transactionTypeid;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}