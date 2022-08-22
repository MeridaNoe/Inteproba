
package inteproba2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InteProba2 {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    try {

      System.out.println("Digite la cantidad de numeros a operar: ");
      int cantidad = input.nextInt();

      if (cantidad > 2) {
        String result = "";
        int i = 0;
        int[] numeros = new int[cantidad];

        for (int idx = 0; idx < cantidad; idx++) {
          System.out.println("Digite el número " + (idx + 1));
          numeros[idx] = input.nextInt();
        }

        do {
          switch (i) {
            case 0:
              System.out.println("");
              System.out.println("");
              System.out.println("Calculamos la moda aritmetica");

              List < Integer > acumulado = calcularModa(numeros);

              if (acumulado.isEmpty()) {
                System.out.println("La moda no existe");
              } else {
                result = "";
                for (int valor: acumulado) {
                  if (valor > 0) {
                    result += valor + ",";
                  }
                }

                System.out.println("La moda es: " + result.substring(0, result.length() - 1));
              }

              break;
            case 1:
              System.out.println("");
              System.out.println("");
              System.out.println("Calculamos la media aritmetica");

              result = calcularMedia(numeros);

              System.out.println(result);
              break;
            case 2:
              System.out.println("");
              System.out.println("");
              System.out.println("Calculamos la mediana aritmetica");

              result = calcularMediana(numeros);

              System.out.println("La mediana es: " + result);
              break;
            default:
              break;
          }
          i++;
        } while (i < 3);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      input.close();
    }
  }

  private static List < Integer > calcularModa(int[] numeros) {

    int c = 0;
    int veces = 0;
    int conteoMayor = 0;
    List < Integer > acumulado = new ArrayList < > ();

    for (int j = 0; j <= 9; j++) {
      c = 0;
      for (int k = 0; k < numeros.length; k++) {

        if (j == numeros[k]) {
          c++;
        }
      }

      if (veces <= c) {
        veces = c;
        if (c > 1 && c < numeros.length) {
          if (acumulado.size() == 0 || (conteoMayor > 0 && conteoMayor == c)) {
            conteoMayor = c;
            acumulado.add(j);
          } else if (conteoMayor < c) {
            conteoMayor = c;
            acumulado.clear();
            acumulado.add(j);
          }
        }
      }
    }

    return acumulado;
  }

  private static String calcularMedia(int[] numeros) {
    double valor = 0;
    String result = "(";
    for (int numero: numeros) {
      valor += (numero * 1.0);
      result += numero + " + ";
    }
    result = result.substring(0, result.length() - 2);
    result += ")/" + numeros.length + " = " + valor / numeros.length;

    return result;
  }

  private static String calcularMediana(int[] numeros) {


    Arrays.sort(numeros);

    String result;

    if (numeros.length % 2 == 0) {
      int pos = (numeros.length - 2) / 2;
      result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
    } else {
      int pos = (numeros.length - 1) / 2;
      result = "" + numeros[pos];
    }

    return result;
  }
}