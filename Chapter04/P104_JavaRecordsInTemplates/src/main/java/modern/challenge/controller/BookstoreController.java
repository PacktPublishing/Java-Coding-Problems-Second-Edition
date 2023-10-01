package modern.challenge.controller;

import modern.challenge.service.BookstoreService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/bookstore")
    public String bookstorePage(Model model) {
        
        model.addAttribute("authors", bookstoreService.fetchAuthors());
        
        return "bookstore";
    }

}
