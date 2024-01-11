package pastcomplexnumber;

import java.util.Scanner;

public class TesteComplexos {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o numero real do primeiro numero complexo: ");
            double nR1 = sc.nextDouble();
            System.out.println("Digite o numero imaginario do primeiro numero complexo: ");
            double nI1 = sc.nextDouble();
            System.out.println("Digite o numero real do segundo numero complexo: ");
            double nR2 = sc.nextDouble();
            System.out.println("Digite o numero imaginario do segundo numero complexo: "); 
            double nI2 = sc.nextDouble();
            //(4.5, 6.7)
            // (7.8, -9.1)
            Complexos abc = new Complexos (nR1, nI1);
            Complexos def = new Complexos (nR2, nI2);
            // impressão da soma, utilizando o metodo statico
            Complexos soma = Complexos.somaComplexosObject(abc, def);
            System.out.println("Soma: "+soma);
            // impressão da subtração. utilizando o metodo statico 
            Complexos subtracao = Complexos.subtracaoComplexosObject(abc, def);
            System.out.println("Subtração: "+subtracao);
            
            sc.close();
        }
    
    }
