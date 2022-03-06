import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        FilmesDAO filmesDAO = new FilmesDAO();

        int opcao = 0;

        while (opcao != 4) {
            opcao = menu();
            switch (opcao) {
                case 1:
                    filmesDAO.listaCompleta();
                    System.out.println("****** Essas são as opções de filmes! ******");
                    System.out.println("--------------------------------------------");
                    break;
                case 2:
                    filmesDAO.filtro();
                    System.out.println("--------------------------------------------");
                    break;
                case 3:
                    filmesDAO.Inserir();
                    System.out.println("--------------------------------------------");
                    break;
                case 4:
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Opcao inválida!\n");
                    System.out.println("--------------------------------------------");
                    break;
            }
        }
    }

    static int menu() {
        int op;
        System.out.println("Menu de opcoes");
        System.out.println("");
        System.out.println("1 - LISTAR");
        System.out.println("2 - FILTRO");
        System.out.println("3 - Resetar tabela");
        System.out.println("4 - Sair");
        System.out.println("");
        System.out.println("Digite sua opcao: ");
        op = sc.nextInt();
        System.out.println("");
        return op;
    }

}
