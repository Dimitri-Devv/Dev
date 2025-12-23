package beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Article  implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String description;

    private double prix;

    private LocalDate dateProduction;

    public Article(){

    }

    public Article(long id, String description, double prix, LocalDate dateProduction) {
        this.id = id;
        this.description = description;
        this.prix = prix;
        this.dateProduction = dateProduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(LocalDate dateProduction) {
        this.dateProduction = dateProduction;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", dateProduction=" + dateProduction +
                '}';
    }
}