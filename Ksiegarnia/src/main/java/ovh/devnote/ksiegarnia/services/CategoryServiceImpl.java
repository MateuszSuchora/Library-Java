package ovh.devnote.ksiegarnia.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.ksiegarnia.dao.CategoryDAO;
import ovh.devnote.ksiegarnia.entity.Kategoria;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;
    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    @Override
    @Transactional
    public List<Kategoria> getCategories() {
        return categoryDAO.getCategories();
    }
    @Override
    @Transactional
    public void saveCategory(Kategoria category) {
        categoryDAO.saveCategory(category);
    }
    @Override
    @Transactional
    public Kategoria getCategory(int categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    @Override
    @Transactional
    public void deleteCategory(int categoryId) {
        categoryDAO.deleteCategory(categoryId);
    }
}