package services;

import beans.Article;
import repositories.ArticleRepository;

import java.util.List;

public class ArticleService {
    private ArticleRepository repository;
    public ArticleService(ArticleRepository repository){
        this.repository = repository;
    }
    public Article saveOrUpdate(Article article){
        return repository.save(article);
    }

    public void remove(long id) {
        try{
            repository.remove(id);
        }catch(Exception e){
            throw new NotFoundException(e.getMessage());
        }

    }

    public void remove(Article article){
        repository.remove(article);
    }

    public Article getById(long id) {
        try {
            return repository.findById(id);
        }
        catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }
    }

    public List<Article> getAll() throws Exception {
        return repository.findAll();
    }

    public List<Article> getByPrix(double prix) throws Exception {
        return repository.findByPrix(prix);
    }

    public static Article check(){
        return ArticleRepository.tool();
    }
}
