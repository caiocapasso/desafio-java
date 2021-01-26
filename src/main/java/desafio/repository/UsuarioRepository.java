package desafio.repository;

import desafio.model.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class UsuarioRepository extends RepositorioGenerico<Usuario> {

	public boolean exists(String login) {
		Query query = em.createQuery("SELECT u From Usuario u where u.login = :login"); //JPQL
		query.setParameter("login", login);
		return query.getResultList().size() != 0;
	}

	public Usuario buscarByLogin(String login) {
		Query query = em.createQuery("SELECT u From Usuario u where u.login = :login"); //JPQL
		query.setParameter("login", login);
		Usuario u;

		try {
			u = (Usuario) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nre) {
			u = null;
		}

		return u;
	}

}
