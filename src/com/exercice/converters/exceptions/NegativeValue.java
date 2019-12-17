package com.exercice.converters.exceptions;

public class NegativeValue extends Exception { 
    public NegativeValue(String errorMessage) {
        super(errorMessage);
    }
}