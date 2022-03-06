import java.sql.*;
import java.util.Scanner;

public class FilmeDAO {

    public void inserir() throws SQLException {
        Scanner scan = new Scanner(System.in);
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_filmes?useTimezone=trueserverTimezone=UTC", "root", "root123");

        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.getConnection();

        Statement stm = con.createStatement();


        stm.execute("DROP TABLE IF EXISTS FILME");
        stm.execute("CREATE TABLE FILME (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), ano YEAR, PRIMARY KEY (id)) Engine = InnoDB;");

        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('A 100 Passos de Um Sonho', 'Drama', '2014')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O Diabo Veste Prada', 'Comédia', '2006')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('A Sogra', 'Comédia', '2005')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('A Chegada', 'Ficção Científica', '2016')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Interestelar', 'Ficção Científica', '2014')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('A Lista de Schindler', 'Histórico', '1993')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('A Forma da Água', 'Fantasia', '2018')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Um Sonho Possível', 'Drama', '2010')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('À Procura da Felicidade', 'Drama', '2007')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O Encantador de Cavalos', 'Drama', '1990')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Hidalgo', 'Ação','2021')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Hacker', 'Ação', '2015')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Perdido em Marte', 'Ficção Científica', '2015')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O Resgate do Soldado Ryan', 'Guerra', '1998')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Plano B', 'Comédia', '2010')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Melhor é Impossível', 'Comédia', '1998')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('007 Contra Spectre','Ação', '2015')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O Exótico Hotel Marigold', 'Comédia', '2012')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O Protetor', 'Ação' , '2014')");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Sonho de Liberdade', 'Drama', '1995')");





    }


    public void listar() throws SQLException {
        inserir();
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.getConnection();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a página que você quer ver:");
        int pagina = scan.nextInt();
        System.out.println("Você está na página: " + pagina);
        System.out.println("Usuário, por favor, digite a quantidade de filmes:");
        int limit = scan.nextInt();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM FILME LIMIT ?");
        ps.setInt(1, limit);
        ps.execute();
        try (
                ResultSet rst = ps.getResultSet()) {


            while (rst.next()) {
                Integer id = rst.getInt("ID");
                System.out.println("id:" + id);
                String nome = rst.getString("NOME");
                System.out.println("Nome: " + nome);
                String descricao = rst.getString("DESCRICAO");
                System.out.println("Descrição: " + descricao);
                int ano = rst.getInt("ANO");
                System.out.println("ano: " + ano);
                System.out.println("******************");
            }


        }
    }
    public void paginacao() throws SQLException{
        inserir();

        System.out.println("Quantos filmes você quer ver em cada página: ");
        Scanner scan = new Scanner(System.in);
        float quantidadeDeFilmesPorPagina = scan.nextInt();
        int quantidadeDeFilmes = 20;
        double quantidadeDePaginasDisponiveis = Math.round(quantidadeDeFilmes / quantidadeDeFilmesPorPagina);
        System.out.println("Digite a página que você quer ver: ");
        int PaginaVisualizada = scan.nextInt();
        if (PaginaVisualizada < 1 || PaginaVisualizada > quantidadeDePaginasDisponiveis ){
            System.out.println("Digite uma página válida.");

        }


        }



    }



