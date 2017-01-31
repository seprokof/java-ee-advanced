package com.seprokof.impl;

import com.seprokof.IStorage;

/**
 * Stores data in binary representation in the file.
 * 
 * @author seprokof
 *
 */
public class FileStorageAsBinary implements IStorage {

	@Override
	public void storeData() {
		System.out.println(
				Thread.currentThread().getStackTrace()[2].getClassName() + ": Data was stored in file as Binary");
	}
}
