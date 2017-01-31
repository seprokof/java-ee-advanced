package com.seprokof.impl;

import com.seprokof.IStorage;

/**
 * Stores data in string representation in the database.
 * 
 * @author seprokof
 *
 */
public class DBStorageAsString implements IStorage {

	@Override
	public void storeData() {
		System.out.println(
				Thread.currentThread().getStackTrace()[2].getClassName() + ": Data was stored in DB as String");
	}
}
