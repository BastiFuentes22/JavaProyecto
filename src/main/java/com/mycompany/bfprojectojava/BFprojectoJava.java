
package com.mycompany.bfprojectojava;

import java.util.Scanner;

public class BFprojectoJava {

    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);

        
        String[] asientos = new String[80];
        for (int i = 0; i < 80; i++) {
            if (i < 20) asientos[i] = "V" + (i + 1);           
            else if (i < 40) asientos[i] = "PB" + (i - 19);     
            else if (i < 60) asientos[i] = "PA" + (i - 39);     
            else asientos[i] = "PL" + (i - 59);                 
        }

        boolean seguir = true;

        while (seguir) {
            System.out.println("... BIENVENIDOS...");
            System.out.println("... TEATRO MORO ...");
            System.out.println("... MENÚ PRINCIPAL ...");
            System.out.println("1. Comprar entradas.");
            System.out.println("2. Salir.");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
               
                System.out.println("... ASIENTOS ...");
                for (int i = 0; i < 80; i++) {
                    System.out.print("[" + asientos[i] + "] ");
                    if ((i + 1) % 10 == 0) System.out.println();
                }

                
                System.out.print("Ingrese el asiento que desea (ej: V5, PB10): ");
                String asientoElegido = sc.nextLine().toUpperCase();

                int posicion = -1;
                for (int i = 0; i < 80; i++) {
                    if (asientos[i].equals(asientoElegido)) {
                        posicion = i;
                        break;
                    }
                }

                if (posicion == -1) {
                    System.out.println("Asiento inválido o no disponible.");
                    continue;
                }

                asientos[posicion] = "XX";

                
                int precioBase = 0;
                if (posicion < 20) precioBase = 30000;      
                else if (posicion < 40) precioBase = 15000;  
                else if (posicion < 60) precioBase = 18000;  
                else precioBase = 13000;                    

                
                System.out.print("Ingrese su edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                double descuento = 0;
                if (edad <= 25) descuento = 0.10;
                else if (edad >= 60) descuento = 0.15;

                double precioFinal = precioBase - (precioBase * descuento);

                
                System.out.println("... RESUMEN DE COMPRA ...");
                System.out.println("Asiento: " + asientoElegido);
                System.out.println("Precio base: $" + precioBase);
                System.out.println("Descuento: " + (int)(descuento * 100) + "%");
                System.out.println("Total a pagar: $" + (int)precioFinal);

                
                System.out.print("¿Desea comprar otra entrada? (SI/NO): ");
                String respuesta = sc.nextLine().toUpperCase();
                if (!respuesta.equals("SI")) {
                    seguir = false;
                    System.out.println("Gracias por su compra, que disfrute la función!!");
                }

            } else if (opcion.equals("2")) {
                seguir = false;
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                System.out.println("ATTE: Teatro Moro...");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        sc.close();
        
            
            
            
            
            
            
            
        }
    }
        
         
        
    
     

