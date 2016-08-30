/*
 * PatientDTO
 * Objeto de transferencia de datos de Patients.
 */
package co.edu.uniandes.rest.waveteam.dtos;

/**
 * Objeto de transferencia de datos de Ciudades.
 * @author je.ardila1501
 */
public class PatientDTO {

    private Long id;
    private String name;
    private String sexo;
    private int edad;
    private String tipoSangre;
    private String eps;

    /**
     * Constructor por defecto
     */
    public PatientDTO() {

    }

    /**
     * Constructor con parámetros.
     * @param id
     * @param name
     * @param sexo
     * @param edad
     * @param tipoSangre
     * @param eps 
     */
    public PatientDTO(Long id, String name,int edad, String sexo , String tipoSangre, String eps) {
        this.id = id;
        this.name = name;
        this.edad=edad;
        this.sexo=sexo;
        this.tipoSangre=tipoSangre;
        this.eps=eps;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return the sex
     */
    public String getSexo(){
        return sexo;
    }
    
    /**
     * 
     * @param sexo the sex to set
     */
     public void setSexo(String sexo){
        this.sexo=sexo;
    }
     
     /**
      * 
      * @return 
      */
     public int getEdad(){
         return edad;
     }
     
     /**
      * 
      * @param edad 
      */
     public void setEdad(int edad){
         this.edad=edad;
     }
     
     /**
      * 
      * @return 
      */
     public String getTipoSAngre(){
         return tipoSangre;
     }
     
     /**
      * 
      * @param tipoSAngre 
      */
     public void setTipoSAngre(String tipoSAngre){
         this.tipoSangre=tipoSAngre;
     }
     
     /**
      * 
      * @return 
      */
     public String getEps(){
         return eps;
     }
     
     /**
      * 
      * @param eps 
      */
     public void setEps(String eps){
         this.eps=eps;
     }
    
    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + ", edad : \"" + getEdad() + 
                ", sexo : \"" + getSexo() + ", tipoSangre : \""+ getTipoSAngre()+ 
                ", eps : \""+ getEps() + "\" }";
    }
}
