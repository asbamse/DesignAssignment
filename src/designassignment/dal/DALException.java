/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

/**
 *
 * @author janvanzetten
 */
class DALException extends Exception{

    public DALException(String message) {
        super(message);
    }

    public DALException(String message, Throwable cause) {
        super(message, cause);
    }

    public DALException(Throwable cause) {
        super(cause);
    }
   
}
