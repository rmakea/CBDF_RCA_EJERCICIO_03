package com.upiiz.ventas.repository;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.atomic.*;
import com.upiiz.ventas.models.Categoria;
import java.util.*;

@Repository
public class CategoriasRepository {
    //Alamacenar en un listado las categoria: salvar, listas, eliminar
    //Generar de manera unida el id para cada categoria
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    //Agregamos la categoria al listado y la regresamos
    //POST
    public Categoria guardar(Categoria categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //GET - Todas las categorias
    public List<Categoria> obtenerTodas(){
        return categorias;
    }

    //GET - Una categoria
    public Categoria obtenerPorId(Long id){

        //Funcional
        return categorias.stream().filter(categoria -> categoria.getid().equals(id)).findFirst().orElse(null);
    }

    //DELETE
    public void eliminar(Long id){
        categorias.removeIf(Categoria -> Categoria.getid().equals(id));
    }

    //PUT
    public Categoria actualizar(Categoria categoria){
        eliminar(categoria.getid());
        categorias.add(categoria);
        return categoria;
    }
}
