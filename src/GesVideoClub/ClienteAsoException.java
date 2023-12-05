
package GesVideoClub;

public class ClienteAsoException extends Exception{
    public ClienteAsoException(){
     super("Ocurrio un error no se puede eliminar porque el cliente se encuentra Asociado a un Prestamo");
    }    
}
