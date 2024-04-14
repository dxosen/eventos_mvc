package br.com.fiap.produtomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome","data","url","cidade"})

@Entity
@Table(name = "tb_evento")
public class Evento {

    //GABRIEL DARIO RM95946

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String data;

    @NotBlank(message = "Campo requerido")
    @Column(columnDefinition = "TEXT") //para textos longos
    private String url;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false) //PK
    private Cidade cidade;

}
