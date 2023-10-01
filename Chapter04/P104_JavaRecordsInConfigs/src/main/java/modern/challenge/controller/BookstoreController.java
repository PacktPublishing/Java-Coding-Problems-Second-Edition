package modern.challenge.controller;

import modern.challenge.service.BookstoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors")
    public String fetchBestSeller() {

        return bookstoreService.fetchBestSeller();
    }

}
