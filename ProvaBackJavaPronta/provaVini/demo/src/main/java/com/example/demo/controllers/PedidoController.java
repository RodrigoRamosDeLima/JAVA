package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.req.CreatePedidoDTO;
import com.example.demo.dtos.res.ShowPedidosDTO;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint para criar um novo pedido
    @PostMapping
    public ResponseEntity<Void> createPedido(@RequestBody CreatePedidoDTO createPedidoDTO) {
        pedidoService.createPedido(createPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna 201 Created
    }

    // Endpoint para listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<ShowPedidosDTO>> getPedidos() {
        List<ShowPedidosDTO> pedidos = pedidoService.getPedidos();
        return ResponseEntity.ok(pedidos);
    }
}
