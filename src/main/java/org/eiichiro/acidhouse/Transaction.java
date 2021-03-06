/*
 * Copyright (C) 2011 Eiichiro Uchiumi. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eiichiro.acidhouse;

/**
 * {@code Transaction} represents a Session transaction.
 * 
 * @author <a href="mailto:eiichiro@eiichiro.org">Eiichiro Uchiumi</a>
 */
public interface Transaction {

	/**
	 * Returns the transaction id.
	 * 
	 * @return The transaction id.
	 */
	public String id();
	
	/**
	 * Commits the current transaction.
	 * 
	 * @throws IndoubtException When data consistency has broken in current 
	 * transaction.
	 */
	public void commit() throws IndoubtException;
	
	/** Rolls back the current transaction. */
	public void rollback();
	
}
