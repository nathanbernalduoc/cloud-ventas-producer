package com.gurpo11.cloud_ventas_producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gurpo11.cloud_ventas_producer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
