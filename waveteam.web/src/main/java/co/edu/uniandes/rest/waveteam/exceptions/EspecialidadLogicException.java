/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.exceptions;

/**
 *
 * @author d.marino10
 */
public class EspecialidadLogicException extends Exception{
    
    /**
	 * Constructor por defecto
	 */
	public EspecialidadLogicException() {
	}

	/**
	 * Constructor con un mensaje
	 * @param message mensaje de la excepción
	 */
	public EspecialidadLogicException(String message) {
		super(message);
	}

	/**
	 * Constructor con una causa
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public EspecialidadLogicException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor con mensaje y causa.
	 * @param message mensaje de la excepción
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public EspecialidadLogicException(String message, Throwable cause) {
		super(message, cause);
	}   
}
