package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.Kategoria;

import java.util.List;

public interface CategoryDAO {

    public Kategoria getCategory(int id);

    public List<Kategoria> getCategories();

    public void saveCategory(Kategoria kategoria);

    public void deleteCategory(int id);

}
