# JavaSpringUBP
Poryecto Java con Spring / Java project with Spring

# DEFINICION GENERAL
Este proyecto consiste en una aplicación que consume la **API de Spotify**, que permite al usuario crear “listas motivacionales”. La misma habilita al usuario a buscar la canción que quiera, ya sea por su nombre o por el artista de la canción, para luego poder guardarla y referenciarla a alguna de sus “listas motivacionales”.  
Una “lista motivacional” permite referenciar 5 canciones, lo que equivaldría un tiempo promedio de 13-15 minutos por lista, tiempo recomendado de break que una persona puede tomarse durante el día, entre actividades. A su vez un usuario puede almacenar un total de 15 canciones, lo cual se administra entre 3 listas. Y también el oyente puede eliminar alguna canción, o puede actualizar la lista a la cual hace referencia.

# ESPECIFICACIÓN DE REQUERIMIENTOS
Para poder ejecutar locamente el proyecto, es necesario: 
* JDK 11 o superior.
* Maven
* MySQL

En caso de que el ultimo sea otro gestor de base de datos, realizar la configuración necesaria en el **application.properties** del proyecto.
* Cuenta de Spotify

Para acceder a la API de Spotify, es necesario un USER y SECRET, los cuales a su vez se utilizan para obtener el TOKEN de acceso a las peticiones.

# Documentación de Endpoints

Detalle de los endpoints, con su descripción y ejemplos de uso.

| Spotify |                                          |
|:-------:|----------------------------------------- |
|    1    | Obtener TOKEN de Spotify                 |
|    2    | Obtener una canción de Spotify           |
|    3    | Obtener canciones por artista de Spotify |
|         |                                          |

| Track   |                                             |
|:-------:|---------------------------------------------|
|   4     | Guardar una canción                         |
|   5     | Obtener una canción                         |
|   6     | Actualizar la lista viculada de una canción |
|   7     | Eliminar una canción                        |
|   8     | Obtener las canciones que compartan lista   |
|         |                                             |


### Descripción:

## 1. Obtener TOKEN de Spotify

**ENDPOINT**: accounts.spotify.com/api/token

Descripción: Obtiene el TOKEN de accesos a las peticiones en Spotify

Método: **POST**

Body:
* grant_type: client_credentials
* redirect_uri: http://localhost:8080
* client_id: {CLIENT_ID_SPOTIFY}
* client_secret: {CLIENT_SECRET_SPOTIFY}

## 2. Obtener una canción de Spotify

**ENDPOINT**: localhost:8080/apiV1/spotify/{track}

Descripción: Obtiene datos de una canción en particular de Spotify


Método: **GET**

Ejemplo: localhost:8080/apiV1/spotify/Nada Personal

## 3. Obtener canciones por artista de Spotify

**ENDPOINT**: localhost:8080/apiV1/spotify?artist

Descripción: Obtiene canciones con sus respectivos datos de acuerdo a un artista en particular, de Spotify (devuelve un máximo de 20 canciones).

Método: **GET**

Ejemplo: localhost:8080/apiV1/spotify?artist=La Renga

## 4. Guardar una canción

**ENDPOINT**: localhost:8080/apiV1/tracks

Descripción: Permite guardar una canción al usuario

Método: **POST**

Body:
`{
    "spotifyId": "0cslUTJ5eB4hUNs0fKyh59",
    "name": "Nada Personal",
    "durationMs": 292200,
    "playlistName": "Rock del bueno",
    "artist": "Soda Stereo"
}`

## 5. Obtener una canción

**ENDPOINT**: localhost:8080/apiV1/tracks/{name}

Descripción: Obtiene datos de una canción del usuario

Método: **GET**

Ejemplo: localhost:8080/apiV1/tracks/11 y 6

## 6. Actualizar la lista viculada de una canción

**ENDPOINT**: localhost:8080/apiV1/tracks/{id}

Descripción: Actualiza la lista a la que hace referencia la canción, cuyo id se pasa como parámetro al endpoint

Método: **PUT**

Body:
`{
    "playlistName": "Rock pesado"
}`

Respuesta:
`{
    "spotifyId": "0cslUTJ5eB4hUNs0fKyh59",
    "name": "Nada Personal",
    "durationMs": 292200,
    "playlistName": "Rock pesado",
    "artist": "Soda Stereo"
}`

Ejemplo: localhost:8080/apiV1/spotify/1

## 7. Eliminar una canción

**ENDPOINT**: localhost:8080/apiV1/tracks/{id}

Descripción: Elimina la canción, cuyo id se pasa como parámetro al endpoint

Método: **DELETE**

Respuesta: Mensaje que se borro exitosamente.

## 8. Obtener las canciones que compartan lista

**ENDPOINT**: localhost:8080/apiV1/tracks/playlist?name=

Descripción: Obtiene la lista de canciones que comparten lista

Método: **GET**

Ejemplo: localhost:8080/apiV1/tracks/playlist?name=Rock del bueno
