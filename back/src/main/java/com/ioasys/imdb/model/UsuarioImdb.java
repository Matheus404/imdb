package com.ioasys.imdb.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.ioasys.imdb.model.enumerations.Papel;

@Data
@Entity
@Table(name = "usuarioImdb")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UsuarioImdb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String password;

    @ElementCollection(targetClass = Papel.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "papel")
    @Column(name = "papel")
    private List<Papel> papeis;
    

}
