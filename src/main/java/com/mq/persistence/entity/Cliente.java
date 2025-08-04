package com.mq.persistence.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;
    @Column(unique = true, nullable = false)
    private String rfc;
    private String telefono;
    private String email;
    private String complemento;
    private int estadoTimbrado;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

}
