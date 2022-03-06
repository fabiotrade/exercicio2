import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        FilmeDAO fd = new FilmeDAO();


        int menu = 0;

        while (menu != 3) {
            System.out.println("Lista de opções");
            System.out.println("1 - Inserir tabela de filmes");
            System.out.println("2 - Digite o número da página e listagem de filmes");
            System.out.println("3 - Sair");
            System.out.println("Digite uma opção");
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                      fd.inserir();
                    System.out.println("Filmes inseridos com sucesso.");
                    break;

                case 2:
                    fd.listar();

                    break;


                case 3:
                    System.out.println("Finalizando programa.");
                    break;

                  //a lógica de paginação não funcionou, dedicarei tempo refazendo durante a semana.
                 //case 4:
                //fd.paginacao();
                //System.out.println("");

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        }
    }




    }
