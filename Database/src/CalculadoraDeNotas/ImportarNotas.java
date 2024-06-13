package CalculadoraDeNotas;

import CalculadoraDeNotas.Login.AlunoIdAtual;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ImportarNotas {

	ConnectionFactory connectionFactory = new ConnectionFactory();

	
	public List<Object[]> carregarDados(int alunoId) {
		List<Object[]> dados = new ArrayList<>();
		try (Connection conn = connectionFactory.obtemConexao()) {
			String sql = "SELECT nota, percentual, materia, tipo FROM notas WHERE aluno_id = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, alunoId);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						boolean selecionado;
						double nota = rs.getDouble("nota");
						double percentual = rs.getDouble("percentual");
						String materia = rs.getString("materia");
						String tipo = rs.getString("tipo");
						dados.add(new Object[] { false, nota, percentual, materia, tipo });
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar dados do banco de dados.");
		}
		return dados;
	}
}
