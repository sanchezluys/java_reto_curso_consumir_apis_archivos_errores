# ![aluraoracle.jpg](assets/aluraoracle.jpg)

# ALURA LATAM

## JAVA USO DE APIS, ARCHIVOS Y CONTROL DE ERRORES

### Profesor: Bruno Darío Fernández Ellerbach

Avances


| Tema                   | Descripción                                                                     | Bugs/Observación                                                                                                                                       |
| ---------------------- |---------------------------------------------------------------------------------| ------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 🚀️ APIs              | Alfa, inicializando todo                                                        | n/a                                                                                                                                                     |
|                        | Se observa error en las comillas del archivo original del curso                 |                                                                                                                                                         |
|                        | Se agrega la variable de entorno apk_key para que pueda funcionar sin mostrarla |                                                                                                                                                         |
|                        | Activando Gson                                                                  | Ojo Gson solo devuelve datos tipo StringSe observa error cuando se busca "dexter" ya que tiene el año de inicio y fin, no un año unico, sino un rango |
|                        | Se ingresa el constructor toString() para la clase Titulo                       | Record es un tipo de clase especifica para manejar datos                                                                                                |
|                        | Se usa DTO con Record, data transfer object, clase intermediaria                |                                                                                                                                                         |
|                        | Se agrega el constructor para la clase Titulo, en el parseo                     |                                                                                                                                                         |
|                        | Se agregan los 3 datos en el toString() de Titulo                               | Se genera un error cuando tiempo duracion en minutos recibe "60 min"                                                                                    |
|                        | Se corrige el error con .substring(0,2)                                         | Muestra 60 sin problemas                                                                                                                                |
| 👀️ Manejo de Errores | Se inicia codigo manejo de errores                                              | Se genera un error con el tiempo "N/A"                                                                                                                  |
|                        | Se usa la pelicula bichos, que genera el erro                                   |                                                                                                                                                         |
|                        | se activa el try-catch                                                          | Funciona bien con la pelicula bichos, indicando el error pero el programa continua                                                                      |
|                        | Al buscar pelicula "top gun" da error                                           | IllegalArgumentException                                                                                                                                |
|                        | - Se hace el try mas generico                                                   |                                                                                                                                                         |
|                        | - Se agrega otro catch con el nuevo error: IllegalArgumentException             |                                                                                                                                                         |
|                        | - Se agrega un catch generico: Exception que es la madre de la clase exception  |                                                                                                                                                         |
|                        | Creando nuestras propias excepciones                                            |                                                                                                                                                         |
|                        | Se corrige error con busqueda.replace() para pelicula "top gun"                   |                                                                                                                                                         |
|                        | - libreria URLEncoder                                                           |                                                                                                                                                         |
|                        |                                                                                 |                                                                                                                                                         |
|                        |                                                                                 |                                                                                                                                                         |
