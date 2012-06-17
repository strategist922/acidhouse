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

import org.eiichiro.acidhouse.metamodel.Property;

/**
 * {@code Update} is a command interface to update properties of 
 * Session entity matches to the specified {@code Filter}s with the specified 
 * value in Acid House's transactional session.
 * This command execution returns the count of updated entities. You can build 
 * &amp; execute this command as the following code: 
 * <pre>
 * import org.eiichiro.acidhouse.Session;
 * import org.eiichiro.acidhouse.appengine.AppEngineDatastoreSession;
 * ...
 * 
 * Session session = new AppEngineDatastoreSession();
 * Transaction transaction = session.beginTransaction();
 * 
 * try {
 * 	session.update(Entity3.class)
 * 			.property(entity3_.i, 100)
 * 			.property(entity3_.entity1.i, 200)
 * 			.filter(entity3_.id.equalTo("Key1"))
 * 			.execute();
 * 	transaction.commit();
 * } catch (Exception e) {
 * 	transaction.rollback();
 * 	throw e;
 * } finally {
 * 	session.close();
 * }
 * </pre>
 * 
 * @author <a href="mailto:eiichiro@eiichiro.org">Eiichiro Uchiumi</a>
 */
public interface Update<E> extends Command<Integer> {

	/**
	 * Qualifies property to be updated by this {@code Update}.
	 * 
	 * @param property The property to be updated by this 
	 * {@code Update}.
	 * @param value The property value to be updated to.
	 * @return The {@code Update} to update the specified entity 
	 * properties.
	 */
	public <T> Update<E> property(Property<?, T> property, T value);
	
	/**
	 * Qualifies entities to be updated with the specified {@code Filter}s.
	 * Each of the specified filters is combined with "logical and".
	 * 
	 * @param filters {@code Filter}s to qualify entities to be updated.
	 * @return The {@code Update} to update entities qualified with the 
	 * specified {@code Filter}s.
	 */
	public Update<E> filter(Filter<?>... filters);
	
}
