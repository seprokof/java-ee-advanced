package com.seprokof.producer;

import javax.enterprise.inject.Produces;

import com.seprokof.IStorage;
import com.seprokof.impl.DBStorageAsBinary;
import com.seprokof.impl.DBStorageAsString;
import com.seprokof.impl.FileStorageAsBinary;
import com.seprokof.impl.FileStorageAsString;
import com.seprokof.qualifier.StorageMode;
import com.seprokof.qualifier.StorageMode.StorageModeName;

/**
 * Produces all possible storages.
 * 
 * @author seprokof
 *
 */
public class StorageFactory {

	@Produces
	@StorageMode(StorageModeName.BINARY_DB)
	public IStorage getBinaryDatabase() {
		return new DBStorageAsBinary();
	}

	@Produces
	@StorageMode(StorageModeName.BINARY_FILE)
	public IStorage getBinaryFile() {
		return new FileStorageAsBinary();
	}

	@Produces
	@StorageMode(StorageModeName.STRING_DB)
	public IStorage getStringDatabase() {
		return new DBStorageAsString();
	}

	@Produces
	@StorageMode(StorageModeName.STRING_FILE)
	public IStorage getStringFile() {
		return new FileStorageAsString();
	}
}
