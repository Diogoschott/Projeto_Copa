import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CampeonatoModel {
    public static void create(CampeonatoBean c, Connection con) throws SQLException {
        String sql = "INSERT INTO campeonato (id_campeonato, nome_campeonato, ano_edicao) VALUES (?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, c.getIdCampeonato());
            st.setString(2, c.getNomeCampeonato());
            st.setInt(3, c.getAnoEdicao());
            st.execute();
        } 
    }
    public static void delete(int idCampeonato, Connection con) throws SQLException {
        String sql = "DELETE FROM campeonato WHERE id_campeonato = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idCampeonato);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum campeonato encontrado com esse ID.");
            } else {
                System.out.println("Campeonato removido com sucesso!");
            }
        }
    }
}