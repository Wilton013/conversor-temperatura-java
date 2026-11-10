import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame janela = new JFrame("Convertor de temperatura");


            janela.setSize(500 , 300);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLocationRelativeTo(null);


            JLabel textoIncial = new JLabel("Celsius para Fahrenheit:");

            JLabel textoResultado = new JLabel("",
                    SwingConstants.CENTER );


            JTextField campo = new JTextField(15 );


            JButton botao = new JButton("Converter");

            botao.addActionListener(e -> {
                try {
                    String celsiusTexto = campo.getText().trim();

                    double celsius = Double.parseDouble(celsiusTexto);
                    double fahrenheit = celsius * 9.0 / 5.0 + 32;

                    textoResultado.setText(celsiusTexto + " ℃ é equivalante a " + fahrenheit + " ℉");
                } catch (NumberFormatException erro) {

                    textoResultado.setText("Digite um numero");

                }
            });


            JPanel painel = new JPanel();
                painel.add(textoIncial);
                painel.add(campo);
                painel.add(botao);


            janela.setLayout(new BorderLayout());

            janela.add(painel, BorderLayout.PAGE_START);
            janela.add(textoResultado, BorderLayout.CENTER);

            janela.setVisible(true);
        });
    }
}