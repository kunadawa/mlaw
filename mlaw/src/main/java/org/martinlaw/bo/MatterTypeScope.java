/**
 * 
 */
package org.martinlaw.bo;

/*
 * #%L
 * mlaw
 * %%
 * Copyright (C) 2013 Eric Njogu (kunadawa@gmail.com)
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


/**
 * gives information on which matter(s) a matter type applies to
 * {@link MatterType} (one) -> {@link MatterTypeScope} (many)
 * @author mugo
 *
 */
@Entity
@Table(name="martinlaw_matter_type_scope_t")
public class MatterTypeScope extends Scope {
	/**
	 * 
	 */
	private static final long serialVersionUID = 698178229853855467L;
}