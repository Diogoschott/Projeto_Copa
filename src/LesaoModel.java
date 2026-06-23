import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class LesaoModel {
    public static void create(LesaoBean l, Connection con) throws SQLException {
        String sql = "INSERT INTO lesao (id_lesao, id_pessoa_jogador, tipo_lesao, data_ocorrencia, gravidade) VALUES (?,?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, l.getIdLesao());
            st.setInt(2, l.getIdPessoaJogador());
            st.setString(3, l.getTipoLesao());
            st.setDate(4, Date.valueOf(l.getDataOcorrencia()));
            st.setString(5, l.getGravidade());
            st.execute();
        }
    }

    public static void delete(int idLesao, Connection con) throws SQLException {
        String sql = "DELETE FROM lesao WHERE id_lesao = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idLesao);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma lesão encontrada com esse ID.");
            } else {
                System.out.println("Lesão removida com sucesso!");
            }
        }
    }
}