package com.seprokof;

import javax.ejb.Local;

@Local
public interface InterfaceThree {

    default String rollDice() {
        return InterfaceThree.class.getSimpleName() + " rolled dice";
    }

}
