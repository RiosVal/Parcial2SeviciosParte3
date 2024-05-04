# Consultas del parcial  
## ¿Por qué se usa el argumento dentro de la relación "OneToMany" (fetch = FetchType.LAZY)?  
Se utiliza para indicar cómo se deben cargar los objetos asociados cuando se recupera el objeto principal de la base de datos. En este caso, indica que los objetos asociados deben cargarse de forma perezosa o diferida, esto significa que  los objetos asociados no se cargarán de inmediato cuando se recupere el objeto principal de la base de datos. En su lugar, se cargarán solo cuando se acceda explícitamente a ellos.
