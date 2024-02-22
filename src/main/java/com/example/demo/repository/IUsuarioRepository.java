package com.example.demo.repository;

import com.example.demo.modelo.Usuario;

public interface IUsuarioRepository {
    
    public Usuario consultarPorNombre(String nombre);
}
