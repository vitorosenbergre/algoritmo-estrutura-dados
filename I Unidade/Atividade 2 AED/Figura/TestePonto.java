package Figura;

import java.util.Scanner;

public class TestePonto {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        
        // Ponto
        System.out.println("Digite o ponto x: ");
        double x = sc1.nextDouble();
        System.out.println("Digite o ponto y: ");
        double y = sc1.nextDouble();

        Ponto p1 = new Ponto(x,y);
        Ponto p2 = new Ponto();
        
        System.out.println("Objeto com parametro: "+p1);
        System.out.println("Objetvo sem parametro: "+p2);

        p2.setX(5);
        p2.setY(2);

        System.out.println("Objeto setado: "+p2);

        System.out.println(p1+ "\n" + p2);
        
        // Circulo
        System.out.println("Digite o ponto x do Circulo: ");
        double xC = sc1.nextDouble();
        System.out.println("Digite o ponto y do Circulo: ");
        double yC = sc1.nextDouble();
        System.out.println("Digite o raio do circulo: ");
        double raioC = sc1.nextDouble();
        
        Circulo c1 = new Circulo(raioC,xC,yC);
        
        System.out.println(c1);
        System.out.println("Area: "+ c1.areaCirculo());
        
        c1.setRaio(7);

        System.out.println("Circulo atualizado\n"+ c1);
        
        // Cilindro
        System.out.println("Digite o ponto x do Cilindro: ");
        double xL = sc1.nextDouble();
        System.out.println("Digite o ponto y do Cilindro: ");
        double yL = sc1.nextDouble();
        System.out.println("Digite o raio do Cilindro: ");
        double raioL = sc1.nextDouble();
        System.out.println("Digite a altura do Cilindro: ");
        double alturaL = sc1.nextDouble();

        Cilindro lin1 = new Cilindro(xL,yL,raioL,alturaL);
        System.out.println(lin1);
        System.out.println("\nArea: "+lin1.areaCilindro()+"\nVolume: "+ lin1.volumeCilindro());
        
        sc1.close();
    }
}
