package ovh.devnote.ksiegarnia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.ksiegarnia.dao.AuthorDAO;
import ovh.devnote.ksiegarnia.entity.Autor;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AuthorServiceImpl  implements  AuthorService{
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Autor> getAutors() {
        List<Autor>autor= authorDAO.getAutors();
        return  autor;
    }

    @Transactional
    @Override
    public void deleteAutor(int autorId) { authorDAO.deleteAutor(autorId); }
    @Transactional
    @Override
    public Autor getAutor(int autorId) {
        return authorDAO.getAutor(autorId);
    }

    @Override
    @Transactional
    public void saveAutor(Autor autor) {
        authorDAO.saveAutor(autor);
    }
}
