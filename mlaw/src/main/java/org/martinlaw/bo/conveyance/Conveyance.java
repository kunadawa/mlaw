/**
 * 
 */
package org.martinlaw.bo.conveyance;

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


import javax.persistence.Entity;
import javax.persistence.Table;
import org.martinlaw.bo.Matter;

/**
 * holds information that keeps  track of a conveyancing matter
 * 
 * @author mugo
 */
@Entity
@Table(name="martinlaw_conveyance_t")
public class Conveyance extends Matter {
	/**
	 * default constructor which calls super class constructor
	 */
	public Conveyance() {
		super();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7207626236630736596L;
}
