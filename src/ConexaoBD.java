import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    // Credenciais do Banco de Dados
    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_copa";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    /**
     * Método responsável por estabelecer a conexão com o PostgreSQL.
     */
    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("[LOG] Conexão com o banco 'projeto_copa' estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.err.println("[ERRO] Falha ao conectar no banco de dados.");
            System.err.println("Detalhes: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método responsável por fechar a conexão de forma segura.
     */
    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("[LOG] Conexão encerrada.");
            } catch (SQLException e) {
                System.err.println("[ERRO] Falha ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}