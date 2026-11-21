
import java.util.Random;
public class aleatorioArray {
    
        public int[] generarVector(int tamanio) {

            Random r = new Random();

            int[] vector = new int[tamanio];

            for(int i=0; i < vector.length; i++){
                vector[i] = r.nextInt(100);
                
            }
            return vector;

        }
    }


