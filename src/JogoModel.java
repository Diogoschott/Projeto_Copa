import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp; // Usado para Data e Hora juntas

public class JogoModel {
    public static void create(JogoBean j, Connection con) throws SQLException {
        String sql = "INSERT INTO jogo (id_jogo, id_campeonato, id_estadio, data_hora_jogo, placar) VALUES (?,?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, j.getIdJogo());
            st.setInt(2, j.getIdCampeonato());
            st.setInt(3, j.getIdEstadio());
            // Converte a String para o formato Timestamp do banco
            st.setTimestamp(4, Timestamp.valueOf(j.getDataHoraJogo()));
            st.setString(5, j.getPlacar());
            st.execute();
        }
    }

    public static void delete(int idJogo, Connection con) throws SQLException {
        String sql = "DELETE FROM jogo WHERE id_jogo = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idJogo);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum jogo encontrado com esse ID.");
            } else {
                System.out.println("Jogo removido com sucesso!");
            }
        }
    }
}