package GesVideoClub;

import java.util.ArrayList;

public class Categoria {

    private String codigo;
    private String nombre;

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

    public Categoria(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public static void agregarCategoria(ArrayList<Categoria> categorias, Categoria categoria) throws FaltaDaException, InfoDuplicadaException {
        if (categoria == null || categoria.getCodigo() == null || categoria.getNombre() == null) {
            throw new FaltaDaException();
        }

        for (Categoria exisCategoria : categorias) {
            if (exisCategoria.getNombre().equals(categoria.getNombre())) {
                throw new InfoDuplicadaException();
            }
        }

        categorias.add(categoria);
    }

    public static Categoria buscarCategoria(ArrayList<Categoria> categorias, String codigo) {
        for (Categoria categoria : categorias) {
            if (categoria.getCodigo().equals(codigo)) {
                return categoria;
            }
        }
        return null;
    }

    public static void actualizarCategoria(ArrayList<Categoria> categorias, Categoria categoria, ArrayList<Pelicula> peliculas) throws CategoriaUsoException {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getCodigo().equals(categoria.getCodigo())) {
                if (categoriaUso(categoria, peliculas)) {
                    throw new CategoriaUsoException();
                }
                categorias.set(i, categoria);
                return;
            }
        }
    }

    public static void eliminarCategoria(ArrayList<Categoria> categorias, String codigo, ArrayList<Pelicula> peliculas) throws CategoriaUsoException {
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            if (categoria.getCodigo().equals(codigo)) {
                if (categoriaUso(categoria, peliculas)) {
                    throw new CategoriaUsoException();
                }

                categorias.remove(i);
                break;
            }
        }
    }

    private static boolean categoriaUso(Categoria categoria, ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCategoria().equals(categoria)) {
                return true;
            }
        }
        return false;
    }
}
