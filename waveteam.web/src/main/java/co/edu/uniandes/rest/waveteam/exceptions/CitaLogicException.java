/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.exceptions;

/**
 *
 * @author jm.lizarazo10
 */
public class CitaLogicException extends Exception{
    
    
    private static final long serialVersionUID = 1L;
    
    
    public CitaLogicException(){
        
    }
    
    
    public CitaLogicException(String mensaje){
        super(mensaje);
    }
    
    
    public CitaLogicException(Throwable causa){
        super(causa);
    }
    
    
    public CitaLogicException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
    
}
