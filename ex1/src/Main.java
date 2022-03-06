import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ProdutoDAO produtodao = new ProdutoDAO();

        int opcao = 0;

        while (opcao != 6) {
            opcao = menu();
            switch (opcao) {
                case 1:
                    produtodao.Inserir();
                    System.out.println("");
                    //eu tive que corrigir o bug da quebra de linha com mais um next line, então tem que dar dois enter
                    break;
                case 2:
                    produtodao.Listar();
                    System.out.println("");
                    break;
                case 3:
                    produtodao.Atualizar();
                    System.out.println("O item foi atualizado");
                    System.out.println("");
                    break;
                case 4:
                    produtodao.Remover();
                    System.out.println("");
                    break;
                case 5:
                    produtodao.ZerarTabela();
                    System.out.println("Nova tabela iniciada");
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("tchau!");
                    break;
            default:
                System.out.println("Opcao inválida!\n");
                System.out.println("");
                break;
            }
        }
    }

    static int menu() {
        int op;
        System.out.println("Menu de opcoes");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Zerar tabela");
        System.out.println("6 - Sair");
        System.out.println("Digite sua opcao: ");
        op = sc.nextInt();
        System.out.println("");
        System.out.println("");

        return op;
    }

}

