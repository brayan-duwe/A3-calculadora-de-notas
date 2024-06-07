package CalculadoraDeNotas;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserListFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public UserListFrame() {
        // Configurações do JFrame
        setTitle("Lista de Usuários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        getContentPane().setLayout(new BorderLayout());

        // Dados iniciais da tabela
        Object[][] data = {
            {"Usuário 1", "user1@example.com", true},
            {"Usuário 2", "user2@example.com", false},
            {"Usuário 3", "user3@example.com", true}
        };
        
        // Nomes das colunas
        String[] columnNames = {"Nome", "Email", "Ativo"};

        // Cria um modelo de tabela personalizado
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) // Índice da coluna de checkbox
                    return Boolean.class;
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Apenas a coluna de checkbox é editável
            }
        };

        // Cria a JTable com o modelo personalizado
        table = new JTable(model);

        // Adiciona a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Torna o JFrame visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Executa o JFrame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserListFrame();
            }
        });
    }
}
