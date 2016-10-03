/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.exceptions;

/**
 *
 * @author je.ardila1501
 */
public class PatientLogicException extends Exception{
        
    /**
	 * versión usada en la serialización de la clase
	 */
	private static final long serialVersionUID = 2L;
    
        /**
	 * Constructor vacío
	 */
	public PatientLogicException() {
	}

	/**
	 * Constructor con un mensaje
	 * @param message mensaje de la excepción
	 */
	public PatientLogicException(String message) {
		super(message);
	}

	/**
	 * Constructor con una causa
	 * @param cause causa de la excepción
	 */
	public PatientLogicException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor con mensaje y causa.
	 * @param message mensaje de la excepción
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public PatientLogicException(String message, Throwable cause) {
		super(message, cause);
	}   
}
