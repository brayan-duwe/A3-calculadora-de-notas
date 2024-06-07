package CalculadoraDeNotas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Calculadora {

    private JFrame frame;
    private JTextField tfnotasProva1;
    private JTextField tfnotasProva2;
    private JTextField tfnotasTrabalho1;
    private JTextField tfnotasTrabalho2;
    private JTextField tfparticipacoes;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora window = new Calculadora();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculadora() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 473, 364);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        tfnotasProva1 = new JTextField(50);
        frame.getContentPane().add(tfnotasProva1);

        JLabel lblnotasProvas = new JLabel("Notas provas");
        lblnotasProvas.setBounds(10, 49, 91, 14);
        frame.getContentPane().add(lblnotasProvas);

        tfnotasProva2 = new JTextField();
        tfnotasProva2.setBounds(281, 46, 166, 20);
        frame.getContentPane().add(tfnotasProva2);
        tfnotasProva2.setColumns(10);

        JLabel lblNewLabel = new JLabel("Calculadora de Notas");
        lblNewLabel.setBounds(143, 11, 178, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblnotasTrabalhos = new JLabel("Notas trabalhos");
        lblnotasTrabalhos.setBounds(10, 80, 91, 14);
        frame.getContentPane().add(lblnotasTrabalhos);

        tfnotasTrabalho1 = new JTextField();
        tfnotasTrabalho1.setBounds(121, 77, 150, 20);
        frame.getContentPane().add(tfnotasTrabalho1);
        tfnotasTrabalho1.setColumns(10);

        tfnotasTrabalho2 = new JTextField();
        tfnotasTrabalho2.setBounds(281, 77, 166, 20);
        frame.getContentPane().add(tfnotasTrabalho2);
        tfnotasTrabalho2.setColumns(10);

        JLabel lblnotasParticipacoes = new JLabel("Participacoes");
        lblnotasParticipacoes.setBounds(10, 116, 91, 14);
        frame.getContentPane().add(lblnotasParticipacoes);

        tfparticipacoes = new JTextField();
        tfparticipacoes.setBounds(114, 113, 157, 20);
        frame.getContentPane().add(tfparticipacoes);
        tfparticipacoes.setColumns(10);

        JButton btnNewButton = new JButton("Calcular Media Ponderada");
        btnNewButton.setBounds(121, 203, 223, 23);
        frame.getContentPane().add(btnNewButton);

        lblNewLabel_1 = new JLabel("Media");
        lblNewLabel_1.setBounds(188, 263, 71, 14);
        frame.getContentPane().add(lblNewLabel_1);
    }
}