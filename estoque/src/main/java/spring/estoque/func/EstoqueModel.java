package spring.estoque.func;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_estoque")
public class EstoqueModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = false)
    private String nome;
    private String marca;
    private int quantidade;
    
    @CreationTimestamp
    private LocalDateTime dataAd;
}
