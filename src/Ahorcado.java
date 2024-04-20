import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        //Clase Scanner, permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        //Declaraciones y asiganaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 11;
        int intentos = 1;
        boolean palabraAdivinada = false;

        //Array de char
        char [] letrasAdivinadas = new char [palabraSecreta.length()];

        //Bucle
        for(int i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
            //System.out.print(letrasAdivinadas[i]);
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0)); //charAt(0) se asegura que si el usuario escribe mas de una letra solo tome la primera que escribe

            boolean letraCorrecta = false;

            for(int i = 0; i < palabraSecreta.length(); i++){

                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
                
            }
            if(!letraCorrecta){
                intentos++;
                if(intentos != intentosMaximos){
                    System.out.println("Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
                }
            }            

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Felicidades!!! Adivinaste la palabra secreta: " + palabraSecreta + " en el intento numero " + intentos);
            }

        }
        if(!palabraAdivinada){
            System.out.println("Que pena, te quedaste sin intentos! GAME OVER");
        }
        scanner.close();

    }
}
