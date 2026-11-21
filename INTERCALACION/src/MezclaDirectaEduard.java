public class MezclaDirectaEduard {

    private long comparaciones = 0;
    private long intercambios = 0;
    private long recorridos = 0;

    public void ordenar(int[] datos) {

        int n = datos.length;
        int[] aux = new int[n];

        for (int part = 1; part < n; part *= 2) {

            recorridos++;

            for (int inicio = 0; inicio < n; inicio += 2 * part) {

                int mitad = Math.min(inicio + part, n);
                int fin = Math.min(inicio + 2 * part, n);

                mezclar(datos, aux, inicio, mitad, fin);
            }
        }
    }

    private void mezclar(int[] datos,
                         int[] aux,
                         int inicio,
                         int mitad,
                         int fin) {

        int i = inicio;
        int j = mitad;
        int k = inicio;

        while (i < mitad && j < fin) {

            comparaciones++;

            if (datos[i] <= datos[j]) {
                aux[k++] = datos[i++];
            } else {
                aux[k++] = datos[j++];
            }

            intercambios++;
        }

        while (i < mitad) {
            aux[k++] = datos[i++];
            intercambios++;
        }

        while (j < fin) {
            aux[k++] = datos[j++];
            intercambios++;
        }

        for (int x = inicio; x < fin; x++) {
            datos[x] = aux[x];
            intercambios++;
        }
    }

    public long getComparaciones() {
        return comparaciones;
    }

    public long getIntercambios() {
        return intercambios;
    }

    public long getRecorridos() {
        return recorridos;
    }
}