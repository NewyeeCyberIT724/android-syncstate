/*
 * Copyright (C) 2015 Marten Gajda <marten@dmfs.org>
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
 * 
 */

package org.dmfs.android.syncstate;

import java.io.Closeable;
import java.io.IOException;

import org.dmfs.xmlobjects.ElementDescriptor;
import org.dmfs.xmlobjects.XmlContext;


/**
 * Interface of an object that can modify the sync state of a specific account and authority.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 */
public interface SyncState extends SyncStateReader, Closeable
{
	/**
	 * Load the current sync state of the account and authority into this instance, using the default {@link XmlContext}.
	 * 
	 * @throws IOException
	 *             if the sync state can't be read.
	 */
	public void load() throws IOException;


	/**
	 * Load the current sync state of the account and authority into this instance, using the given {@link XmlContext}.
	 * 
	 * @param xmlContext
	 *            The {@link XmlContext} to use.
	 * @throws IOException
	 *             if the sync state can't be read.
	 */
	public void load(XmlContext xmlContext) throws IOException;


	/**
	 * Add the given key value pair to the sync state, overriding any previous value for the given key.
	 * 
	 * @param key
	 *            The key to store.
	 * @param value
	 *            he value to store.
	 * @return The previously stored value or <code>null</code> if there was none.
	 */
	public <V> V set(ElementDescriptor<V> key, V value);


	/**
	 * Persist the sync state using the default {@link XmlContext}.
	 * 
	 * @throws IOException
	 *             if the sync state can't be written.
	 */
	public void store() throws IOException;


	/**
	 * Persist the sync state using the given {@link XmlContext}.
	 * 
	 * @param xmlContext
	 *            An {@link XmlContext} to use.
	 * 
	 * @throws IOException
	 *             if the sync state can't be written.
	 */
	public void store(XmlContext xmlContext) throws IOException;
}