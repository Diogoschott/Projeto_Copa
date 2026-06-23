import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FisioterapeutaModel {
    public static void create(FisioterapeutaBean f, Connection con) throws SQLException {
        String sql = "INSERT INTO fisioterapeuta (id_pessoa, registro_crefito, especialidade) VALUES (?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, f.getIdPessoa());
            st.setString(2, f.getRegistroCrefito());
            st.setString(3, f.getEspecialidade());
            st.execute();
        }
    }
    public static void delete(int idPessoa, Connection con) throws SQLException {
        String sql = "DELETE FROM fisioterapeuta WHERE id_pessoa = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idPessoa);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum fisioterapeuta encontrado com esse ID.");
            } else {
                System.out.println("Fisioterapeuta removido com sucesso!");
            }
        }
    }
}