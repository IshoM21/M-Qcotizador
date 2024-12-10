package com.mq.persistence.entity;


import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;

    @Column(nullable = false)
    private String razonSocial;
    @Column(nullable = false)
    private String rfc;

    private String telefono;
    private String email;
    private String complemento;
    private boolean estadoTimbrado;

}
