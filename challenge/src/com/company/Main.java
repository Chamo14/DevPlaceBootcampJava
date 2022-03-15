package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 =new Scanner(System.in);
        int opcion;
        int i=0;
            imprimirDatos();//impresiones de pantalla
            opcion=teclado.nextInt();
    //Menu de opciones
                switch (opcion) {
                    case 1:
                        ej1();
                        break;
                    case 2:
                        ej2();
                        break;
                    case 3:
                        ej3();
                        break;
                    case 4:
                        ej4();
                        break;
                    case 5:
                        ej5();
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }


        teclado.close();
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

       /*EJERCICIO 1*/
        public static void ej1 () {
            int number;
            boolean primo;
            number = ingreso();
            primo = esPrimo(number);
            if (primo)
                System.out.println("El numero " + number + " es Primo");
            else
                System.out.println("El numero " + number + " no es Primo");
        }
        public static int ingreso(){
            int num;
            Scanner read = new Scanner(System.in);
            System.out.println("Ingrese numero :");//ingreso del numero a verificar si es primo
            num=read.nextInt();
            read.close();
            return  num;

        }
        public static boolean esPrimo(int numero) {
            int cont = 2;
            boolean primo = true;
            while ((primo) && (cont != numero)) {
                if (numero % cont == 0)//si el resto de la division da cero quiere decir que nos primo
                    primo = false;
                cont++;
            }
            return primo;
        }
        /**/
        /*EJERCICIO 2*/
        public static void ej2(){
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese una contraseña");//Se crea la contraseña
            String pw= leer.nextLine();
            verificacion(pw);//se verifica
            leer.close();//se cierra la lectura

    }
        public static void verificacion(String pw) {
            boolean verificacion = false;
            int cont = 1;
            Scanner leer = new Scanner(System.in);
            while (!(verificacion) && (cont != 4)) {

                System.out.println("Ingrese nuevamente su contraseña");
                String newPw = leer.nextLine();

            //Se compara con la contraseña ingresada al principio con su "repeticion " para no haber fallos
                if (pw.equals(newPw)) {
                    System.out.println("Felicitaciones recordas tu contraseña");
                    verificacion = true;
                } else {//En caso de errar tiene el usuario 3 intentos en total
                    System.out.println("Tenes que ejercitar la memoria");
                    System.out.println("Presione una tecla para continuar (te quedan " +(3-cont) +" intentos)");
                    clearScreen();

                }
                cont++;

            }
            leer.close();
        }
        /**/
        /*EJERCICIO 3*/
        public static void ej3(){
            float valorHora;
            float total=0;
            String nombre;
            int antiguedad;
            int horasTrabajadas;
            //Ingreso de valores
            Scanner leer= new Scanner(System.in);
            System.out.println("Ingrese valor de Hora");
            valorHora=leer.nextFloat();
            leer.nextLine();
            System.out.println("Ingrese nombre del empleado");
            nombre= leer.nextLine();
            System.out.println("Ingrese la antiguedad del empleado");
            antiguedad=leer.nextInt();
            System.out.println("Ingrese horas trabajadas");
            horasTrabajadas= leer.nextInt();
            total=total+totalAPagar(valorHora,antiguedad,horasTrabajadas);//calculo del sueldo a pagar
            impresionDatos(valorHora,nombre,antiguedad,horasTrabajadas,total);//metodo que simplifca las impresiones de pantalla
            leer.close();
        }
        //Metodo extra en caso de cumplir con mas de 10 años de antiguedad se le agrega un bono al empleado en su sueldo
        public static float totalAPagar(float valorHora,int antiguedad, int horasTrabajadas){
            float total=0;
            int bonoAntiguedad=0;
            if (antiguedad>10)
            {bonoAntiguedad=antiguedad*30;
                total=(valorHora*horasTrabajadas)+bonoAntiguedad;
            }
            else
                total=(valorHora*horasTrabajadas);
            return  total;//Retorna el total del bono
        }
        //Simplificacion de impresion de pantalla para el main
        public static void impresionDatos(float valorHora,String nombre,int antiguedad,int horasTrabajadas,float total){
            System.out.println("Valor de hora : "+valorHora);
            System.out.println("Nombre empleado : "+nombre);
            System.out.println("Antiguedad : "+antiguedad);
            System.out.println("Horas trabajadas : "+horasTrabajadas);
            System.out.println("Total a pagar : "+total);
        }
       /**/
       /*EJERCICIO 4*/
        public static void ej4(){
            //Se guarda un numero random que el usuario tiene que adivinar
            int random =(int) ((Math.random()*1000)+1);
            Scanner leer = new Scanner(System.in);
            int numero;
            int acierto = -1;
            String c;
            while (acierto != 1001 )
            {
            System.out.println("Ingrese un numero entre 0 a 1000");
            numero=leer.nextInt();
            if ((numero>=0) && (numero<=1000)){
                if (numero==random)
                {
                    acierto=1001;
                    System.out.println("Adivinaste el numero");
                }
                else//opcion de seguir intentadolo o rendirse para terminar el bucle
                {   System.out.println("Sigue intentandolo");
                    System.out.println("Te rendis? Presiona Y / N");
                    c=leer.next();
                    if (c.equals("y"))
                    {
                        System.out.println("Gracias por intentarlo");
                        System.out.println("El numero a adivinar era : "+random);
                        acierto=1001;
                    }
                }
            }

        }
        }
      /**/
      /*EJERCICIO 5*/
        public static void ej5(){
        Scanner leer= new Scanner(System.in);
        int mayor=0;
        int menor=10000000;
        int sumaTotal=0;
        int sumaCant=0;
        int numero;
        do {
            System.out.println("Ingrese un numero (si quiere cortar el ingreso de numeros , presione -1");
             numero = leer.nextInt();
             //Si el numero ingresado no es -1 se guardaran los mayores y menores, ademas se sumaran la cantidad y los valores de los numeros
             if (numero!=-1){
                if (numero > mayor)
                 mayor = numero;
                if (numero < menor)
                 menor = numero;
                sumaTotal += numero;
                sumaCant++;
             }
        }
        while (numero!=-1);
        imprimirEj5(sumaTotal,sumaCant,mayor,menor);
        leer.close();
        }
    //Simplifacion de impresiones de pantalla para el codigo main
        public static void imprimirEj5(int sumaTotal,int sumaCant,int mayor,int menor){
            System.out.println("La suma total de todos los numeros es : "+sumaTotal);
            System.out.println("Se ingresaron : " +sumaCant);
            System.out.println("El mayor de los numeros es : "+mayor);
            System.out.println("El menor de los numeros es : "+menor);
        }
        //Simplifacion de impresiones de pantalla para el codigo main
        public static void imprimirDatos(){
            System.out.println("CHALLENGE ALGORITMOS");
            System.out.println("Elija el ejercicio a realizar");
            System.out.println("1 ----->Ejercicio 1");
            System.out.println("2 ----->Ejercicio 2");
            System.out.println("3 ----->Ejercicio 3");
            System.out.println("4 ----->Ejercicio 4");
            System.out.println("5 ----->Ejercicio 5");
        }
      /**/
    }

