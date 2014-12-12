package com.thalespf.contas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.thalespf.contas.modelo.Conta;
import com.thalespf.contas.modelo.TipoDaConta;

@Repository
public class ContaDAO {
	
	private DataSource dataSource;
	private Connection connection;
	
	@Inject
	public ContaDAO(DataSource dataSource) {
		try {
			this.dataSource = dataSource;
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Conta conta) {
		String sql = "insert into contas (descricao, paga, valor, tipo) values (?,?,?,?)";
		PreparedStatement stmt;
		try {
			this.connection = dataSource.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, conta.getDescricao());
			stmt.setBoolean(2, conta.isPaga());
			stmt.setDouble(3, conta.getValor());
			stmt.setString(4, conta.getTipo().name());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void remove(Conta conta) {

		if (conta.getId() == null) {
			throw new IllegalStateException("Id da conta naoo deve ser nula.");
		}

		String sql = "delete from contas where id = ?";
		PreparedStatement stmt;
		try {
			this.connection = dataSource.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, conta.getId());
			stmt.execute();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Conta conta) {
		String sql = "update contas set descricao = ?, paga = ?, dataPagamento = ?, tipo = ?, valor = ? where id = ?";
		PreparedStatement stmt;
		try {
			this.connection = dataSource.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, conta.getDescricao());
			stmt.setBoolean(2, conta.isPaga());
			stmt.setDate(3, conta.getDataPagamento() != null ? new Date(conta
					.getDataPagamento().getTimeInMillis()) : null);
			stmt.setString(4, conta.getTipo().name());
			stmt.setDouble(5, conta.getValor());
			stmt.setLong(6, conta.getId());
			stmt.execute();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Conta> lista() {
		try {
			List<Conta> contas = new ArrayList<Conta>();
			
			this.connection = dataSource.getConnection();
			
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contas");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a conta na lista
				contas.add(populaConta(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return contas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Conta buscaPorId(Long id) {
		
		if (id == null) {
			throw new IllegalStateException("Id da conta nao deve ser nula.");
		}

		try {
			this.connection = dataSource.getConnection();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contas where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				connection.close();
				return populaConta(rs);
			}

			rs.close();
			stmt.close();
			

			connection.close();
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void paga(Long id) {

		if (id == null) {
			throw new IllegalStateException("Id da conta nao deve ser nula.");
		}

		String sql = "update contas set paga = ?, dataPagamento = ? where id = ?";
		PreparedStatement stmt;
		try {
			this.connection = dataSource.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(3, id);
			stmt.execute();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Conta populaConta(ResultSet rs) throws SQLException {
		Conta conta = new Conta();

		conta.setId(rs.getLong("id"));
		conta.setDescricao(rs.getString("descricao"));
		conta.setPaga(rs.getBoolean("paga"));
		conta.setValor(rs.getDouble("valor"));

		Date data = rs.getDate("dataPagamento");
		if (data != null) {
			Calendar dataPagamento = Calendar.getInstance();
			dataPagamento.setTime(data);
			conta.setDataPagamento(dataPagamento);
		}
		
		conta.setTipo(Enum.valueOf(TipoDaConta.class, rs.getString("tipo")));
		
		return conta;
	}
}
