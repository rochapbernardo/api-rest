package dio.api.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {
    @Id
    //gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //aceita apenas valores unicos
    @Column(unique = true)
    private String number;
    //nao permite valores nulos
    @Column(nullable = false)
    private String agency;
    //scale: quantidade de inteiros, precision: casas decimais
    @Column(scale = 13, precision = 2)
    private BigDecimal balance;
    //name: permite alterar o nome da coluna no banco
    @Column(name = "available_limit", scale = 13, precision = 2)
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Number getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
