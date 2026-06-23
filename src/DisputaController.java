import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DisputaController {
    public void createDisputa(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados da Disputa (Desempenho do Jogador na Partida):");
        
        System.out.print("ID do Jogador (Já cadastrado): ");
        int idJogador = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("ID do Jogo (Já cadastrado): ");
        int idJogo = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("Minutos em Quadra: ");
        int minutos = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("Pontos Marcados: ");
        int pontos = Integer.parseInt(input.nextLine().trim());
        
        DisputaBean db = new DisputaBean(idJogador, idJogo, minutos, pontos);
        DisputaModel.create(db, con);
        System.out.println("Disputa registrada com sucesso!!");
    }

    public void deleteDisputa(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER DISPUTA ---");
        
        try {
            System.out.print("Digite o ID do Jogador: ");
            int idJogador = Integer.parseInt(input.nextLine().trim());
            
            System.out.print("Digite o ID do Jogo: ");
            int idJogo = Integer.parseInt(input.nextLine().trim());
            
            // Chama o model passando os DOIS IDs
            DisputaModel.delete(idJogador, idJogo, con);
            
        } catch (NumberFormatException e) {
            System.out.println("Erro: IDs inválidos. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover do banco de dados: " + e.getMessage());
        }
    }
}