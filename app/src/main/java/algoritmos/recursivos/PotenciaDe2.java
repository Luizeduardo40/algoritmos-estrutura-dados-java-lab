package algoritmos.recursivos;

public class PotenciaDe2 {

    public static int potenciaDe2Recursiva(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return 2 * potenciaDe2Recursiva(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int resultado = potenciaDe2Recursiva(n);
        System.out.println("O valor de 2 elevado a " + n + " é: " + resultado);
    }

}
