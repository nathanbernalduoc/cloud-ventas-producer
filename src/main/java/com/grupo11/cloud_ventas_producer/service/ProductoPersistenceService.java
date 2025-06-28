package com.grupo11.cloud_ventas_producer.service;

import org.springframework.stereotype.Service;
import com.grupo11.cloud_ventas_producer.model.Producto;
import com.grupo11.cloud_ventas_producer.repository.ProductoRepository;

@Service
public class ProductoPersistenceService {

    private ProductoRepository productoRepository;

    public ProductoPersistenceService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto saveProducto(String content) {
        Producto producto = new Producto();
        return productoRepository.save(producto);
    }

} 