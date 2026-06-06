package main;

public class ValidarTextoException extends Exception{
    public static void validarTexto(String texto, String campo) {
        // No puede ser vacío 
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }

        // Excepción 2: No pueden ser números (o contenerlos)
        // Usamos una expresión regular: ".*\\d.*" significa "si contiene cualquier dígito"
        if (texto.matches(".*\\d.*")) {
            throw new IllegalArgumentException(campo + " no puede contener números.");
        }
        
    }
}
