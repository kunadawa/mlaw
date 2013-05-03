/**
 * 
 */
package org.martinlaw;

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

import java.util.List;

import org.kuali.rice.core.api.util.KeyValue;
import org.martinlaw.bo.Scope;

/**
 * defines an object which is going to be displayed in a drop down, but only if its scope is empty or allows
 * @author mugo
 *
 */
public interface ScopedKeyValue extends KeyValue {
	public List<? extends Scope> getScope();
}
