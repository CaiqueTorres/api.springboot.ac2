package com.example.ac1.services;

import com.example.ac1.models.Pedido;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PedidoService {

    private List<Pedido> pedidos;

    public PedidoService() { }

    public void cadastrarPedido (Pedido pedido) {
        if (pedidos == null)
            pedidos = Arrays.asList (pedido);
        else
            pedidos.add (pedido);
    }
}
