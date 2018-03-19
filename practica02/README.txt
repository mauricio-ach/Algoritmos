Programa para ejecutar busqueda binaria, secuencial, exponencial y 
por interpolación..

Para compilar use el comando ant:
$ ant

Esto generará un archivo llamado busquedas.jar

Para ejecutar utilice el comando:
$ java -jar correlacion.jar {nombre de archivo} {elemento} {tipo de busqueda}

Donde:
{nombre de archivo} es el archivo donde se encuentra la lista de elementos
{elemento} el elemento que se quiere encontrar
{tipo de busqueda} el tipo de busqueda el cual se identifica con una letra mayuscula:
S -> Secuencial
B -> Binaria
E -> Exponencial
I -> Por Interpolacion

Para generar la documentacion use:
$ ant doc

Para remover todo los generados use:
$ ant clean

Araujo Chávez Mauricio 312210047