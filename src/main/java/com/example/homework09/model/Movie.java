package com.example.homework09.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Movie {
    @Id
    @Column(unique = true)
    @Size(min = 3, message = "Length id must be more than 3")
    private String id;
    @NotEmpty(message = "name Cannot be null")
    @Size(min = 2,message = "Length name more than 2")
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    @Pattern(regexp = "(Drama|Action|Comedy)",message = "Can genre only have these values : (Drama, Action , Comedy)")
    private String genre;
    @NotNull(message = "rating cannot be null")
    @Positive
    @Range(min = 1, max = 5, message = "rating must be between 1 - 5")
    private Integer rating;
    @NotNull (message = "duration cannot be null")
    @Positive
    @Min(value = 60)
    private Integer duration;
    @NotEmpty (message = "launch date cannot be null")
    @Pattern(regexp = "(\\d{4})", message = "invalid date")
    private String lunchDate;



}
