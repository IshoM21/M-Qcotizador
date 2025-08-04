package com.mq.presentation.controller;

import com.mq.persistence.entity.Cliente;
import com.mq.presentation.dto.ClienteDTO;
import com.mq.presentation.dto.NewClienteDTO;
import com.mq.service.exception.ClienteException;
import com.mq.service.implementation.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("Servicio en linea");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .id(cliente.getId())
                    .razonSocial(cliente.getRazonSocial())
                    .telefono(cliente.getTelefono())
                    .build();
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ClienteDTO> clienteDTOList = clienteService.findAll()
                .stream()
                .map(cliente -> ClienteDTO.builder()
                        .id(cliente.getId())
                        .razonSocial(cliente.getRazonSocial())
                        .telefono(cliente.getTelefono())
                        .build()
                ).toList();
        return ResponseEntity.ok(clienteDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody NewClienteDTO newClienteDTO) throws URISyntaxException {
        try{

        if(newClienteDTO.getRazonSocial().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.save(Cliente.builder()
                .razonSocial(newClienteDTO.getRazonSocial())
                .rfc(newClienteDTO.getRfc())
                .telefono(newClienteDTO.getTelefono())
                .email(newClienteDTO.getEmail())
                .complemento(newClienteDTO.getComplemento())
                .estadoTimbrado(newClienteDTO.getEstadoTimbrado())
                .build());
        return ResponseEntity.created(new URI("/api/client/save")).build();
        }catch(ClienteException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody NewClienteDTO newClienteDTO) throws URISyntaxException {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setRazonSocial(newClienteDTO.getRazonSocial());
            cliente.setRfc(newClienteDTO.getRfc());
            cliente.setTelefono(newClienteDTO.getTelefono());
            cliente.setEmail(newClienteDTO.getEmail());
            cliente.setComplemento(newClienteDTO.getComplemento());
            cliente.setEstadoTimbrado(newClienteDTO.getEstadoTimbrado());
            clienteService.save(cliente);
            return ResponseEntity.ok("Cliente actualizado correctamente");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(id != null){
            clienteService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
