import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection con = ConexaoBD.conectar();
        
        if (con == null) {
            System.out.println("Erro fatal: Não foi possível conectar ao banco.");
            return;
        }

        int op = 0;
        do {
            op = menu();
            try {
                switch (op) {
                    case 1: 
                        menuInsercao(con);
                        break;
                    case 2: 
                        
                        menuRemocao(con);
                        break;
                    case 3: 
                        
                        new RelatorioController().listarTudo(con); 
                        break;
                    case 4: 
                        new ConsultasEspeciaisController().listarJogosComEstadios(con); 
                        break;
                    case 5: 
                        new ConsultasEspeciaisController().listarEstadiosAcimaDaMedia(con);
                        break;
                }
            } catch(Exception ex) {
                System.out.println("Erro no sistema: " + ex.getMessage());
            }
        } while(op > 0 && op < 6);  
        
        ConexaoBD.desconectar(con);
    }    
    
    private static int menu() {
        System.out.println("\n===========================================");
        System.out.println("  SISTEMA COPA DO MUNDO - MENU PRINCIPAL");
        System.out.println("===========================================");
        System.out.println("1 - Inserir novas tuplas");
        System.out.println("2 - Remover tuplas");
        System.out.println("3 - Listar todas as tuplas de TODAS as tabelas");
        System.out.println("4 - Consultar com Junção (JOIN)");
        System.out.println("5 - Consultar com Subconsulta e Agregação");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void menuInsercao(Connection con) {
        Scanner input = new Scanner(System.in);
        int op = 0;
        
        do {
            System.out.println("\n--- ONDE VOCÊ DESEJA INSERIR? ---");
            System.out.println("1 - Estádio");
            System.out.println("2 - Campeonato");
            System.out.println("3 - Pessoa");
            System.out.println("4 - Fisioterapeuta");
            System.out.println("5 - Jogador");
            System.out.println("6 - Jogo");
            System.out.println("7 - Lesão");
            System.out.println("8 - Consulta");
            System.out.println("9 - Disputa");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Sua opção: ");
            
            try {
                op = Integer.parseInt(input.nextLine());
                switch (op) {
                    case 1: new EstadioController().createEstadio(con); break;
                    case 2: new CampeonatoController().createCampeonato(con); break; // Atualizado!
                    case 3: new PessoaController().createPessoa(con); break;
                    case 4: new FisioterapeutaController().createFisioterapeuta(con); break;
                    case 5: new JogadorController().createJogador(con); break;
                    case 6: new JogoController().createJogo(con); break;
                    case 7: new LesaoController().createLesao(con); break;
                    case 8: new ConsultaController().createConsulta(con); break;
                    case 9: new DisputaController().createDisputa(con); break;
                    case 0: System.out.println("Voltando ao Menu Principal..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Digite apenas o número correspondente ao menu.");
            } catch (SQLException e) {
                System.out.println("\n[ERRO DO BANCO] " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERRO DE FORMATO] A data foi digitada no formato errado. Lembre-se de usar AAAA-MM-DD (Ex: 1995-12-25).");
            } catch (Exception e) {
                System.out.println("\n[ERRO FATAL] O Leitor do console quebrou. Abortando submenu...");
                op = 0; // Isso força o submenu a sair sem criar o loop infinito
            }
        } while (op != 0);
    }

    private static void menuRemocao(Connection con) {
        Scanner input = new Scanner(System.in);
        int op = -1;
        
        do {
            System.out.println("\n--- DE QUAL TABELA VOCÊ DESEJA REMOVER? ---");
            System.out.println("1 - Estádio");
            System.out.println("2 - Campeonato");
            System.out.println("3 - Pessoa");
            System.out.println("4 - Fisioterapeuta");
            System.out.println("5 - Jogador");
            System.out.println("6 - Jogo");
            System.out.println("7 - Lesão");
            System.out.println("8 - Consulta");
            System.out.println("9 - Disputa");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Sua opção: ");
            
            try {
                op = Integer.parseInt(input.nextLine().trim());
                switch (op) {
                    case 1: new EstadioController().deleteEstadio(con); break;
                    case 2: new CampeonatoController().deleteCampeonato(con); break;
                    case 3: new PessoaController().deletePessoa(con); break;
                    case 4: new FisioterapeutaController().deleteFisioterapeuta(con); break;
                    case 5: new JogadorController().deleteJogador(con); break;
                    case 6: new JogoController().deleteJogo(con); break;
                    case 7: new LesaoController().deleteLesao(con); break;
                    case 8: new ConsultaController().deleteConsulta(con); break;
                    case 9: new DisputaController().deleteDisputa(con); break;
                    case 0: System.out.println("Voltando ao Menu Principal..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Digite apenas o número correspondente.");
            } catch (Exception e) {
                System.out.println("\n[ERRO] Ocorreu um problema ao tentar remover.");
                op = 0; 
            }
        } while (op != 0);
    }
}

    
