package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.Kategoria;

import java.util.List;

public interface CategoryService {

    public List<Kategoria> getCategories();
    public void saveCategory(Kategoria category);
    public Kategoria getCategory(int categoryId);
    public void deleteCategory(int categoryId);
}
