package com.seprokof;

import javax.ejb.Local;

@Local
public interface InterfaceTwo {

    default String getSmile() {
        return InterfaceTwo.class.getSimpleName() + " smiling :)";
    }
    
}
