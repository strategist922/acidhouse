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

import java.util.Date;

/**
 * {@code Lock} is a built-in object which represents that a datastore entity 
 * is locked by the {@code ResourceManager}. 
 * This object is used for the distributed locking provided by the Acid House 
 * implementation.
 * 
 * @author <a href="mailto:eiichiro@eiichiro.org">Eiichiro Uchiumi</a>
 */
public class Lock {

	private final String id;
	
	private final String transaction;
	
	private final Date timestamp;
	
	/**
	 * Constructs a new {@code Lock} entity with the specified lock id, 
	 * the transaction id which allocates this lock and the timestamp when this 
	 * lock is allocated.
	 * 
	 * @param id The lock id.
	 * @param transaction The transaction id which this lock is allocated.
	 * @param timestamp The timestamp which this lock is allocated.
	 */
	public Lock(String id, String transaction, Date timestamp) {
		this.id = id;
		this.transaction = transaction;
		this.timestamp = timestamp;
	}

	/**
	 * Returns the lock id.
	 * 
	 * @return The lock id.
	 */
	public String id() {
		return id;
	}

	/**
	 * Returns the transaction id which this lock is allocated.
	 * 
	 * @return The transaction id which this lock is allocated.
	 */
	public String transaction() {
		return transaction;
	}

	/**
	 * Returns the timestamp which this lock is allocated.
	 * 
	 * @return The timestamp which this lock is allocated.
	 */
	public Date timestamp() {
		return timestamp;
	}
	
}
