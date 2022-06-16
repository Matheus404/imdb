package com.ioasys.imdb.model;

import javax.persistence.*;

import com.ioasys.imdb.model.enumerations.Genre;

import lombok.*;

@Entity
@Table(name = "movie")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Movie {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String movieName;
    
    @Column
    private double note;
    
    @Column
    private int voteCount;
    
    @Column
    private double averageGrade;
    
    @Column
    private String author;
    
    @Enumerated(EnumType.STRING)
    private Genre genre;
    
    
    
}
