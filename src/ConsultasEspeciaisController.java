import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasEspeciaisController {

    // IMPLEMENTAÇÃO DA OPÇÃO 4 (JOIN)
    public void listarJogosComEstadios(Connection con) {
        System.out.println("\n=======================================================");
        System.out.println("  RELATÓRIO: CALENDÁRIO DE JOGOS E SEUS ESTÁDIOS (JOIN)");
        System.out.println("=======================================================");

        // A query que cruza as duas tabelas
        String sql = "SELECT j.id_jogo, j.data_hora_jogo, e.nome_estadio, e.cidade " +
                     "FROM jogo j " +
                     "INNER JOIN estadio e ON j.id_estadio = e.id_estadio " +
                     "ORDER BY j.data_hora_jogo ASC";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            boolean encontrouResultados = false;

            // Varre os resultados da junção linha por linha
            while (rs.next()) {
                encontrouResultados = true;
                int idJogo = rs.getInt("id_jogo");
                String dataHora = rs.getString("data_hora_jogo");
                String nomeEstadio = rs.getString("nome_estadio");
                String cidade = rs.getString("cidade");

                System.out.println("Partida #" + idJogo + " | Data/Hora: " + dataHora);
                System.out.println("Local: " + nomeEstadio + " (" + cidade + ")");
                System.out.println("-------------------------------------------------------");
            }

            if (!encontrouResultados) {
                System.out.println("Nenhum jogo cadastrado com estádio no momento.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta JOIN: " + e.getMessage());
        }
    }

    // IMPLEMENTAÇÃO DA OPÇÃO 5 (SUBCONSULTA + AGREGAÇÃO)
    public void listarEstadiosAcimaDaMedia(Connection con) {
        System.out.println("\n=======================================================");
        System.out.println("  RELATÓRIO: ESTÁDIOS ACIMA DA MÉDIA DE CAPACIDADE");
        System.out.println("=======================================================");

        // A query exigida pela rubrica: Subconsulta contendo agregação (AVG)
        String sql = "SELECT nome_estadio, capacidade, cidade " +
                     "FROM estadio " +
                     "WHERE capacidade > (SELECT AVG(capacidade) FROM estadio) " +
                     "ORDER BY capacidade DESC";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            boolean encontrouResultados = false;

            // Imprime os estádios que superaram a média
            while (rs.next()) {
                encontrouResultados = true;
                String nomeEstadio = rs.getString("nome_estadio");
                int capacidade = rs.getInt("capacidade");
                String cidade = rs.getString("cidade");

                System.out.println("Estádio: " + nomeEstadio + " (" + cidade + ")");
                System.out.println("Capacidade: " + capacidade + " lugares");
                System.out.println("-------------------------------------------------------");
            }

            if (!encontrouResultados) {
                System.out.println("Não há estádios suficientes cadastrados para calcular uma média com excedentes.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Subconsulta: " + e.getMessage());
        }
    }
    
}