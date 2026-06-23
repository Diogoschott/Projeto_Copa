import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsultaController {
    public void createConsulta(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os dados para registrar uma Consulta Médica:");
        
        System.out.print("ID da Consulta: ");
        int idConsulta = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("ID do Fisioterapeuta (Já cadastrado): ");
        int idFisio = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("ID do Jogador (Já cadastrado): ");
        int idJogador = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("ID da Lesão (Já cadastrada): ");
        int idLesao = Integer.parseInt(input.nextLine().trim());
        
        System.out.print("Data e Hora da Consulta (Formato AAAA-MM-DD HH:MM:SS): ");
        String data = input.nextLine().trim();
        
        System.out.print("Procedimento Realizado: ");
        String procedimento = input.nextLine().trim();
        
        System.out.print("Observações Médicas: ");
        String observacoes = input.nextLine().trim();
        
        ConsultaBean cb = new ConsultaBean(idConsulta, idFisio, idJogador, idLesao, data, procedimento, observacoes);
        ConsultaModel.create(cb, con);
        System.out.println("Consulta registrada com sucesso!!");
    }

    public void deleteConsulta(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER CONSULTA ---");
        System.out.print("Digite o ID da Consulta que deseja remover: ");
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            ConsultaModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: Falha no banco de dados.");
        }
    }
}