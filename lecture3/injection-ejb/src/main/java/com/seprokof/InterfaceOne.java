package com.seprokof;

import javax.ejb.Local;

@Local
public interface InterfaceOne {

    default String getJoke() {
        return InterfaceOne.class.getSimpleName() + " tells a joke";
    }
    
}
