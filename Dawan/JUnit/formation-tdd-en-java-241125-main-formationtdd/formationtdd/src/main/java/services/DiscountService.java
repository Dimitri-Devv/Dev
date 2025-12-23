package services;

import repositories.ProductRepository;

public class DiscountService {
    private ProductRepository repository;
    public DiscountService(ProductRepository repository) {
        this.repository = repository;
    }

    Product remiser(double remise, long id){
        Product p=repository.findById(id).orElseThrow(() -> new RuntimeException());
        p.setPrix(p.getPrix()-remise);
        return p;
    }
}
