package inteproba3;
import java.util.Scanner;
public class InteProba3 {

 public static void main(String[] args) {

  int valor [] = new int[20];
  int sumatoria = 0;
  float media = 0;
  double varianza = 0.0;
  double desviacion= 0.0; 
   
  Scanner entrada = new Scanner(System.in);
             
  
  System.out .println("Ingrese los valores"
                                     +" como muestra");
  
  for (int i = 0; i < 20; i++ ){
   
   System.out.print("Ingrese el valor " + (i + 1) + ":");
   valor[i] = entrada.nextInt();
   
   sumatoria = sumatoria + valor[i];
    
  }
  entrada.close();
  

  

  for(int i = 0 ; i < 20; i++){
   double rango;
   rango = Math.pow(valor[i] - media, 2f);
   varianza = varianza + rango;
  }

  desviacion = Math.sqrt(varianza);

  System.out.println("Desvianción Estándar: " + desviacion);
 }

}