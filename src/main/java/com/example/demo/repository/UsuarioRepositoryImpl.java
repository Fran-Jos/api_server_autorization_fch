package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager EntityManager;

    @Override
    public Usuario consultarPorNombre(String nombre) {
        // TODO Auto-generated method stub

        TypedQuery<Usuario> query = EntityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre",
                Usuario.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }

}
