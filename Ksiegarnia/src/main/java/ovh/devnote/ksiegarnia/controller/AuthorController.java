package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Autor;
import ovh.devnote.ksiegarnia.services.AuthorService;
import ovh.devnote.ksiegarnia.services.CategoryService;


import java.util.List;

@Controller
@RequestMapping("/autors")
public class AuthorController {
    @Autowired
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public AuthorController(AuthorService authorService,CategoryService categoryService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @GetMapping("/list")
    public  String listAutors(Model model){
        List<Autor>authors= authorService.getAutors();
        model.addAttribute("autors",authors);
        return "autorslist";

    }

    @GetMapping("/formadd")
    public String addForm(Model model) {
        Autor autor= new Autor();
        model.addAttribute("Autor", autor);

        return "addautorform";
    }


    @PostMapping("/saveAutor")
    public String saveAutor(@ModelAttribute("autor")  Autor autor)
    {
        authorService.saveAutor(autor);
        return "redirect:/autors/list";
    }

    @GetMapping("/updateAutorForm")
    public String updateAutorForm(@RequestParam("autorId") int autorId, Model model) {
        model.addAttribute("autor", authorService.getAutor(autorId));
        return "addautorform";
    }



    @GetMapping("/deleteAutorForm")
    public  String deleteAutor(@RequestParam("autorId") int autorId){
        authorService.deleteAutor(autorId);
        return  "redirect:/autors/list";
    }

}
