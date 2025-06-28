package com.grupo11.cloud_ventas_producer.service;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.grupo11.cloud_ventas_producer.config.RabbitMQConfig;
import com.grupo11.cloud_ventas_producer.model.Carro;
import com.grupo11.cloud_ventas_producer.model.Producto;

@Component
public class CarroConsumerService {

    @Autowired
    private CarroService carroService;
    @Autowired
    private ProductoService productoService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SALES)
    public void receiveMessage(Carro carro) {
        carroService.createCarro(carro);

        Optional<Producto> productoItem = productoService.getProductoById(carro.getProductoId());
        if (productoItem.isPresent()) {

            Producto producto = productoItem.get();
            Long stock = producto.getStockActual() - carro.getCantidad();
            producto.setStockActual(stock);
            productoService.updateProducto(carro.getProductoId(), producto);

        } else {

            System.out.println("Producto no encontrado para el ID: " + carro.getProductoId());

        }
        
        System.out.println("Mensaje guardado: " + carro.toString() );
    }

}
