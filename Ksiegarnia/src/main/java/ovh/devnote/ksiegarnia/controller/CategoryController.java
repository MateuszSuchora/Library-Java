package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Kategoria;
import ovh.devnote.ksiegarnia.services.CategoryService;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/list")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categorieslist";
    }

    @GetMapping("/formadd")
    public String addForm(Model model) {
        model.addAttribute("category", new Kategoria());
        return "addcategoryform";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Kategoria category) {
        categoryService.saveCategory(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/updateCategoryForm")
    public String updateCategoryForm(@RequestParam("categoryId") int categoryId, Model model) {
        model.addAttribute("category", categoryService.getCategory(categoryId));
        return "addcategoryform";
    }

   
    @GetMapping("/deleteCategoryForm")
    public String deleteCategory(@RequestParam("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories/list";
    }


}
