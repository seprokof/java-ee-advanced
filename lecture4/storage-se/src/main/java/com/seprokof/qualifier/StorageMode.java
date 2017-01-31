package com.seprokof.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
public @interface StorageMode {
	StorageModeName value();

	public enum StorageModeName {
		STRING_FILE, BINARY_FILE, STRING_DB, BINARY_DB
	}
}
