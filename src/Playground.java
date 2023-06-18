import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import model.contato.ContatoVO;
import model.contato.dao.ContatoDAO;
import services.ContatoService;

public class Playground {
    public static void main(String[] args) {
       String url = "jdbc:mariadb://localhost:3306/fatec";
       String user = "root";
       String passwd = "";
        

        try {
            Connection connection = DriverManager.getConnection(url, user, passwd);

            ContatoDAO contatoDAO = new ContatoDAO(connection);
            ContatoService contatoService = new ContatoService(contatoDAO);

            ContatoVO contato1 = new ContatoVO();
            contato1.setNome("Felipe");
            contato1.setEmail("felipe@felipe.com");

            ContatoVO contato2 = new ContatoVO();
            contato2.setNome("Mateus Favetta");
            contato2.setEmail("mateus@mateus.com");

            ContatoVO contato3 = new ContatoVO();
            contato3.setNome("Leandro");
            contato3.setEmail("leandro@leandro.com");

            contatoService.salvar(contato1);
            contatoService.salvar(contato2);
            contatoService.salvar(contato3);

            ContatoVO contatoEncontrado = contatoService.buscarPorEmail("FelipeMateusLeandro@FelipeMateusLeandro.com");
            if (contatoEncontrado != null) {
                System.out.println("Contato encontrado: " + contatoEncontrado.getNome());
            } else {
                System.out.println("Contato não encontrado.");
            }

            contatoEncontrado.setNome("FelipeMateusLeandro VieiraFavettaAlves");
            contatoService.atualizar(contatoEncontrado);
            System.out.println("Contato atualizado com sucesso.");

            List<ContatoVO> contatos = contatoService.buscarTodos();
            for (ContatoVO contato : contatos) {
                System.out.println("Nome: " + contato.getNome() + ", Email: " + contato.getEmail());
            }

            contatoService.excluir(contatoEncontrado.getId());
            System.out.println("Contato excluído com sucesso.");
        } catch (Exception e) {
            System.out.println("Infelimente ocorreu o seguinte problema: " + e.getLocalizedMessage());
        }
    }
}











































































































































// Felipe Vieira, Leandro Alves e Mateus Favetta
