package com.jpa.ccondigo.repo.entity.uno.uno.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@With
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "tarjeta")
@Table(name = "socios")
public class Socio {

    @Id
    private String dni;
    private String nombre;
    private String apellidos;
    @ToString.Exclude
    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Tarjeta tarjeta;
}
