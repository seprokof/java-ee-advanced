package com.seprokof.impl;

import com.seprokof.IStorage;

/**
 * Stores binary representation of data in the database.
 * 
 * @author seprokof
 *
 */
public class DBStorageAsBinary implements IStorage {

	@Override
	public void storeData() {
		System.out.println(
				Thread.currentThread().getStackTrace()[2].getClassName() + ": Data was stored in DB as Binary");
	}
}
