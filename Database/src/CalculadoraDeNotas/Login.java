package CalculadoraDeNotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public boolean verificarCredenciais(String username, String password) {
        try (Connection conn = connectionFactory.obtemConexao()) {
            String sql = "SELECT senha FROM alunos WHERE usuario = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("senha");
                        return password.equals(storedPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    Connection conexao = connectionFactory.obtemConexao();

    public static void main(String[] args) {
        Login loginAluno = new Login();
        String username = "jose";
        String password = "jose1234";

        if (loginAluno.verificarCredenciais(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
        }
    }
}