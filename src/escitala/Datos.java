/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escitala;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Karla Navarro
 */
public class Datos {
    
    private Scanner scan;
    public Datos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("********************CIFRADO ESCITALA*******************");
        System.out.print("Ingrese el mensaje: ");
        String cadena = sc.nextLine();
        System.out.print("Ingrese el numero de caras: ");
        int caras = sc.nextInt();
        System.out.println("Tamaño de cadena : " + cadena.length() + " No. Caras: " + caras);
        double filas =  Math.ceil((double) cadena.length()/caras);
        System.out.println("Numero de filas: " + filas);
        double tam = caras * filas;
        System.out.println("tamaño:" + tam);
        cadena = Rellenar(cadena,tam);
        int size = cadena.length()-1;
        System.out.println("Size:" + size);
        System.out.print("Para Cifrar ingrese 1 | Para Decifrar ingrese 2: ");
        int opc = sc.nextInt();
        if (opc == 1){
            System.out.println("Mensaje:");
            MatrizFila(cadena, filas, caras);   
            Cifrar(cadena,size,caras, filas);
        }
        else if (opc == 2){
             System.out.println("Mensaje cifrado:");
             MatrizFila(cadena, filas, caras);
             Decifrar(cadena,size,caras, filas);
          }
    }
    public String  Rellenar(String cadena, double tam){
        if (cadena.length() != tam){
            System.out.println("entro ciclo");
            for ( int k = cadena.length() ; k <tam; k++ ){
                    String b = " ";
                     cadena += b;
                    //System.out.println(cadena.length());
                }
                System.out.println("cadena: " + cadena);
            }
        return cadena;
    }
    
    private void Cifrar(String cadena, int size, int caras, double filas){
        int c = 0;
        int pos = 0;
        String salida ="";
         for (int i = 0; i <= size + caras; i ++){
                if ( c > size){
                    pos ++;
                    c = pos;
                }else {
                    salida += cadena.charAt(c);  
                    c += caras; //salto 
                }
            }
            System.out.println("Mensaje cifrado: " + salida);
            System.out.println("Tamaño salida: " + salida.length());
            System.out.println("Mensaje cifrado:");
            MatrizCara(salida, filas, caras);
    }

    private void MatrizFila(String cadena, double filas, int caras) {
        int elemento = 0;
            for (int f = 0; f < filas; f++){
                for (int col = 0; col < caras; col++){
                    if (elemento < cadena.length()){
                        System.out.print(cadena.charAt(elemento) + "\t");
                        elemento ++;
                    }
                }
                System.out.println();
            }
    }
    
    private void MatrizCara(String salida, double filas, int caras){
        int ele = 0;
            for (int col = 0; col < caras; col++){
                for (int f = 0; f < filas; f++){
                    if (ele < salida.length()){
                        System.out.print(salida.charAt(ele) + "\t");
                        ele ++;
                    }
                }
                System.out.println();
            }
    }
    
    private void Decifrar(String cadena, int size, int caras, double filas){
        int c = 0;
        int pos = 0;
        String salida ="";
        for (int i = 0; i <= size + filas; i ++){
            if ( c > size){
                pos ++;
                c = pos;
            }else {
                salida += cadena.charAt(c);  
                c += filas; //salto 
            }
        }
        System.out.println("Mensaje decifrado: " + salida);
        System.out.println("Tamaño salida: " + salida.length());
        System.out.println("Mensaje:");
        MatrizCara(salida, filas, caras);
    }
}
        
