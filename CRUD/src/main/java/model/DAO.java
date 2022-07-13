package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	/* modulo de conexao */
	/** The driver. */
	// parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbCRUD?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "root";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// metodo de conexao
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD Create *.
	 *
	 * @param dado the dado
	 */
	public void inserirDado(JavaBeans dado) {
		String create = "insert into crudJavaWeb (nome, telefone, cpf, modeloVeiculo, marcaVeiculo, placaVeiculo) values (?, ?, ?, ?, ?, ?)";
		try {
			// abrindo a conexao com o banco
			Connection con = conectar();
			// preparar a query para a execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros "?" pelo conteudo armazenado em JavaBeans

			pst.setString(1, dado.getNome());
			pst.setString(2, dado.getTelefone());
			pst.setString(3, dado.getCpf());
			pst.setString(4, dado.getModeloVeiculo());
			pst.setString(5, dado.getMarcaVeiculo());
			pst.setString(6, dado.getPlacaVeiculo());
			// executando a query
			pst.executeUpdate();
			// encerrando a conexao com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// testando conexao
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

	/**
	 * Listar dados.
	 *
	 * @return the array list
	 */
	// CRUD READ
	public ArrayList<JavaBeans> listarDados() {
		// criando um objeto para acessar a classe javabeans
		ArrayList<JavaBeans> dadoss = new ArrayList<>();
		String read = "select * from crudJavaWeb order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String cpf = rs.getString(4);
				String modeloVeiculo = rs.getString(5);
				String marcaVeiculo = rs.getString(6);
				String placaVeiculo = rs.getString(7);

				// populando o arrayList
				dadoss.add(new JavaBeans(id, nome, telefone, cpf, modeloVeiculo, marcaVeiculo, placaVeiculo));
			}
			con.close();
			return dadoss;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// crud update
	/**
	 * Selecionar dado.
	 *
	 * @param dado the dado
	 */
	//selecionar o dado
	public void selecionarDado(JavaBeans dado) {
		String read2 = "select * from crudJavaWeb where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, dado.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				dado.setId(rs.getString(1));
				dado.setNome(rs.getString(2));
				dado.setTelefone(rs.getString(3));
				dado.setCpf(rs.getString(4));
				dado.setModeloVeiculo(rs.getString(5));
				dado.setMarcaVeiculo(rs.getString(6));
				dado.setPlacaVeiculo(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar dado.
	 *
	 * @param dado the dado
	 */
	//editar dado
	public void alterarDado(JavaBeans dado) {
		String create = "update crudJavaWeb set nome=?, telefone=?, cpf=?, modeloVeiculo=?, marcaVeiculo=?, placaVeiculo=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, dado.getNome());
			pst.setString(2, dado.getTelefone());
			pst.setString(3, dado.getCpf());
			pst.setString(4, dado.getModeloVeiculo());
			pst.setString(5, dado.getMarcaVeiculo());
			pst.setString(6, dado.getPlacaVeiculo());
			pst.setString(7, dado.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/**
	 * Deletar dado.
	 *
	 * @param dado the dado
	 */
	/*crud delete*/
	public void deletarDado(JavaBeans dado) {
		String delete = "delete from crudJavaWeb where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, dado.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
