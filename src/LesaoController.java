import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LesaoController {
    public void createLesao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para registrar uma Lesão:");
        
        System.out.print("ID da Lesão: ");
        int idLesao = Integer.parseInt(input.nextLine());
        
        System.out.print("ID do Jogador Machucado (Já cadastrado): ");
        int idJogador = Integer.parseInt(input.nextLine());
        
        System.out.print("Tipo da Lesão (Ex: Torção no tornozelo): ");
        String tipo = input.nextLine();
        
        System.out.print("Data da Ocorrência (Formato AAAA-MM-DD): ");
        String data = input.nextLine();
        
        System.out.print("Gravidade (Ex: Leve, Média, Grave): ");
        String gravidade = input.nextLine();
        
        LesaoBean lb = new LesaoBean(idLesao, idJogador, tipo, data, gravidade);
        LesaoModel.create(lb, con);
        System.out.println("Lesão registrada com sucesso!!");
    }

    public void deleteLesao(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER LESÃO ---");
        System.out.print("Digite o ID da Lesão que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            LesaoModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Esta lesão está vinculada a uma consulta médica!");
        }
    }
}