package modern.challenge.service;

import org.springframework.stereotype.Service;

import modern.challenge.record.BestSellerConfig;

@Service
public class BookstoreService {

    private final BestSellerConfig bestSeller;

    public BookstoreService(BestSellerConfig bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String fetchBestSeller() {

        return bestSeller.author() + " | " + bestSeller.book();
    }
}
