package dio.api.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {
    @Id
    //gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //cascade: criar relacao entre as entidades
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    // fetch: ao buscar um usuário no banco sempre retorna toda a lista de features dele
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Feature> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Feature> getNews() {
        return news;
    }

    public void setNews(List<Feature> news) {
        this.news = news;
    }
}
