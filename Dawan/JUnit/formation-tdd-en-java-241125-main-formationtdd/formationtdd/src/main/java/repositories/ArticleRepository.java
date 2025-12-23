package repositories;

import beans.Article;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    private static Map<Long, Article> dataDb=new HashMap<>();
    private long nextId = 6L;

    static{
        dataDb.put(1L, new Article(1L,"Souris USB",19.9, LocalDate.of(2020,1,1)));
        dataDb.put(2L, new Article(2L,"Clavier Azerty",9.9, LocalDate.of(2022,5,12)));
        dataDb.put(3L, new Article(3L,"Cable HDMI",9.9, LocalDate.of(2023,4,2)));
        dataDb.put(4L, new Article(4L,"Alimentation 130w Dell",80.0, LocalDate.of(2024,1,30)));
        dataDb.put(5L, new Article(5L,"Câble RJ45",15.9, LocalDate.of(2024,6,25)));
    }

    public Article save(Article a){
        if(a.getId() == 0){
            a.setId(nextId);
            dataDb.put(nextId, a);
            return dataDb.get(nextId++);
        }else{
            dataDb.put(a.getId(), a);
            return dataDb.get(a.getId());
        }
    }

    public void remove(long id) throws Exception{
        if(!dataDb.containsKey(id)){
            throw new Exception();
        }
        dataDb.remove(id);
    }

    public void remove(Article a){
        dataDb.remove(a.getId());
    }

    public Article findById(long id) throws Exception{
        Article a = dataDb.get(id);
        if(a == null){
            throw new Exception();
        }
        return a;
    }

    public List<Article> findAll() throws Exception{
        return dataDb.values().stream().toList();
    }

    public List<Article> findByPrix(double prix){
        return dataDb.values().stream().filter(a->a.getPrix() == prix).toList();
    }

    public static Article tool(){
        return new Article();
    }


}
