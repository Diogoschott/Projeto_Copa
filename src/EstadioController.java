import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class EstadioController {
    
    public void createEstadio(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInsira os seguintes dados para criar um novo Estádio:");
        
        System.out.print("ID do Estádio: ");
        int id = Integer.parseInt(input.nextLine());
        
        System.out.print("Nome do Estádio: ");
        String nome = input.nextLine();
        
        System.out.print("Capacidade: ");
        int cap = Integer.parseInt(input.nextLine());
        
        System.out.print("Cidade: ");
        String cidade = input.nextLine();
        
        EstadioBean eb = new EstadioBean(id, nome, cap, cidade);
        EstadioModel.create(eb, con);
        System.out.println("Estádio criado com sucesso!!");
    }

    public void listarEstadio(Connection con) throws SQLException {
        System.out.println("\n--- LISTA DE ESTÁDIOS ---");
        HashSet<EstadioBean> all = EstadioModel.listAll(con);
        Iterator<EstadioBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void deleteEstadio(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- REMOVER ESTÁDIO ---");
        System.out.print("Digite o ID do Estádio que deseja remover: ");
        
        try {
            int id = Integer.parseInt(input.nextLine().trim());
            EstadioModel.delete(id, con);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido. Digite apenas números.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: O estádio está sendo usado em algum Jogo cadastrado!");
        }
    }
}