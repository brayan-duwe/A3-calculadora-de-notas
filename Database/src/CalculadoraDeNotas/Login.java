package CalculadoraDeNotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	ConnectionFactory connectionFactory = new ConnectionFactory();
	private int alunoId;

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
	}catch(SQLException e){
		e.printStackTrace();
	}
		return false;
	}

    public int obterAlunoId(String username) {
        int alunoId = -1;
        try (Connection conn = connectionFactory.obtemConexao()) {
            String sql = "SELECT id FROM alunos WHERE usuario = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        alunoId = resultSet.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunoId;
    }

    public boolean autenticar(String username, String password) {
        if (verificarCredenciais(username, password)) {
            int id = obterAlunoId(username);
            if (id != -1) {
                this.alunoId = id;
                return true;
            }
        }
        return false;
    }

    public int getAlunoId() {
        return alunoId;
    }
}