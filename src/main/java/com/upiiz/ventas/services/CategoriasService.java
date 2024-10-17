package com.upiiz.ventas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.ventas.models.Categoria;
import com.upiiz.ventas.repository.CategoriasRepository;

//Se crea una instancia de esta clase

@Service
public class CategoriasService {
    // Requerimos el REPO (Datos - Listado) - Categorias

    CategoriasRepository categoriasRepository;
    // Constructor - Cuando crea la instancia le pasa el repositorio
    public CategoriasService(CategoriasRepository categoriasRepository){
        this.categoriasRepository = categoriasRepository;
    }

    // GET - Todas las categorias
    public List<Categoria> getAllCategorias(){
        return  categoriasRepository.obtenerTodas();
    }
    // GET - Categorias por id
    public Categoria getCategoriaById(Long id){
        return categoriasRepository.obtenerPorId(id);
    }

    // POST - Crear categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriasRepository.guardar(categoria);
    }

    // PUT - Axtualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriasRepository.actualizar(categoria);
    }

    // DELETE - Eliminar categoria
    public void deleteCategoria(Long id){
        categoriasRepository.eliminar(id);
    }
}

