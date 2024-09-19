import java.util.Arrays;
import java.util.Random;

public class Questao3 {


    public static void main(String[] args) {
        Random generator = new Random();
        int[] faturamento = new int[365];

        for (int i = 0; i < faturamento.length; i++) {
            faturamento[i]  = 0 + generator.nextInt(101);
        } 

        //System.out.println(Arrays.toString(faturamento));

        
    }

}
