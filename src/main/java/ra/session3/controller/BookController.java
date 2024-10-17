package ra.session3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.session3.model.dto.request.FormBookAdd;
import ra.session3.model.entity.Book;
import ra.session3.service.IBookService;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @GetMapping()
    public String list(@RequestParam("search") Optional<String> search, Pageable pageable, Model model){
        Page<Book> books;
        if(search.isPresent()){
            books = bookService.findAllByNameContainingOrCategoryNameContaining(search.get(),search.get(),pageable);
        }else {
            books = bookService.findAll(pageable);
        }
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/delete/{idDelete}")
    public String handleDelete(@PathVariable Long idDelete){
        bookService.remove(idDelete);
        return "redirect:/book";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("book",new FormBookAdd());
        return "addBook";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute FormBookAdd request){
        bookService.save(request);
        return "redirect:/book";
    }

    @GetMapping("/edit/{idEdit}")
    public String showFormEdit(@PathVariable Long idEdit, Model model){
       Optional<Book> optionalBook = bookService.findById(idEdit);
       if(optionalBook.isPresent()){
           model.addAttribute("book",optionalBook.get());
           return "editBook";
       }else {
           return "404";
       }
    }
    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute Book request){
        bookService.update(request);
        return "redirect:/book";
    }
}
