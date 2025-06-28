package com.grupo11.cloud_ventas_producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.grupo11.cloud_ventas_producer.model.Carro;
import com.grupo11.cloud_ventas_producer.model.Producto;
import com.grupo11.cloud_ventas_producer.service.CarroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carro")
    public List<Carro> getCarroAll() {
        return carroService.getAllCarros();
    }

    @GetMapping("/carro/{id}")
    public List<Carro> getCarro(@PathVariable String id) {
        return carroService.getCarroByUsuarioId(id);
    }

    @PostMapping("/carro")
    public Carro sendMessageProducto(@RequestBody Carro carro) {
        carroService.sendCarroToQueue(carro);
        return carro;
    }

}
