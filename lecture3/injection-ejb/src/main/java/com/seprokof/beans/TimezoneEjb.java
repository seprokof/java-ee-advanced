package com.seprokof.beans;

import javax.annotation.Resource;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Represents environment constant.
 * 
 * @author seprokof
 *
 */
@Singleton
@Lock(LockType.READ)
public class TimezoneEjb {
    @Resource(name = "timezone")
    private String timezone;

    /**
     * Provides environment value represented timezone.
     * 
     * @return sting representation of timezone
     */
    public String getTimezone() {
        return timezone;
    }
}
