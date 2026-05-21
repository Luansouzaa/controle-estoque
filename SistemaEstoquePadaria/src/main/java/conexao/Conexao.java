package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("[Sucesso] Conexão com o banco de dados estabelecida!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("[Erro] O Driver JDBC do MySQL não foi encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("[Erro] Falha ao tentar conectar ao banco de dados MySQL.");
            e.printStackTrace();
        }
        return conn;
    }
}