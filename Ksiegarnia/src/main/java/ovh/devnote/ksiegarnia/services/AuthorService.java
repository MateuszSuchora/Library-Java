package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.Autor;
import ovh.devnote.ksiegarnia.entity.Ksiazka;

import java.util.List;

public interface AuthorService {
    public   void deleteAutor(int id);
    public Autor getAutor(int id);
    public List<Autor> getAutors();
    public  void saveAutor(Autor autor);
}
