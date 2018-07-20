package com.awakening.capp.exception;

/**
 *
 * @author hoangit
 */
public class UserBlockException extends Exception{
    public UserBlockException() {
        
    } 
    
     public UserBlockException(String errDesc) {
        super(errDesc);
    } 
}
