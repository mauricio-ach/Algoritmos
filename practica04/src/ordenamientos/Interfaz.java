package ordenamientos;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Interfaz{

	public static void main(String[] args) {
		
		//Obtenemos datos necesarios
		String archivo = args[0];
		String opcion = args[1];
		Ordenador ordenador = new Ordenador();

		//Para leer
		FileReader fr = null;
		BufferedReader br = null;

		try {

			//Tratamos de leer archivo
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			//imprimimos arreglo
			System.out.println("Arreglo donde se ordenará por {" + opcion + "} :");
			String tmp, aux = "";
			
			while((tmp = br.readLine()) != null){
				System.out.println(tmp);
				aux = aux + tmp; 
			}
			String[] datosString = aux.split(" ");

			//Convertimos string a int
			Integer[] datos = new Integer[datosString.length];
			for(int i = 0; i < datosString.length; i++)
				datos[i] = Integer.parseInt(datosString[i]);

			//Manejamos la opcion elegida
			//Busqueda Secuencial
			if(opcion.compareTo("counting") == 0){
				ordenador.countingSort(datos);
				ordenador.imprime(datos);
			} else if(opcion.compareTo("radix") == 0) {
				ordenador.radixSort(datos);
				ordenador.imprime(datos);
			} else if(opcion.compareTo("bucket") == 0){
				int buckets = Integer.parseInt(args[2]);
				if(buckets < 0 || buckets == 0){
					System.out.println("Por favor ingresa un numero valido de buckets a utilizar!");
					return;
				}
				ordenador.bucketSort(datos,buckets);
				ordenador.imprime(datos);
			} else{
				System.out.println("Opción incorrecta por favor verifica");
				return;
			}

		} catch(IOException e) {

			System.out.println("El archivo no existe por favor verifica que el archivo exista y se encuentre en el mismo directorio de trabajo...");

		} finally {
			try{
				
				if(fr != null)
					fr.close();
				if(br != null)
					br.close();

			} catch(IOException e){

				e.printStackTrace();

			}
		}
	}
}