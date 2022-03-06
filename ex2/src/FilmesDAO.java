import java.sql.*;
import java.util.Scanner;

public class FilmesDAO {

    Scanner sc = new Scanner(System.in);

    ConnectionFactory factory = new ConnectionFactory();
    Connection con = factory.getConnection();

    public FilmesDAO() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lista_filmes?useTimezone=true&serverTimezone=UTC", "root", "root");
    }

    public void listaCompleta() throws SQLException {

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM FILMES");
        pstm.execute();

        ResultSet rst = pstm.getResultSet();

        while (rst.next()) {
            int id = rst.getInt("ID");
            System.out.println("id: " + id);

            String nome = rst.getString("NOME");
            System.out.println("Nome: " + nome);

            String descricao = rst.getString("DESCRICAO");
            System.out.println("Descrição: " + descricao);

            int ano = rst.getInt("ANO");
            System.out.println("ano: " + ano);

            System.out.println("");
        }
    }

    public void filtro() throws SQLException {

        //PARAMETROS INICIAIS

        int numeroDeFilmes = 20;
        int numeroDeFilmesPorPagina;

        System.out.println("Digite o número de filmes por paginas desejadas (Limite de 20 filmes): ");
        numeroDeFilmesPorPagina = sc.nextInt();
        System.out.println("");

        System.out.println("Digite o número da página que deseja acessar: ");
        int paginaAcessada = sc.nextInt();

        double PaginasDisponiveis = Math.ceil(numeroDeFilmes / (float) numeroDeFilmesPorPagina);

        //----------------------------------------------------------------------------------------------------------------------
        //      TAVA FICANDO PERDIDO ENTÃO DIVIDI PRA VER MELHOR

        int contador = 1;
        int limiteInicio = 0;
        int limiteFim = 0;

    if(numeroDeFilmesPorPagina < 1 || numeroDeFilmesPorPagina >20) {
        System.out.println("");
        System.out.println("Quantidade de filmes por paginas inaceitavel, nós possuimos apenas "+ numeroDeFilmes +" filmes!");
        System.out.println("Tente novamente!");
        System.out.println("");
    } else{
            if (paginaAcessada < 1 || paginaAcessada > PaginasDisponiveis) {
                System.out.println("");
                System.out.println("\nPágina não existe!");
                System.out.println("Página " + paginaAcessada + " inexistente. Quantidade de páginas possíveis para acessar: " + PaginasDisponiveis + ".");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Você está na página: " + paginaAcessada + "/" + PaginasDisponiveis);
                System.out.println("");

                while (contador <= PaginasDisponiveis) {
                    if (paginaAcessada == contador) {

                        limiteInicio =  ((numeroDeFilmesPorPagina * contador) - numeroDeFilmesPorPagina);
                        limiteFim =  numeroDeFilmesPorPagina;
                        break;
                    }
                    contador++;
                }

                PreparedStatement pstm = con.prepareStatement("SELECT * FROM FILMES LIMIT ?, ?");
                pstm.setInt(1, limiteInicio);
                pstm.setInt(2, limiteFim);
                pstm.execute();

                ResultSet prst = pstm.getResultSet();

                while (prst.next()) {
                    int id = prst.getInt("ID");
                    System.out.println(" Id: " + id);

                    String nome = prst.getString("NOME");
                    System.out.println(" Nome: " + nome);

                    String descricao = prst.getString("DESCRICAO");
                    System.out.println(" Descricao: " + descricao);

                    int ano = prst.getInt("ANO");
                    System.out.println(" Ano: " + ano);
                    System.out.println("");
                }
            }
        }
    }

        public void Inserir () throws SQLException {

            Statement stm = con.createStatement();

            stm.execute("DROP TABLE IF EXISTS FILMES");
            stm.execute("CREATE TABLE FILMES (ID INT AUTO_INCREMENT, NOME VARCHAR(50), DESCRICAO VARCHAR(255), ANO INT, PRIMARY KEY (ID)) Engine = InnoDB;");

            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('DEATH TO 2020', 'HUMOR SECO', 2020 )");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('BALA PERDIDA', 'AÇÃO', 2020)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('THE OLD GUARD', 'AÇÃO E REALISMO', 2020)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('MENTIRAS PERIGOSAS', 'SINISTRO E SUSPENSE NO AR', 2020)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('ZONA DE COMBATE', 'SUSPENSE E AÇÃO', 2020)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('SAN ANDREAS', 'ADRENALINA E AÇÃO', 2015)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('CANVAS', 'DRAMA', 2015)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('UM DIA DIFÍCIL', 'SUSPENSE AÇÃO', 2015)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('O REGRESSO', 'REALISTA E AÇÃO', 2015)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('HACKER', 'SUSPENSE', 2015)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('TEMPESTADE: PLANETA EM FÚRIA', 'AÇÃO E SUSPENSE', 2010)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('A EPIDEMIA', 'VIOLÊNCIA', 2010)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('O IMBATÍVEL 3', 'AÇÃO E VIOLÊNCIA', 2010 )");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('A REDE SOCIAL', 'DRAMA E FICÇÃO HISTÓRICA', 2010)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('AVALON HIGH', 'FANTASIA E AVENTURA', 2010)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('COACH CARTER - TREINO PARA A VIDA', 'ESPORTE E DRAMA', 2005)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('CÃO DE BRIGA', 'AÇÃO E DRAMA', 2005)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('BATMAN BEGINS', 'AÇÃO E FANTASIA', 2005)");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('OS IRMÃOS GRIMM', 'AÇÃO E FANTASIA', 2005 )");
            stm.execute("INSERT INTO FILMES (NOME, DESCRICAO, ANO) VALUES ('O SENHOR DAS ARMAS', 'GUERRA E DRAMA', 2005 )");

        }

}

