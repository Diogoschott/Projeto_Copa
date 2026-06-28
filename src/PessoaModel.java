import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class PessoaModel {
    public static void create(PessoaBean p, Connection con) throws SQLException {
        String sql = "INSERT INTO pessoa (id_pessoa, nome, cpf, data_nascimento) VALUES (?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, p.getIdPessoa());
            st.setString(2, p.getNome());
            st.setString(3, p.getCpf());
            

            st.setDate(4, Date.valueOf(p.getDataNascimento())); 
            
            st.execute();
        }
    }

    public static void delete(int idPessoa, Connection con) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idPessoa);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma pessoa encontrada com esse ID.");
            } else {
                System.out.println("Pessoa removida com sucesso!");
            }
        }
    }
}
