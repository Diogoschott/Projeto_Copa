import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class EstadioModel {

    public static void create(EstadioBean e, Connection con) throws SQLException {
        String sql = "INSERT INTO estadio (id_estadio, nome_estadio, capacidade, cidade) VALUES (?,?,?,?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, e.getIdEstadio());
            st.setString(2, e.getNomeEstadio());
            st.setInt(3, e.getCapacidade());
            st.setString(4, e.getCidade());
            st.execute();
        }
    }

    public static HashSet<EstadioBean> listAll(Connection con) throws SQLException {
        HashSet<EstadioBean> list = new HashSet<>();
        String sql = "SELECT id_estadio, nome_estadio, capacidade, cidade FROM estadio";
        
        try (Statement st = con.createStatement();
             ResultSet result = st.executeQuery(sql)) {
            while(result.next()) {
                list.add(new EstadioBean(
                    result.getInt(1), 
                    result.getString(2), 
                    result.getInt(3), 
                    result.getString(4)
                ));
            }
        }
        return list;
    }

    public static void delete(int idEstadio, Connection con) throws SQLException {
        String sql = "DELETE FROM estadio WHERE id_estadio = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idEstadio);
            int linhasAfetadas = st.executeUpdate(); // Retorna quantas linhas foram apagadas
            
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum estádio encontrado com esse ID.");
            } else {
                System.out.println("Estádio removido com sucesso!");
            }
        }
    }
}