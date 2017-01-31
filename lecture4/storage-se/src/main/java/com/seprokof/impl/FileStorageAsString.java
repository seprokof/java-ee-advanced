package com.seprokof.impl;

import com.seprokof.IStorage;

/**
 * Stores data in string representation in the file.
 * 
 * @author seprokof
 *
 */
public class FileStorageAsString implements IStorage {

	@Override
	public void storeData() {
		System.out.println(
				Thread.currentThread().getStackTrace()[2].getClassName() + ": Data was stored in file as String");
	}
}
