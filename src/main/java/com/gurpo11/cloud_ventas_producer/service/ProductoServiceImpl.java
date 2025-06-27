package com.gurpo11.cloud_ventas_producer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurpo11.cloud_ventas_producer.model.Producto;
import com.gurpo11.cloud_ventas_producer.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.getProductoByProductoId(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    @Override
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setProductoId(id);
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

}