Programa para ejecutar ordenamiento radix sort, counting sort y bucket sort

Para compilar use el comando ant:
$ ant

Esto generará un archivo llamado busquedas.jar

Para ejecutar utilice el comando:
$ java -jar ordenamientos.jar {nombre de archivo} {tipo de ordenamiento} {numero}

Donde:
{nombre de archivo} es el archivo donde se encuentra la lista de elementos
{tipo de ordenamiento} el tipo de ordenamiento a utilizar
radix
bucket
counting
{numero} sólo si se elige bucket se deberá indicar el número de buckets a utilizar, no pueden ser un número
negativo y tampoco igual a 0

***************************************************
Por defecto radix ordena en lsd
***************************************************

Para generar la documentacion use:
$ ant doc

Para remover todo los generados use:
$ ant clean

Araujo Chávez Mauricio 312210047