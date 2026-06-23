import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class PessoaController {
    public void createPessoa(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para criar uma nova Pessoa:");
        
        System.out.print("ID da Pessoa: ");
        int id = Integer.parseInt(input.nextLine());
        
        System.out.print("Nome Completo: ");
        String nome = input.nextLine();
        
        System.out.print("CPF (Apenas números): ");
        String cpf = input.nextLine();
        
        System.out.print("Data de Nascimento (Formato AAAA-MM-DD): ");
        String data = input.nextLine();
        
        PessoaBean pb = new PessoaBean(id, nome, cpf, data);
        PessoaModel.create(pb, con);
        System.out.println("Pessoa inserida com sucesso!!");
    }

    public void deletePessoa(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER PESSOA ---");
        System.out.print("Digite o ID da Pessoa que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            PessoaModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Esta pessoa está cadastrada como Jogador ou Fisioterapeuta! Remova as dependências primeiro.");
        }
    }
}