package com.example.ac1.controllers;

import com.example.ac1.models.Pedido;
import com.example.ac1.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cadastrar")
    public void cadastrarPedido (@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);
    }

}
