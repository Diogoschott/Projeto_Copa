import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class FisioterapeutaController {
    public void createFisioterapeuta(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para criar um novo Fisioterapeuta:");
        System.out.println("(Atenção: O ID deve ser de uma Pessoa já cadastrada no banco!)");
        
        System.out.print("ID do Fisioterapeuta (Pessoa): ");
        int id = Integer.parseInt(input.nextLine());
        
        System.out.print("Registro CREFITO: ");
        String crefito = input.nextLine();
        
        System.out.print("Especialidade: ");
        String especialidade = input.nextLine();
        
        FisioterapeutaBean fb = new FisioterapeutaBean(id, crefito, especialidade);
        FisioterapeutaModel.create(fb, con);
        System.out.println("Fisioterapeuta inserido com sucesso!!");
    }

    public void deleteFisioterapeuta(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER FISIOTERAPEUTA ---");
        System.out.print("Digite o ID (Pessoa) do Fisioterapeuta que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            FisioterapeutaModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Este fisioterapeuta possui consultas vinculadas a ele!");
        }
    }
}