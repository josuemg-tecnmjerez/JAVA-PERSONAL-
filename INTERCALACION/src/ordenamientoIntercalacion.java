public class ordenamientoIntercalacion {

    private long comparaciones = 0;
    private long intercambios = 0;
    private long recorridos = 0;

    public void ordenar(int[] datos) {
        mergeSort(datos, 0, datos.length - 1);
    }

    private void mergeSort(int[] datos, int izquierda, int derecha) {

        recorridos++;

        if (izquierda < derecha) {

            int medio = (izquierda + derecha) / 2;

            mergeSort(datos, izquierda, medio);
            mergeSort(datos, medio + 1, derecha);

            intercalar(datos, izquierda, medio, derecha);
        }
    }

    private void intercalar(int[] datos,
                            int izquierda,
                            int medio,
                            int derecha) {

        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = datos[izquierda + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = datos[medio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < n1 && j < n2) {

            comparaciones++;

            if (L[i] <= R[j]) {
                datos[k] = L[i];
                i++;
            } else {
                datos[k] = R[j];
                j++;
            }

            intercambios++;
            k++;
        }

        while (i < n1) {
            datos[k] = L[i];
            i++;
            k++;
            intercambios++;
        }

        while (j < n2) {
            datos[k] = R[j];
            j++;
            k++;
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