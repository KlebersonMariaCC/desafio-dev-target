import java.util.Arrays;
import java.util.Random;

public class Questao3 {


    public static void main(String[] args) {
        Random generator = new Random();
        int[] faturamento = new int[365];

        //Gera o array exemplo de faturamento
        for (int i = 0; i < faturamento.length; i++) {
            faturamento[i]  = 0 + generator.nextInt(101);
        } 

       
        int menor = Integer.MAX_VALUE;
        int maior = Integer.MIN_VALUE;
        int soma = 0;
        int n_elementos = 0;
        
        for (int elemento : faturamento) {

             if ( elemento > maior) {
                maior = elemento;
            }

            if (elemento < menor) {
                menor = elemento;
            }

            if ( elemento == 0) {
                continue;
            }

            soma += elemento;
            n_elementos++;
        }
        int media = soma/ n_elementos;
        int contador = 0;

        for (int elemento : faturamento) {
            
            if (elemento > media) {
                 contador++;
            }
        }

        System.out.println("Maior faturamento diário: " + maior);
        System.out.println("Menor Faturamento diario: " + menor);
        System.out.println("Dias maiores que a media anual: " + contador);

    }

}
