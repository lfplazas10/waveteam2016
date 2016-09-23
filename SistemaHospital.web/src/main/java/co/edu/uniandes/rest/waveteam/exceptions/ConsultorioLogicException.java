/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.exceptions;

/**
 *
 * @author r.garcia11
 */
public class ConsultorioLogicException extends Exception{
        /**
	 * Constructor vacío
	 */
	public ConsultorioLogicException() {
	}

	/**
	 * Constructor con mensaje
	 * @param msg
	 */
	public ConsultorioLogicException(String msg) {
		super(msg);
	}

	/**
	 * Constructor con causa
	 * @param causa
	 */
	public ConsultorioLogicException(Throwable causa) {
		super(causa);
	}

	/**
	 * Constructor con mensaje y causa.
	 * @param msg 
	 * @param causa
	 */
	public ConsultorioLogicException(String msg, Throwable causa) {
		super(msg, causa);
	}   
}
