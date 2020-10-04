package com.example.ac1.services;

import com.example.ac1.models.IdConflict;
import com.example.ac1.models.Pedido;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PedidoService {

    private List<Pedido> pedidos;

    public PedidoService() { }

    public void cadastrarPedido (Pedido pedido) throws IdConflict {
        if (pedidos == null) {
            pedidos = Arrays.asList (pedido);
        }
        else {
            if (!validateCode (pedido.codigo)) {
                throw new IdConflict ();
            }
            pedidos.add (pedido);
        }
    }

    //#region Utils

    public boolean validateCode(int codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.codigo == codigo)
                return false;
        }
        return true;
    }

    //#endregion
}
