import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioController {
    
    public void listarTudo(Connection conn) {
        String[] todasTabelas = {
            "pessoa", "campeonato", "estadio", "fisioterapeuta", 
            "jogador", "jogo", "lesao", "disputa", "consulta"
        };

        System.out.println("\n>>> INICIANDO VARREDURA COMPLETA DO BANCO <<<");

        for (String tab : todasTabelas) {
            System.out.println("\n--- Tabela: " + tab.toUpperCase() + " ---");
            String sql = "SELECT * FROM " + tab;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                ResultSetMetaData meta = rs.getMetaData();
                int totalColunas = meta.getColumnCount();
                boolean temLinha = false;
                
                while (rs.next()) {
                    temLinha = true;
                    StringBuilder tupla = new StringBuilder();
                    for (int i = 1; i <= totalColunas; i++) {
                        tupla.append(meta.getColumnName(i)).append(": ").append(rs.getString(i)).append(" | ");
                    }
                    System.out.println(tupla);
                }
                
                if (!temLinha) {
                    System.out.println("(Tabela vazia)");
                }

            } catch (SQLException e) {
                System.err.println("Erro ao ler tabela " + tab + ": " + e.getMessage());
            }
        }
        System.out.println("\n>>> FIM DA VARREDURA <<<");
    }
}