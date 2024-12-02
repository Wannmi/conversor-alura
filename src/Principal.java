import java.util.Scanner;

public class Principal {
    static void convertirMoneda(String monedaBase, String monedaFinal){
        Scanner teclado = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        Conversiones conversion;
        Double valorConversion;
        conversion = consulta.ConsultaConversion(monedaBase);
        valorConversion = conversion.conversion_rates().get(monedaFinal);
        double monto;
        System.out.println("Ingrese el monto que desea cambiar: ");
        monto = teclado.nextDouble();
        System.out.println(monto + " " + monedaBase + " equivalen a " + monto*valorConversion + " " + monedaFinal);
    };
    
    public static void main(String[] args) {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        String menu = """
                
                ***********************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real Brasileño =>> Dolar
                5) Dolar =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Salir
                Elija una opción válida:
                ***********************************************************
                """;


        while (opcion != 7){
            System.out.println(menu);
            opcion = teclado.nextInt();
            ConsultaAPI consulta = new ConsultaAPI();
            Conversiones conversion;
            Double valorConversion;
            switch (opcion){
                case 1:
                    convertirMoneda("USD","ARS");
                    break;
                case 2:
                    convertirMoneda("ARS", "USD");
                    break;
                case 3:
                    convertirMoneda("USD","BRL");
                    break;
                case 4:
                    convertirMoneda("BRL","USD");
                    break;
                case 5:
                    convertirMoneda("USD","COP");
                    break;
                case 6:
                    convertirMoneda("COP","USD");
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro Conversor de Moneda");
                    break;
                default:
                    System.out.println("Opcion no valida \n");
                    break;
            }
        }
    }
}