import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class JogadorController {
    public void createJogador(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados para criar um novo jogador");
        System.out.println("(Atencao o ID deve ser de uma pessoa ja cadastrada mo banco de dados)");

        System.out.println("ID do Jogador: ");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("Posiçao (Ex: Atacante): ");
        String posicao = input.nextLine();

        System.out.println("Número da camisa: ");
        int camisa = Integer.parseInt(input.nextLine());

        JogadorBean jb = new JogadorBean(id, posicao, camisa);
        JogadorModel.create(jb, con);
        System.out.println("Jogador inserido com sucesso!!");
    }    

    public void deleteJogador(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER JOGADOR ---");
        System.out.print("Digite o ID (Pessoa) do Jogador que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            JogadorModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Este jogador possui disputas, lesões ou consultas registradas!");
        }
    }
}
