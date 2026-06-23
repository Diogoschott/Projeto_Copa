import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class JogoController {
    public void createJogo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para agendar um novo Jogo:");
        
        System.out.print("ID do Jogo: ");
        int idJogo = Integer.parseInt(input.nextLine());
        
        System.out.print("ID do Campeonato (Já cadastrado): ");
        int idCamp = Integer.parseInt(input.nextLine());
        
        System.out.print("ID do Estádio (Já cadastrado): ");
        int idEstadio = Integer.parseInt(input.nextLine());
        
        System.out.print("Data e Hora (Exato formato AAAA-MM-DD HH:MM:SS): ");
        String dataHora = input.nextLine();
        
        System.out.print("Placar (Ex: 2x1) ou aperte Enter se o jogo não ocorreu: ");
        String placar = input.nextLine();
        if (placar.isEmpty()) placar = null; // Envia null se o usuário não digitar nada
        
        JogoBean jb = new JogoBean(idJogo, idCamp, idEstadio, dataHora, placar);
        JogoModel.create(jb, con);
        System.out.println("Jogo inserido com sucesso!!");
    }

    public void deleteJogo(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER JOGO ---");
        System.out.print("Digite o ID do Jogo que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            JogoModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Este jogo possui disputas (jogadores) vinculadas a ele!");
        }
    }
}