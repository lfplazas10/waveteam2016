/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;

/**
 *
 * @author r.garcia11
 */
public class ConsultorioDTO {
    
    private Long id;
    private String horario;
    private boolean atencionUrgencias;
    private boolean unidadCuidadosIntensivos;
    
    /**
     * Constructor vacío
     */
    public ConsultorioDTO()
    {        
    }
    
    /**
     * Constructor con parámetros
     */
    public ConsultorioDTO(Long id, String horario, boolean atencionUrgencias, boolean unidadCuidadosIntensivos)
    {
        this.id = id;
        this.horario = horario;
        this.atencionUrgencias = atencionUrgencias;
        this.unidadCuidadosIntensivos = unidadCuidadosIntensivos;
    }
    
    /**
     * Devuelve el id del consultorio
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Cambia el id por el id por parámetro
     * 
     * @param id 
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * Devuelve el horario
     */
    public String getHorario()
    {
        return horario;   
    }
    
    /**
     * Cambia el horario
     * @param horario 
     */
    public void setHorario(String horario)
    {
        this.horario = horario;
    }
    
    /**
     * Devuelve si atiende urgencias
     * @return 
     */
    public boolean getAtencionUrgencias()
    {
        return atencionUrgencias;
    }
    
    /**
     * Cambia el estado de atención a urgencias
     * 
     * @param atencionUrgencias 
     */
    public void setAtencionUrgencias(boolean atencionUrgencias)
    {
        this.atencionUrgencias = atencionUrgencias;
    }
    
    /**
     * Devuelve si tiene unidad de cuidados intensivos
     */
    public boolean getUnidadCuidadosIntensivos()
    {
        return unidadCuidadosIntensivos;
    }
    
    /**
     * Cambia si tiene UCI
     * @param unidadCuidadosIntensivos 
     */
    public void setUnidadCuidadosIntensivos(boolean unidadCuidadosIntensivos)
    {
        this.unidadCuidadosIntensivos = unidadCuidadosIntensivos;
    }
    
    /**
     * Devuelve un String con los parámetros del objeto
     */
    public String toString()
    {
        return "Id: " + id + 
                ", horario: " + horario + 
                ", atiende urgencias: " + (atencionUrgencias?"Si":"No") + 
                ", UCI: " + (unidadCuidadosIntensivos?"Si":"No");
    }
}
