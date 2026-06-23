import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisputaModel {
    public static void create(DisputaBean d, Connection con) throws SQLException {
        String sql = "INSERT INTO disputa (id_pessoa_jogador, id_jogo, minutos_em_quadra, pontos_marcados) VALUES (?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, d.getIdJogador());
            st.setInt(2, d.getIdJogo());
            st.setInt(3, d.getMinutosEmQuadra());
            st.setInt(4, d.getPontosMarcados());
            st.execute();
        }
    }

    public static void delete(int idJogador, int idJogo, Connection con) throws SQLException {
        // O banco só deleta se a linha bater com o Jogador E o Jogo ao mesmo tempo
        String sql = "DELETE FROM disputa WHERE id_pessoa_jogador = ? AND id_jogo = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idJogador);
            st.setInt(2, idJogo);
            
            int linhasAfetadas = st.executeUpdate(); 
            
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma disputa encontrada com essa combinação de Jogador e Jogo.");
            } else {
                System.out.println("Disputa removida com sucesso!");
            }
        }
    }
}