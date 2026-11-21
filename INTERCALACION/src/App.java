import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        // Generar un vector de 2000
        aleatorioArray g = new aleatorioArray();
        int[] desordenado = g.generarVector(2000);
    
// Ordenamiento por intercalacion

        saludoAlumno saludo1 = new saludoAlumno("Hola, este es el programa de --------Ordenamiento por INTERCALACION--------");
        System.out.println(saludo1.getSaludo());

        ordenamientoIntercalacion OI = new ordenamientoIntercalacion();

        //CLONAMOS EL VECTOR ORIGINAL
        int[] datosOI = desordenado.clone();

        System.out.println("Los valores del arreglo son" + Arrays.toString(datosOI));



        

        long inicioOI = System.nanoTime();

        OI.ordenar(datosOI);
        System.out.println(Arrays.toString(datosOI));

        long finalOI = System.nanoTime();

        long totalOI = finalOI - inicioOI;


        System.out.println("El resultado en tiempo fue de " + totalOI + " ns");
        System.out.println("Recorridos: " + OI.getRecorridos());
        System.out.println("Comparaciones: " + OI.getComparaciones());
        System.out.println("Intercambios: " + OI.getIntercambios());

////MEZCLA DIRECTA
        saludoAlumno saludo2 = new saludoAlumno("Hola, este es el programa de  ---------Ordenamiento Mezcla Directa--------");
        System.out.println(saludo2.getSaludo());



        File archivoEntrada = new File("entrada2.txt");
        int cantidadNumeros = contarNumeros(archivoEntrada);

        //Tiempo antes de comenzar



        if (cantidadNumeros > 0) {
            mezclaDirecta mezclaDirecta = new mezclaDirecta();
            System.out.println("Cantidad de números: " + cantidadNumeros);
            System.out.println("Ordenando el archivo...");
            long tiempoInicio = System.nanoTime();

            mezclaDirecta.ordenamiento(archivoEntrada, cantidadNumeros);
            long tiempoFinal = System.nanoTime();

            long tiempoTotal = tiempoFinal - tiempoInicio;
            System.out.println("Numeros Ordenados");
            mostrarArchivos(archivoEntrada);

            System.out.println("Tiempo en nanosegundos: " + tiempoTotal);
        } else {
            System.out.println("El archivo no contiene números");
        }



///MEZCLA DIRECTA HECHA EN CLASE POR EDUARDO

        System.out.println(saludo2.getSaludo());

        int[] datosMD = desordenado.clone();//MD de Mezcla Directa
        System.out.println("Los Valores a ordenar del arreglo son" + Arrays.toString(datosMD) );

        MezclaDirectaEduard MD = new MezclaDirectaEduard();

        long inicioMD = System.nanoTime();

        MD.ordenar(datosMD);

        System.out.println(Arrays.toString(datosMD));
        long finalMD = System.nanoTime();

        long totalMD = finalMD - inicioMD;

        System.out.println("El resultado en tiempo fue de " + totalMD + " ns");
        System.out.println("Recorridos: " + MD.getRecorridos());
        System.out.println("Comparaciones: " + MD.getComparaciones());
        System.out.println("Intercambios: " + MD.getIntercambios());

        



////MEZCLA NATURAAAAL
        saludoAlumno saludo3 = new saludoAlumno("Hola, este es el programa de --------Ordenamiento Mezcla Natural--------");
        System.out.println(saludo3.getSaludo());

        
        int[] datos1 = desordenado.clone();

        System.out.println("Los valores del arreglo son" + Arrays.toString(datos1));



        MezclaNatural MN = new MezclaNatural();

        long inicio1 = System.nanoTime();

        MN.ordenar(datos1);
        System.out.println(Arrays.toString(datos1));

        long final1 = System.nanoTime();

        long total1 = final1 - inicio1;


        System.out.println("El resultado en tiempo fue de " + total1 + " ns");
        System.out.println("Recorridos: " + MN.getRecorridos());
        System.out.println("Comparaciones: " + MN.getComparaciones());
        System.out.println("Intercambios: " + MN.getIntercambios());
        

        

        


















    }

    public static int contarNumeros(File archivo) {
        int cantidad = 0;

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNext()) {
                if (lector.hasNextInt()) {
                    lector.nextInt();
                    cantidad++;
                } else {
                    lector.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + archivo.getName());
        }

        return cantidad;
    }

    public static void mostrarArchivos(File archivo) {
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + archivo.getName());
        }
    }
}























