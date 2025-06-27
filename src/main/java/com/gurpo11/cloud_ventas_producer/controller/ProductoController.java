package com.gurpo11.cloud_ventas_producer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gurpo11.cloud_ventas_producer.model.Producto;
import com.gurpo11.cloud_ventas_producer.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto")
    public List<Producto> getProductosAll() {
        return productoService.getAllProductos();
    }
    
    @GetMapping("/producto/{id}")
    public Optional<Producto> getProducto(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

}
