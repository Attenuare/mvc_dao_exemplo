package services;

import java.util.List;

import model.contato.ContatoVO;

public interface IContatoService {

    void salvar(ContatoVO pContato) throws Exception;

    ContatoVO atualizar(ContatoVO pContato) throws Exception;

    ContatoVO buscarPorEmail(String pEmail) throws Exception;

    ContatoVO buscarPorId(Integer pId) throws Exception;

    List<ContatoVO> buscarTodos() throws Exception;

    void excluir(Integer pId) throws Exception;

}
