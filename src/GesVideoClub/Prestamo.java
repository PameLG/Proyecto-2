
package GesVideoClub;

import java.util.ArrayList;


public class Prestamo {
     protected int numero;
    private String estado;
    private String fecha;
    private Cliente cliente;
    private ArrayList<Pelicula> peliculas;
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Prestamo(int numero, String estado, String fecha, Cliente cliente, ArrayList<Pelicula> peliculas) {
        this.numero = numero;
        this.estado = estado;
        this.fecha = fecha;
        this.cliente = cliente;
        this.peliculas = peliculas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void agregarPrestamo(Prestamo prestamo) throws InfoDuplicadaException, FaltaDaException {
        if (prestamo == null || prestamo.getNumero() <= 0 || prestamo.getCliente() == null || prestamo.getPeliculas() == null) {
            throw new FaltaDaException();
        }

        if (buscarPrestamo(prestamo.getNumero()) == null) {
            prestamos.add(prestamo);
        } else {
            throw new InfoDuplicadaException();
        }
    }

    public Prestamo buscarPrestamo(int numero) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getNumero() == numero) {
                return prestamo;
            }
        }
        return null;
    }

    public void actualizarPrestamo(Prestamo prestamo) throws FaltaDaException {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getNumero() == prestamo.getNumero()) {
                prestamos.set(i, prestamo);
                return;
            }
        }
        throw new FaltaDaException();
    }

    public void eliminarPrestamo(int numero) throws FaltaDaException {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getNumero() == numero) {
                prestamos.remove(i);
                return;
            }
        }
        throw new FaltaDaException();
    }

    public void completarPrestamo() {
        this.estado = "completado";
    }

    private boolean peliculaUsoPrestamos(Pelicula pelicula) {
        for (Prestamo otroPrestamo : prestamos) {
            if (otroPrestamo.getEstado().equals("activo") && otroPrestamo.getPeliculas().contains(pelicula)) {
                return true;
            }
        }
        return false;
    }

    private boolean peliculasUso() {
        for (Pelicula pelicula : this.peliculas) {
            if (peliculaUsoPrestamos(pelicula)) {
                return true;
            }
        }
        return false;
    }
}


