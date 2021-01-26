package desafio.repository;

import desafio.utils.ConexaoFactory;

import javax.persistence.EntityManager;

public class RepositorioGenerico<T> {
    protected EntityManager em;
    private Class entidadeGenerica;

    public RepositorioGenerico() {
        this.em = ConexaoFactory.getConexao();
    }

    public void incluir(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public <T> T buscar(Integer id) {
        return (T) em.find(entidadeGenerica, id);
    }

    public void alterar(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }


    //remover/deletar
}
