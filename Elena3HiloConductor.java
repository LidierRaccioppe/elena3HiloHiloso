/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elena3hiloconductor;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Elena3HiloConductor {
    public static void main(String[] args) {
        autoHilandose ah = new autoHilandose("pepe", 5);
        ah.run();
    }}


class autoHilandose extends Thread {

    int reiteraciones;

    public autoHilandose(String nombre, int reiteraciones) {
        super(nombre);
        this.reiteraciones = reiteraciones;
    }

    public void run() {
        try {
            if (reiteraciones > 0) {
                reiteraciones = reiteraciones - 1;
                int hiloActual = reiteraciones;
                int hiloHijo = reiteraciones - 1;
                autoHilandose ahil = new autoHilandose("pepe" + reiteraciones, reiteraciones);
                System.out.println("Comenzo el hilo pepe" + reiteraciones);
                if (reiteraciones != 0) {
                    System.out.println("El hilo pepe" + reiteraciones + " crea a su hijo  pepe" + (reiteraciones - 1));
                }
                ahil.start();

                Random rand = new Random();
                int contador = 0;
                for (int i = 0; contador < 9; contador++) {
                    System.out.println("pepe" + reiteraciones + " da signos de vida por " + contador + " veces");

                    int limiteSuperior = 600, limiteInferior = 100;
                    int siestaAleatoria = rand.nextInt(limiteSuperior - limiteInferior + 1);
                    sleep(siestaAleatoria);
                }

                if (contador == 9) {
                    ahil.join();
                    System.out.println("El hilo pepe" + reiteraciones + " da su ultimo mensaje");
                }

            } else {
                System.out.println("Se termino de crear todos los hilos");
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public int getReiteraciones() {
        return reiteraciones;
    }
}
