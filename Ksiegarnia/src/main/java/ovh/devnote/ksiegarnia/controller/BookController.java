package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Ksiazka;
import ovh.devnote.ksiegarnia.services.AuthorService;
import ovh.devnote.ksiegarnia.services.BookService;
import ovh.devnote.ksiegarnia.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final CategoryService categoryService;

    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService,AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String listBooks(Model model){
        List<Ksiazka> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }

    @GetMapping("/formadd")
    public String addForm(Model model) {
        Ksiazka book = new Ksiazka();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("autor", authorService.getAutors());
        return "addbookform";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Ksiazka ksiazka) {
        bookService.saveBook(ksiazka);
        return "redirect:/books/list";
    }

    @GetMapping("/updateBookForm")
    public String updateBookForm(@RequestParam("bookId") int bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("autor", authorService.getAutors());
        return "addbookform";
    }

    @GetMapping("/deleteBookForm")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/list";
    }


}