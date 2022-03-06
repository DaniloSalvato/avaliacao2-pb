import java.sql.*;
import java.util.Scanner;

public class ProdutoDAO {
    //Globaliza as conexões
    Connection connection;
    ConnectionFactory factory = new ConnectionFactory();
    Connection con = factory.getConnection();

    Scanner sc = new Scanner(System.in);

    //Faz login no banco de dados
    public ProdutoDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_sprint2?useTimezone=true&serverTimezone=UTC", "root", "root");
    }


    public void Inserir() throws SQLException {

        sc.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();

        //INSERE UM NOVO ITEM E CRIA UM ID
        PreparedStatement pstm = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, QUANTIDADE) VALUES ( ?, ?, ?, ?)");
        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.setDouble(3, preco);
        pstm.setInt(4, quantidade);
        pstm.execute();

    }

    public void Listar() throws SQLException{

        PreparedStatement pstm = con.prepareStatement("SELECT ID, NOME, DESCRICAO, PRECO, QUANTIDADE  FROM PRODUTO");
        pstm.execute();

        ResultSet rst = pstm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println("id: " + id);

            String nome = rst.getString("NOME");
            System.out.println("Nome: " + nome);

            String descricao = rst.getString("DESCRICAO");
            System.out.println("Descrição: " + descricao);

            String preco = rst.getString("PRECO");
            System.out.println("Preço: " + preco);

            String quantidade = rst.getString("QUANTIDADE");
            System.out.println("Quantidade: " + quantidade);
            System.out.println("");
        }

    }

    public void Atualizar() throws SQLException{

        //Vai atualizar toda a linha.
        System.out.println("Digite o ID que deseja atualizar: ");
        int idAtt = sc.nextInt();

        System.out.println("Digite o nome do produto: ");
        sc.nextLine();// corrigi o bug do enter
        String nome = sc.nextLine();


        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();

        PreparedStatement pstm = con.prepareStatement("UPDATE PRODUTO SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE ID = ?" );
        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.setDouble(3, preco);
        pstm.setInt(4, quantidade);
        pstm.setInt(5, idAtt);
        pstm.execute();
    }

    public void Remover() throws SQLException {

        System.out.println("Digite o ID que deseja remover: ");
        int idDel = sc.nextInt();

        PreparedStatement pstm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
        pstm.setInt(1, idDel);
        pstm.execute();

        Integer itemRemovido = pstm.getUpdateCount();
        System.out.println(itemRemovido + " item removido");
    }

    public void ZerarTabela() throws SQLException {
        Statement stm = con.createStatement();
        stm.execute("DROP TABLE IF EXISTS PRODUTO");
        stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50), descricao VARCHAR(255), quantidade INT, preco FLOAT, PRIMARY KEY (id)) Engine = InnoDB;");

    }
}