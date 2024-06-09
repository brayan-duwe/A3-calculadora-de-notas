package CalculadoraDeNotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DeletarNota {
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	public void deletarNota(DefaultTableModel model) {
	    int numRows = model.getRowCount();
	    
		Connection conn = null;
		try {
			conn = connectionFactory.obtemConexao();
			conn.setAutoCommit(false);

			for (int i = numRows - 1; i >= 0; i--) {
				boolean selecionado = (boolean) model.getValueAt(i, 0);
				if (selecionado) {
					double doubleValue = (double) model.getValueAt(i,1);
					int id = (int) doubleValue;
					try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM notas WHERE id = ?")) {
						stmt.setInt(1, id);
						stmt.executeUpdate();
					}
					model.removeRow(i);
				}
			}
			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao apagar registros do banco de dados: " + ex.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Erro ao realizar rollback da transação: " + rollbackEx.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException closeEx) {
				closeEx.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Erro ao fechar conexão com o banco de dados: " + closeEx.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
