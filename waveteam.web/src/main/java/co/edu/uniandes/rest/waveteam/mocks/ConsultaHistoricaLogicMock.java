/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mocks;

import co.edu.uniandes.rest.waveteam.dtos.CitaDTO;
import co.edu.uniandes.rest.waveteam.dtos.ConsultaHistoricaDTO;
import co.edu.uniandes.rest.waveteam.dtos.EspecialidadDTO;
import co.edu.uniandes.rest.waveteam.exceptions.ConsultaHistoricaLogicException;
import co.edu.uniandes.rest.waveteam.exceptions.EspecialidadLogicException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author d.marino10
 */
public class ConsultaHistoricaLogicMock {
    
     // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EspecialidadLogicMock.class.getName());
    private static ArrayList<ConsultaHistoricaDTO> consultasHistoricas;
    
    public ConsultaHistoricaLogicMock()
    {
        if (consultasHistoricas == null) {
            
            
            EspecialidadLogicMock especialidades= new EspecialidadLogicMock();
            consultasHistoricas = new ArrayList<ConsultaHistoricaDTO>();
                
            try {
                for(int i=0;i<especialidades.getEspecialidades().size();i++)
                {
                   createConsultaHistorica(especialidades.getEspecialidades().get(i).getNombre()); 
                }
            } catch (Exception ex) {
                Logger.getLogger(ConsultaHistoricaLogicMock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información 
        logger.info("Inicializa la lista de consultasHistoricas");
        logger.info("consultasHistoricas: " + consultasHistoricas);
    }
    
    /**
     * Obtiene el listado de especialidades.
     *
     * @return lista de especialidades
     * @throws EspecialidadLogicException cuando no existe la lista en memoria
     */
    public List<ConsultaHistoricaDTO> getConsultasHisotircas() throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }
        logger.info("Retornando todas las consultasHistoricas");
        return consultasHistoricas;
    }

    public ConsultaHistoricaDTO getConsultaHistorica(String nombreEspecialidad) throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }

