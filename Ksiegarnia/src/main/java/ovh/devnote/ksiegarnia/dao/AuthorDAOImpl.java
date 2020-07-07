package ovh.devnote.ksiegarnia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.ksiegarnia.entity.Autor;

import java.util.List;

@Repository
public class AuthorDAOImpl  implements  AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteAutor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("delete from Autor where id=:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public Autor getAutor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Autor>query= currentSession.createQuery("from Autor  where  id=:id", Autor.class)
                .setParameter("id",id);
        return  query.getSingleResult();
    }

    @Override
    public List<Autor> getAutors() {
        Session curremtSession= sessionFactory.getCurrentSession();
        Query<Autor> query= curremtSession.createQuery("from Autor ", Autor.class);
        List<Autor>autors=query.getResultList();
        return  autors;
    }


    @Override
    public void saveAutor(Autor autor) {
        Session session= sessionFactory.getCurrentSession();
        session.save(autor);
    }
}
