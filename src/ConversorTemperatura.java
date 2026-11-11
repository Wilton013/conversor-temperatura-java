public class ConversorTemperatura {
    public static double converterCelsiusParaFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }




    public static void main(String[] args) {
        System.out.println(converterCelsiusParaFahrenheit(100));
    }

}
