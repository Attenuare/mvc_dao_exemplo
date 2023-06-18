package services;

import java.util.List;
import java.util.logging.Logger;

import model.contato.ContatoVO;
import model.contato.dao.ContatoDAO;
import model.contato.dao.IContatoDAO;

public class ContatoService implements IContatoService {
        
    private ContatoDAO contatoDao;

    final private Logger logger = Logger.getLogger(ContatoService.class.getName());

    private final IContatoDAO dao;

    public ContatoService(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO pContato) throws Exception {
        try {
            dao.salvar(pContato);
            logger.info("Contato salvo com sucesso: " + pContato.getId());

        } catch (Exception e) {
            logger.severe("Erro ao salvar contato: " + e.getMessage());
            throw e;

        }
    }

    @Override
    public ContatoVO atualizar(ContatoVO pContato) throws Exception {
        try{
            Integer id = pContato.getId();
            ContatoVO contato = contatoDao.buscarPorId(id);
            if ( id != null && contato != null){                
                contatoDao.atualizar(contato);                         
            }                
            return contato; 
        } catch (Exception e) {
            logger.severe("Erro ao atualizar contato: " + e.getMessage());
            throw e; 
        }  
    }   

    @Override
    public ContatoVO buscarPorEmail(String pEmail) throws Exception {
      try {
            ContatoVO contato = dao.buscarPorEmail(pEmail);
            if (contato != null) {
                logger.info("Contato encontrado: " + contato.getId());
            } else {
                logger.info("Nenhum contato encontrado para o email: " + pEmail);
            }

            return contato;
        } catch (Exception e) {
            logger.severe("Erro ao buscar contato por email: " + e.getMessage());
            throw e;   
        }
    }

    @Override
    public ContatoVO buscarPorId(Integer pId) throws Exception {        
        try {
            ContatoVO contato = contatoDao.buscarPorId(pId);
            if (contato != null) {
                logger.info("Contato encontrado: " + contato.getId());
            } else {
                logger.info("Nenhum contato encontrado para o ID: " + pId);
            }
            return contato;

        } catch (Exception e) {
            logger.severe("Erro ao buscar contato por ID: " + e.getMessage());
            throw e;
    }
    }

    @Override
    public List<ContatoVO> buscarTodos() throws Exception {
        return contatoDao.buscarTodos();
    }


    @Override
    public void excluir(Integer pId) throws Exception {
        contatoDao.excluir(pId);
    }
}











































































































// Felipe Vieira, Leandro Alves e Mateus Favetta
