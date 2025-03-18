package dio.api.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_card")
public class Card {
    @Id
    //gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //aceita apenas valores unicos
    @Column(unique = true)
    private String number;
    //precision: quantidade de inteiros, scale: casas decimais
    //name: permite alterar o nome da coluna no banco
    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Number getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
