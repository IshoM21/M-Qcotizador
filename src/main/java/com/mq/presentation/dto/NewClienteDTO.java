package com.mq.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewClienteDTO {
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String email;
    private String complemento;
    private int estadoTimbrado;

}
