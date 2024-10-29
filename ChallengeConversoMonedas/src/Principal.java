import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        ConsultaMonedas consultar = new ConsultaMonedas();

        int op = 0;
        double monto;

        while(op != 7){
            System.out.println("*******************************************");
            System.out.println("Sea bienvenido al conversor de moneda :D !!");
            System.out.println("");
            System.out.println("1) Dólar           ==> Peso Argentino");
            System.out.println("2) Peso Argentino  ==> Dólar");
            System.out.println("3) Dólar           ==> Real Brasileño");
            System.out.println("4) Real Brasileño  ==> Dólar");
            System.out.println("5) Dólar           ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dólar");
            System.out.println("7) Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            op = tec.nextInt();

            String monedaBase = "";
            String monedaObjetivo = "";

            switch (op) {
                case 1:
                    monedaBase = "USD";
                    monedaObjetivo = "ARS";
                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaObjetivo = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaObjetivo = "BRL";
                    break;
                case 4:
                    monedaBase = "BRL";
                    monedaObjetivo = "USD";
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaObjetivo = "COP";
                    break;
                case 6:
                    monedaBase = "COP";
                    monedaObjetivo = "USD";
                    break;
                case 7:
                    System.out.println("Programa Finalizado :D !!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    continue;
            }

            System.out.println("Ingrese el valor que deseas convertir:");
            monto = tec.nextDouble();

            try {
                double resultado = consultar.convertir(monedaBase, monedaObjetivo, monto);
                System.out.printf("El valor %.2f [%s] corresponde al valor final de => %.2f [%s]%n", monto, monedaBase, resultado, monedaObjetivo);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
