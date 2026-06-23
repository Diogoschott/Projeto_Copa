import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JogadorModel {
    public static void create(JogadorBean j, Connection con) throws SQLException{
        String sql = "INSERT INTO jogador (id_pessoa, posicao, numero_camisa) VALUES(?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)){
            st.setInt(1, j.getIdPessoa());
            st.setString(2, j.getPosicao());
            st.setInt(3, j.getNumeroCamisa());
            st.execute();
        }
    }    

    public static void delete(int idPessoa, Connection con) throws SQLException {
        String sql = "DELETE FROM jogador WHERE id_pessoa = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idPessoa);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum jogador encontrado com esse ID.");
            } else {
                System.out.println("Jogador removido com sucesso!");
            }
        }
    }
}
