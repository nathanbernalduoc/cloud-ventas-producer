package com.grupo11.cloud_ventas_producer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.grupo11.cloud_ventas_producer.config.RabbitMQConfig;
import com.grupo11.cloud_ventas_producer.model.Producto;

@Component
public class ProductoConsumerService {

    @Autowired
    private ProductoService productoService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PRODUCTS)
    public void receiveMessage(Producto producto) {
        productoService.createProducto(producto);
        System.out.println("Mensaje guardado: " + producto.toString() );
    }

}
