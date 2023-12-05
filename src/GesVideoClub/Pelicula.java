/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GesVideoClub;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author urbin
 */
public class Pelicula {
   private String codigo;
    private String nombre;
    private Categoria categoria;

    public Pelicula(String codigo, String nombre, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public static void agregarPelicula(ArrayList<Pelicula> peliculas, HashMap<String, Pelicula> peliculasCod, Pelicula pelicula) throws InfoDuplicadaException, FaltaDaException {
        if (pelicula == null || pelicula.getCodigo() == null || pelicula.getNombre() == null || pelicula.getCategoria() == null) {
            throw new FaltaDaException();
        }

        if (!peliculasCod.containsKey(pelicula.getCodigo())) {
            peliculas.add(pelicula);
            peliculasCod.put(pelicula.getCodigo(), pelicula);
        } else {
            throw new InfoDuplicadaException();
        }
    }

    public void actualizarPelicula(ArrayList<Pelicula> peliculas, HashMap<String, Pelicula> peliculasCod, Pelicula pelicula) throws FaltaDaException, InfoDuplicadaException {
    if (pelicula == null || pelicula.getCodigo() == null || pelicula.getNombre() == null || pelicula.getCategoria() == null) {
        throw new FaltaDaException();
    }

    Pelicula peliculaAEActualizar = peliculasCod.get(pelicula.getCodigo());
    if (peliculaAEActualizar != null) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getCodigo().equals(pelicula.getCodigo())) {
                peliculas.set(i, pelicula);
                return; 
            }
        }
        throw new InfoDuplicadaException();
    } else {
        throw new InfoDuplicadaException();
    }
}



   public void eliminarPelicula(ArrayList<Pelicula> peliculas, HashMap<String, Pelicula> peliculasCod, Pelicula pelicula) throws FaltaDaException, PeliculaNoExisteException {
    if (pelicula == null || pelicula.getCodigo() == null) {
        throw new FaltaDaException();
    }

    Pelicula peliculaEliminar = peliculasCod.get(pelicula.getCodigo());
    if (peliculaEliminar != null) {
        peliculas.remove(peliculaEliminar);
        peliculasCod.remove(peliculaEliminar.getCodigo());
    } else {
        throw new PeliculaNoExisteException();
    }
}

      public Pelicula buscarPeliculaPorCodigo(HashMap<String, Pelicula> peliculasCod, Pelicula pelicula) {
        return peliculasCod.get(pelicula.getCodigo());
    }
 
}
