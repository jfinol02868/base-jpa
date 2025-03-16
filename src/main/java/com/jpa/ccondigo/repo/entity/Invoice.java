package com.jpa.ccondigo.repo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idClient;
    private String description;
    private Long total;
    @ManyToOne // En muchas facturas puede tener el mismo cliente
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Para que no se cree una relación circular
    // Para estos casos el joinColumn es opcional, pero se puede usar para especificar el nombre de la columna que hace referencia a la tabla de la relación
    //@JoinColumn(name = "client_id") // Para espeficicar el nombre de la columna que hace referencia a la tabla de la relación
    private Client client;
}


