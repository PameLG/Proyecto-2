package GesVideoClub;

public class CategoriaUsoException extends Exception {

    public CategoriaUsoException() {
        super("Ocurrio un error no se puede eliminar porque la categoria se encuentra asignada");
    }
}
