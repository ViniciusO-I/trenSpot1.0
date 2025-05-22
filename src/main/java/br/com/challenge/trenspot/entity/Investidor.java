package br.com.challenge.trenspot.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "investidor")
public class Investidor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_investidor")
    @SequenceGenerator(name = "seq_investidor", sequenceName = "SEQ_INVESTIDOR", allocationSize = 1)
    @Column(name = "IDINVESTIDOR", nullable = false)
    private Long id;

    @Column(name = "NOMEEMPRESA", nullable = false, length = 100)
    public String nomeEmpresa;

    @Column(name = "EMAIL", nullable = false, length = 255)
    public String email;

    @Column(name = "QUANTIDADE", nullable = false)
    public Double quantidade;

    @Column(name = "NOME", length = 255)
    public String nome;

    @Column(name = "VALORINVESTIDO")
    public Double valorInvestido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
}
