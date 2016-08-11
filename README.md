# WaveTeam

#Modelo conceptual

Este modelo conceptual está sujeto a cambios.

![](http://i.imgur.com/Maso0qj.jpg)


#Lista de integrantes y las clases a desarrollar:

|Nombre            |Correo Uniandes              |Clase a desarrollar   |
|:-----------------|:----------------------------|:------------|
|Luis Felipe Plazas|lf.plazas10@uniandes.edu.co  |Médico        |
|John Ardila       |je.ardila1501@uniandes.edu.co|Paciente      |
|Rogelio García    |r.garcia11@uniandes.edu.co   |Desarrollador |
|Daniela Mariño    |d.marino10@uniandes.edu.co   |Especialista  |
|Juan Lizarazo     |jm.lizarazo10@uniandes.edu.co|Cita          |


#Documentación del API:




#Servicios Rest:

Citas:

|   Método   |   URL      |     Acción                                            |   Parámetros     |    Cuerpo    |    Retorno                               |
|:-----------|:-----------|:------------------------------------------------------|:-----------------|:-------------|:-----------------------------------------|
|    GET     | /citas     | Da la lista de citas                                  |                  |              |Colección de las citas en el calendario   |
|    GET     | /citas/:id | Da los parámetros de una cita en la lista             |ID: id de la cita |              |Médico asignado a la cita consultada      |
|    POST    | /Citas     | Crea una nueva cita segun la información suministrada |                  | Atributos    |Nueva cita creada                         |
|    END     | /Citas/:id | Da por terminada la cita por el medico y/o la fecha   |ID: id de la cita |              |Se termina la cita correctamente          |
|   DELETE   | /Citas/:id | Borra una cita según su ID                            |ID: id de la cita |              |Se borra la cita de la lista (cancela)    |




