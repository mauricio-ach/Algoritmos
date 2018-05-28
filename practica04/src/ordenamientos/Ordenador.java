package ordenamientos;

import java.util.ArrayList;
import java.util.List;

public class Ordenador {

	public void countingSort(Integer arr[]) {
		int tam = arr.length;

		if(tam == 0){
			System.out.println("Arreglo vacío nada por hacer!");
			return;
		}

		Integer ordenado[] = new Integer[tam];
		Integer cuenta[] = new Integer[256];

		//Iniciamos cuentas en 0
		for(int i = 0; i < 256; i++)
			cuenta[i] = 0;
		//Contamos los numeros
		for(int i = 0; i < tam; i++)
			cuenta[arr[i]]++;
		//Ordenamos posiciones
		for(int i = 1; i < 255; i++)
			cuenta[i] += cuenta[i - 1];
		//Construimos array
		for(int i = 0; i < tam; i++) {
			ordenado[cuenta[arr[i]] - 1] = arr[i];
			cuenta[arr[i]]--;
		}
		//Ordenamos original
		for(int i = 0; i < tam; i++)
			arr[i] = ordenado[i];
	}

	private void insertionSort(Integer arr[]) {
		int tam = arr.length;

		for(int i = 1; i < tam; i++) {
			int elegido = arr[i];
			int j = i - 1;

			//Ordenamos
			while(j >= 0 && arr[j] > elegido) {
				arr[j + 1] = arr[j];
				j -= 1;
			}
			arr[j + 1] = elegido;
		}
	}

	public void bucketSort(Integer arr[], int numBuckets) {
		int tam = arr.length;

		if(tam == 0) {
			System.out.println("Arreglo vacío nada por hacer!");
			return;	
		}

		//Buscamos maximo y minimo
		Integer minimo = arr[0];
		Integer maximo = arr[0];
		for(int i = 1; i < tam; i++) {
			if(arr[i] < minimo){
				minimo = arr[i];
			} else if(arr[i] > maximo) {
				maximo = arr[i];
			}
		}

		//Iniciamos buckets
		int cuenta = (maximo - minimo) / numBuckets + 1;
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(cuenta);
		for(int i = 0; i < cuenta; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		//Partimos entre los buckets
		for(int i = 0; i < tam; i++) {
			buckets.get((arr[i] - minimo) / numBuckets).add(arr[i]);
		}

		//Ordenamos y modificamos
		int indice = 0;
		for(int i = 0; i < buckets.size(); i++) {
			Integer bucketArr[] = new Integer[buckets.get(i).size()];
			bucketArr = buckets.get(i).toArray(bucketArr);
			insertionSort(bucketArr);
			for(int j = 0; j < bucketArr.length; j++) {
				arr[indice++] = bucketArr[j];
			}
		}
	}

	public void radixSort(Integer[] arr) {
		int radix = 10;
		List<Integer>[] bucket = new ArrayList[radix];
		for(int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		//Ordenamos
		boolean max = false;
		int aux = -1;
		int posicion = 1;

		while(!max) {
			max = true;
			for(Integer i : arr) {
				aux = i / posicion;
				bucket[aux % radix].add(i);
				if(max && aux > 0)
					max = false;
			}

			int i = 0;
			for(int j = 0; j < radix; j++) {
				for(Integer num : bucket[j]) {
					arr[i++] = num;
				}
				bucket[j].clear();
			}
			posicion *= radix;
		}
	}

	public void imprime(Integer[] arr) {
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}