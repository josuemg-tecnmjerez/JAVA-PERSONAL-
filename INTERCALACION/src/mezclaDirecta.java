import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class mezclaDirecta {

    public void ordenamiento(File f, int N) {

        File F1 = new File("F1.txt");
        File F2 = new File("F2.txt");

        int PART = 1;

        while (PART < N) {

            // Divide el archivo original entre F1 y F2
            particiona(f, F1, F2, PART);

            // Mezcla los archivos F1 y F2 en el archivo original
            mezcla(f, F1, F2, PART);

            // Duplica el tamaño de las particiones
            PART = PART * 2;
        }

        System.out.println("Archivo ordenado correctamente.");
    }

    private void particiona(File f, File f1, File f2, int PART) {

        try (
            Scanner F = new Scanner(f);
            PrintStream F1 = new PrintStream(f1);
            PrintStream F2 = new PrintStream(f2)
        ) {

            while (F.hasNextInt()) {

                int k = 0;

                // Guarda PART números en F1
                while (k < PART && F.hasNextInt()) {
                    F1.println(F.nextInt());
                    k++;
                }

                k = 0;

                // Guarda PART números en F2
                while (k < PART && F.hasNextInt()) {
                    F2.println(F.nextInt());
                    k++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al particionar el archivo:");
            System.out.println(e.getMessage());
        }
    }

    private void mezcla(File f, File f1, File f2, int PART) {

        try (
            Scanner F1 = new Scanner(f1);
            Scanner F2 = new Scanner(f2);
            PrintStream F = new PrintStream(f)
        ) {

            int numeroF1 = 0;
            int numeroF2 = 0;

            boolean hayNumeroF1 = false;
            boolean hayNumeroF2 = false;

            while (F1.hasNextInt() || F2.hasNextInt()
                    || hayNumeroF1 || hayNumeroF2) {

                int k1 = 0;
                int k2 = 0;

                /*
                 * Se cargan los primeros números de cada bloque.
                 */

                if (!hayNumeroF1 && k1 < PART && F1.hasNextInt()) {
                    numeroF1 = F1.nextInt();
                    hayNumeroF1 = true;
                }

                if (!hayNumeroF2 && k2 < PART && F2.hasNextInt()) {
                    numeroF2 = F2.nextInt();
                    hayNumeroF2 = true;
                }

                /*
                 * Mezcla un bloque de F1 con un bloque de F2.
                 */
                while ((k1 < PART && hayNumeroF1)
                        || (k2 < PART && hayNumeroF2)) {

                    if (k1 < PART && hayNumeroF1
                            && k2 < PART && hayNumeroF2) {

                        if (numeroF1 <= numeroF2) {

                            F.println(numeroF1);
                            k1++;
                            hayNumeroF1 = false;

                            if (k1 < PART && F1.hasNextInt()) {
                                numeroF1 = F1.nextInt();
                                hayNumeroF1 = true;
                            }

                        } else {

                            F.println(numeroF2);
                            k2++;
                            hayNumeroF2 = false;

                            if (k2 < PART && F2.hasNextInt()) {
                                numeroF2 = F2.nextInt();
                                hayNumeroF2 = true;
                            }
                        }

                    } else if (k1 < PART && hayNumeroF1) {

                        F.println(numeroF1);
                        k1++;
                        hayNumeroF1 = false;

                        if (k1 < PART && F1.hasNextInt()) {
                            numeroF1 = F1.nextInt();
                            hayNumeroF1 = true;
                        }

                    } else if (k2 < PART && hayNumeroF2) {

                        F.println(numeroF2);
                        k2++;
                        hayNumeroF2 = false;

                        if (k2 < PART && F2.hasNextInt()) {
                            numeroF2 = F2.nextInt();
                            hayNumeroF2 = true;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al mezclar los archivos:");
            System.out.println(e.getMessage());
        }
    }
}