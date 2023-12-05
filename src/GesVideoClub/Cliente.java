package GesVideoClub;

import java.util.ArrayList;
import java.util.HashSet;

public class Cliente {
    
    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private String direccion;

    public Cliente(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarCliente(ArrayList<Cliente> clientes, Cliente cliente) throws FaltaDaException {
        if (cliente == null || cliente.getCedula() == null || cliente.getNombre() == null || cliente.getFechaNacimiento() == null
                || cliente.getTelefono() == null || cliente.getCorreo() == null || cliente.getDireccion() == null) {
            throw new FaltaDaException();
        }
        clientes.add(cliente);
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public void actualizarCliente(ArrayList<Cliente> clientes, Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cliente.getCedula())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public void eliminarCliente(ArrayList<Cliente> clientes, ArrayList<Prestamo> prestamos, String cedula) throws ClienteAsoException {
        if (clienteEnUso(prestamos)) {
            throw new ClienteAsoException();
        }

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cedula)) {
                clientes.remove(i);
                break;
            }
        }
    }

    private boolean clienteEnUso(ArrayList<Prestamo> prestamos) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente().equals(this)) {
                return true;
            }
        }
        return false;
    }

    public void verificarClienteDupli(HashSet<String> clientesDupli) throws InfoDuplicadaException {
        if (clientesDupli.contains(this.getCedula())) {
            throw new InfoDuplicadaException();
        } else {
            clientesDupli.add(this.getCedula());
        }
    }

    public void agregarClienteS(HashSet<String> clientesDupli) {
        clientesDupli.add(this.getCedula());
    }
}
