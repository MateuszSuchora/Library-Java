package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.Autor;

import java.util.List;

import ovh.devnote.ksiegarnia.entity.Autor;
import ovh.devnote.ksiegarnia.entity.Kategoria;

import java.util.List;

public interface AuthorDAO {
    public   void deleteAutor(int id);
    public Autor getAutor(int id);
    public List<Autor> getAutors();
    public  void saveAutor(Autor autor);
}
