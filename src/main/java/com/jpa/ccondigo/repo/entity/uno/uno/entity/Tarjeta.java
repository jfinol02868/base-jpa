package com.jpa.ccondigo.repo.entity.uno.uno.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@With
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "socio")
@Table(name = "tarjetas")
public class Tarjeta {

    @Id
    private int numero;
    private Date caducidad;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "socio_dni")
    private Socio socio;
}
