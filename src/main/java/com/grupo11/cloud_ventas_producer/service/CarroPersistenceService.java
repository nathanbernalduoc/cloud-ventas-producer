package com.grupo11.cloud_ventas_producer.service;

import org.springframework.stereotype.Service;

import com.grupo11.cloud_ventas_producer.model.Carro;
import com.grupo11.cloud_ventas_producer.repository.CarroRepository;

@Service
public class CarroPersistenceService {

    private CarroRepository carroRepository;

    public CarroPersistenceService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro saveCarro(String content) {
        Carro carro = new Carro();
        return carroRepository.save(carro);
    }

} 