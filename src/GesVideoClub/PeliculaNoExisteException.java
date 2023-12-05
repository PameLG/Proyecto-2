/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GesVideoClub;

/**
 *
 * @author urbin
 */
public class PeliculaNoExisteException extends Exception {
    public PeliculaNoExisteException(){
        super("La pelicula no existe");
    }
            
    
}
