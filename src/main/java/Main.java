import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws APIConn.APIException {
    Calculadora calculadora = new Calculadora();
    Scanner scanner = new Scanner(System.in);
    double value = scanner.nextDouble();
    System.out.println(calculadora.returnOnCDI(value));
    }
}
