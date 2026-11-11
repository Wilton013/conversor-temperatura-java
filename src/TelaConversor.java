import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaConversor {
    private JFrame janela;
    private JLabel textoInicial;
    private JLabel textoResultado;
    private JTextField campo;
    private JButton converter;
    private JButton limpar;

    public TelaConversor() {
        this.janela = new JFrame("Convertor de temperatura");


        janela.setSize(540 , 340);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);


        this.textoInicial = new JLabel("Celsius para Fahrenheit:");

        this.textoResultado = new JLabel("",
                SwingConstants.CENTER );


        this.campo = new JTextField(15 );

        String textoAjuda = "Digite a temperatura";

        campo.setText(textoAjuda);
        campo.setForeground(Color.GRAY);

        campo.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(textoAjuda)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campo.getText().trim().isEmpty()) {
                    campo.setText(textoAjuda);
                    campo.setForeground(Color.GRAY);
                }
            }
        });



        this.converter = new JButton("Converter");
        this.limpar = new JButton("Limpar");

        limpar.addActionListener(e -> {

            limpar.addActionListener(a -> {
                campo.setText(textoAjuda);
                campo.setForeground(Color.GRAY);
                textoResultado.setText("");
            });

        });

        converter.addActionListener(e -> {

            try {
                String celsiusTexto = campo.getText().trim();
                if (celsiusTexto.isEmpty() || celsiusTexto.equals(textoAjuda)) {
                    textoResultado.setText("Digite uma temperatura.");
                    return;
                }

                double celsius = Double.parseDouble(celsiusTexto);
                double fahrenheit = ConversorTemperatura.converterCelsiusParaFahrenheit(celsius);

                textoResultado.setText(celsiusTexto + " ℃ é equivalante a " + fahrenheit + " ℉");
            } catch (NumberFormatException erro) {

                textoResultado.setText("Digite um numero");

            }
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));

        painelBotoes.add(converter);
        painelBotoes.add(limpar);

        JPanel painel = new JPanel(new GridLayout(3, 1, 0, 2));

        painel.add(textoInicial);
        painel.add(campo);
        painel.add(painelBotoes);



        janela.setLayout(new BorderLayout());

        janela.add(painel, BorderLayout.PAGE_START);
        janela.add(textoResultado, BorderLayout.CENTER);
        janela.setVisible(true);
    }
}

