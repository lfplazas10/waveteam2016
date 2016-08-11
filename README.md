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

## Entidad Médico

La comunicación entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "name" : 'Carlos Valderrama'       /* Tipo String */
    "cédula" : 542382304,    		   /* Tipo Long */
    "especialidad" : 'Oftalmólogo'     /* Tipo String */
    "consultorio" : 3,  			   /* Tipo Long */
}
```

Si se solicta al servidor una lista de médcios, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato: 

 ```javascript
[ 
  	{
   	 "name" : 'Carlos Valderrama'		/* Tipo String */
   	 "cédula" : 542382304,			/* Tipo Long */
   	 "especialidad" : 'Oftalmólogo'		/* Tipo String */
   	 "consultorio" : 3,			/* Tipo Long */
	},
	{
   	 "name" : 'James Rodriguez'       	/* Tipo String */
   	 "cédula" : 548393222,			/* Tipo Long */
  	 "especialidad" : 'Cardiólogo'		/* Tipo String */
  	 "consultorio" : 23,			/* Tipo Long */
	}
]
```

### Servicios REST

La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/doctors|Lista los registros de Médico (READ)|||Colección de registros de Médico 
**GET**|/doctors/*:cedula*|Obtener los atributos de una instancia de Médico (READ)|**@PathParam cédula**: Número de cédula del doctor a consultar||Atributos de la instancia de Médico
**POST**|/doctors|Crear una nueva instancia de la entidad Médico (CREATE)||Atributos de la instancia de Médico a crear|Instancia de Médico creada, incluyendo su cédula
**PUT**|/doctors/*:cedula*|Actualiza una instancia de la entidad Médico (UPDATE)|**@PathParam cédula**: Identificador del registro|Objeto JSON de Médico|Instancia de Médico actualizada
**DELETE**|/doctors/*:cedula*|Borra instancia de Médico en el servidor (DELETE)|**@PathParam cédula**: Identificador del registro||



#Servicios Rest:

Citas:

|   Método   |   URL      |     Acción                                            |   Parámetros     |    Cuerpo    |    Retorno                               |
|:-----------|:-----------|:------------------------------------------------------|:-----------------|:-------------|:-----------------------------------------|
|    GET     | /citas     | Da la lista de citas                                  |                  |              |Colección de las citas en el calendario   |
|    GET     | /citas/:id | Da los parámetros de una cita en la lista             |ID: id de la cita |              |Médico asignado a la cita consultada      |
|    POST    | /Citas     | Crea una nueva cita segun la información suministrada |                  | Atributos    |Nueva cita creada                         |
|    END     | /Citas/:id | Da por terminada la cita por el medico y/o la fecha   |ID: id de la cita |              |Se termina la cita correctamente          |
|   DELETE   | /Citas/:id | Borra una cita según su ID                            |ID: id de la cita |              |Se borra la cita de la lista (cancela)    |




