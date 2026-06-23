import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ConsultaModel {
    public static void create(ConsultaBean c, Connection con) throws SQLException {
        String sql = "INSERT INTO consulta (id_consulta, id_pessoa_fisioterapeuta, id_pessoa_jogador, id_lesao, data_consulta, procedimento_realizado, observacoes_medicas) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, c.getIdConsulta());
            st.setInt(2, c.getIdFisioterapeuta());
            st.setInt(3, c.getIdJogador());
            st.setInt(4, c.getIdLesao());
            st.setTimestamp(5, Timestamp.valueOf(c.getDataConsulta()));
            st.setString(6, c.getProcedimentoRealizado());
            st.setString(7, c.getObservacoesMedicas());
            st.execute();
        }
    }

    public static void delete(int idConsulta, Connection con) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id_consulta = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idConsulta);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma consulta encontrada com esse ID.");
            } else {
                System.out.println("Consulta removida com sucesso!");
            }
        }
    }
}