        for (ConsultaHistoricaDTO consultaHistorica : consultasHistoricas) {
            if (Objects.equals(nombreEspecialidad, consultaHistorica.getEspecialidad().getNombre())) {
                logger.info("Retornando la consultaHistorica de la especialidad" + nombreEspecialidad);
                return consultaHistorica;
            }
        }
        logger.info("No se encontro consultaHistorica de esa especialidad");
        throw new ConsultaHistoricaLogicException("No existe consultaHistorica con esa especialidad");
    }

    public ConsultaHistoricaDTO updateConsultaHistorica(String nombreEspecialidad) throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }
        
        ConsultaHistoricaDTO updated=null;
        boolean found = false;
        if (nombreEspecialidad != null) {
            
            EspecialidadDTO esp=null;
            try {
                EspecialidadLogicMock especialidades = new EspecialidadLogicMock();
                for(EspecialidadDTO especialidad: especialidades.getEspecialidades())
                {
                    if(Objects.equals(nombreEspecialidad, especialidad.getNombre()))
                    {
                        esp=especialidad;
                        break;
                    }
                }
            } catch (EspecialidadLogicException ex) {
                logger.severe("Error interno: problemas con el mock de especialidades");
                throw new ConsultaHistoricaLogicException("Error interno: problemas con el mock de especialidades");
            }
            if(esp!=null)
            {
                for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
                if (Objects.equals(esp.getNombre(), consulta.getEspecialidad().getNombre())) {
                    logger.info("Actualizando informacion de la consultaHistorica con");
                    consulta.setEspecialidad(esp);
                    consulta.setNumeroDoctores(esp.getDoctores().size());
                    consulta.setNumeroCitas(esp.getCitas().size());
                    
                    int promedio=0;
                    int canceladas=0;
                    int libres=0;
                    int terminadas=0;
                    for (Iterator<CitaDTO> it = esp.getCitas().iterator(); it.hasNext();) {
                        CitaDTO c = it.next();
                        promedio+=c.getDuracion();
                        
                        if(c.getPaciente()==0)
                        {
                            libres++;
                        }
                        if(c.getHabilitada().equals("Cancelada"))
                        {
                            canceladas++;
                        }
                        if(c.getHabilitada().equals("Termino"))
                        {
                            terminadas++;
                        }
                    }
                    if(esp.getCitas().size()!=0)
                    {
                        promedio=(int)(promedio/esp.getCitas().size());
                    }
                    consulta.setPromedioDuracion(promedio);
                    consulta.setCitasLibres(libres);
                    consulta.setCitasCanceladas(canceladas);
                    consulta.setCitasCanceladas(terminadas);
                    
                    updated=consulta;
                    
                    found = true;
                    break;
                }
            }
            if (!found) {
                logger.severe("No se encontro una consultaHistorica con esa especialidad");
                throw new ConsultaHistoricaLogicException("No existe una consultaHistorica con esea especialidad");
            }

        } else {
            logger.severe("El nombre de la");
            throw new ConsultaHistoricaLogicException("El id es nulo");

        }
            }
            
        logger.info("Retornando la consultaHistorica actualizada");
        return updated;
    }

    /**
     * Agrega una especialidad a la lista.
     *
     * @param newEsp consultaHistorica a adicionar
     * @throws EspecialidadLogicException cuando ya existe una especialidad con el id
     * suministrado
     * @return Especialidad agregada
     */
    public ConsultaHistoricaDTO createConsultaHistorica(String nombreEsp) throws ConsultaHistoricaLogicException {
        logger.info("Recibiendo solicitud de agregar consultaHistorica de especialidad " + nombreEsp);

        if (nombreEsp != null) {
            for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
                if (Objects.equals(consulta.getEspecialidad().getNombre(), nombreEsp)) {
                    logger.severe("Ya existe una consultaHistorica para esa especialidad, se borra la consulta historica anterior");
                }
            }

        } else {
            logger.severe("La especialidad suministrada es nula");
            throw new ConsultaHistoricaLogicException("no se puede crear una consutaHistorica sin una especialidad");
        }

        ConsultaHistoricaDTO nueva=new ConsultaHistoricaDTO();
        EspecialidadDTO esp=null;
            try {
                EspecialidadLogicMock especialidades = new EspecialidadLogicMock();
                for(EspecialidadDTO especialidad: especialidades.getEspecialidades())
                {
                    if(Objects.equals(nombreEsp, especialidad.getNombre()))
                    {
                        esp=especialidad;
                        break;
                    }
                }
            } catch (EspecialidadLogicException ex) {
                logger.severe("Error interno: problemas con el mock de especialidades");
                throw new ConsultaHistoricaLogicException("Error interno: problemas con el mock de especialidades");
            }
        if(esp!=null)
        {
          nueva.setEspecialidad(esp);
          nueva.setNumeroDoctores(esp.getDoctores().size());
          nueva.setNumeroCitas(esp.getCitas().size());
        
          int promedio=0;
          int canceladas=0;
          int libres=0;
          int terminadas=0;
          for (Iterator<CitaDTO> it = esp.getCitas().iterator(); it.hasNext();) {
            CitaDTO c = it.next();
            promedio+=c.getDuracion();
                        
            if(c.getPaciente()==0)
            {
                libres++;
            }
            if(c.getHabilitada().equals("Disponible"))
            {
                canceladas++;
            }
            if(c.getHabilitada().equals("Termino"))
            {
                terminadas++;
            }            
          }
          if(!esp.getCitas().isEmpty())
          {
             promedio=(int)(promedio/esp.getCitas().size());
          }
          nueva.setPromedioDuracion(promedio);
          nueva.setCitasLibres(libres);
          nueva.setCitasCanceladas(canceladas);
          nueva.setCitasCanceladas(terminadas);
          DateFormat d= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          String fecha=d.format(new Date());
          nueva.setFecha(fecha);
          
        }
        logger.info("Agregando consultaHistorica " + nueva.getEspecialidad().getNombre());
        consultasHistoricas.add(nueva);
        return nueva;
    }
    
    public void deleteConsultaHistorica(String nombreEsp) throws ConsultaHistoricaLogicException{
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }
        for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
            if (Objects.equals(nombreEsp, consulta.getEspecialidad().getNombre())) {
                logger.info("Borrando la consultaHistorica de la especialidad "+nombreEsp);
                consultasHistoricas.remove(consulta);
                return;
            }
        }
        logger.info("No se encontro una  consultaHistorica para esa especialidad");
        throw new ConsultaHistoricaLogicException("No existe una  consultaHistorica para esa especialidad");
    }
    
        public List<ConsultaHistoricaDTO> generarTodas() throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }
        consultasHistoricas=new ArrayList();
        try {
            EspecialidadLogicMock especialidades = new EspecialidadLogicMock();
            for(EspecialidadDTO esp : especialidades.getEspecialidades())
            {
                createConsultaHistorica(esp.getNombre());
            }
        } catch (EspecialidadLogicException ex) {
            logger.severe("Error interno: " + ex.getMessage());
            throw new ConsultaHistoricaLogicException("Error interno: " + ex.getMessage());
        }
        logger.info("Retornando todas las consultasHistoricas");
        return consultasHistoricas;
    }
}
