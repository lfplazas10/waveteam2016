package co.edu.uniandes.rest.waveteam.mocks;

/**
 * Mock del recurso Ciudades (Mock del servicio REST)
 *
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.uniandes.rest.waveteam.dtos.MedicoDTO;
import co.edu.uniandes.rest.waveteam.exceptions.MedicoLogicException;

/*
 * CityLogicMock
 * Mock del recurso Ciudades (Mock del servicio REST)
 */
public class MedicoLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MedicoLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<MedicoDTO> cities;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MedicoLogicMock() {

        if (cities == null) {
            cities = new ArrayList<>();
            cities.add(new MedicoDTO(1L, "Bogota"));
            cities.add(new MedicoDTO(2L, "Cali"));
            cities.add(new MedicoDTO(3L, "Medellin"));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información 
        logger.info("Inicializa la lista de ciudades");
        logger.info("ciudades" + cities);
    }

    /**
     * Obtiene el listado de personas.
     *
     * @return lista de ciudades
     * @throws MedicoLogicException cuando no existe la lista en memoria
     */
    public List<MedicoDTO> getCities() throws MedicoLogicException {
        if (cities == null) {
            logger.severe("Error interno: lista de ciudades no existe.");
            throw new MedicoLogicException("Error interno: lista de ciudades no existe.");
        }

        logger.info("retornando todas las ciudades");
        return cities;
    }

    /**
     * Agrega una ciudad a la lista.
     *
     * @param newCity ciudad a adicionar
     * @throws MedicoLogicException cuando ya existe una ciudad con el id
     * suministrado
     * @return ciudad agregada
     */
    public MedicoDTO createCity(MedicoDTO newCity) throws MedicoLogicException {
        logger.info("recibiendo solicitud de agregar ciudad " + newCity);

        // la nueva ciudad tiene id ?
        if (newCity.getId() != null) {
            // busca la ciudad con el id suministrado
            for (MedicoDTO city : cities) {
                // si existe una ciudad con ese id
                if (Objects.equals(city.getId(), newCity.getId())) {
                    logger.severe("Ya existe una ciudad con ese id");
                    throw new MedicoLogicException("Ya existe una ciudad con ese id");
                }
            }

            // la nueva ciudad no tiene id ? 
        } else {

            // genera un id para la ciudad
            logger.info("Generando id paa la nueva ciudad");
            long newId = 1;
            for (MedicoDTO city : cities) {
                if (newId <= city.getId()) {
                    newId = city.getId() + 1;
                }
            }
            newCity.setId(newId);
        }

        // agrega la ciudad
        logger.info("agregando ciudad " + newCity);
        cities.add(newCity);
        return newCity;
    }
}
