import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CampeonatoController {
    public void createCampeonato(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para criar um novo Campeonato:");
        
        System.out.print("ID do Campeonato: ");
        int id = Integer.parseInt(input.nextLine());
        
        System.out.print("Nome: ");
        String nome = input.nextLine();
        
        System.out.print("Ano da Edição (Ex: 2026): ");
        int ano = Integer.parseInt(input.nextLine());
        
        CampeonatoBean cb = new CampeonatoBean(id, nome, ano);
        CampeonatoModel.create(cb, con);
        System.out.println("Campeonato inserido com sucesso!!");
    }

    public void deleteCampeonato(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER CAMPEONATO ---");
        System.out.print("Digite o ID do Campeonato que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            CampeonatoModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: O campeonato possui jogos vinculados a ele!");
        }
    }
}