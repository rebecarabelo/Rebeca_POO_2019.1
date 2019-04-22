import java.util.Scanner;

class Calculadora{
    int bateria;
    int bateriaMax;

    public Calculadora (int bateriaMax){
        this.bateriaMax = bateriaMax;
        this.bateria = 0;

    }


    void carregar (int valor){
     this.bateria += valor;
     
     if (this.bateria > bateriaMax){
       this.bateria = bateriaMax;
     }

   }


    boolean gastarBateria () {
        if (this.bateria == 0){
            System.out.println("falha:Bateria insuficiente");
            return false;

        }
        this.bateria -= 1;
        return true;
    }
    
    String soma (int a, int b){
        if (gastarBateria()){
            return "" + (a + b);
        }

        return "";
    }

    String divisao (int num,int den){
        if (!gastarBateria()){
            return "" ;
        }

        if (den == 0){
            System.out.println("Falha: Divisao por zero");
            return "";
        }

        return "" + (num/den);

    }

    @Override
    public String toString() {
        return "bateria:" + this.bateria;

    }
}

class Controller {
     Calculadora Calc;
     static Scanner scan = new Scanner (System.in);
    private boolean valor;
    private Calculadora calc;

     public Controller () {
         Calc = new Calculadora (0);

     }

     public void shell (String line){
         
        String ui[] = line.split (" ");
        
         switch (ui[0]) {
             case "help":
                 System.out.println("soma _a _b, show, div _a _b, charge _value");
                 break;
                 
             case "iniciar":
                 this.calc = new Calculadora (Integer.parseInt(ui[1]));
                 break;
                 
             case "mostrar":
                 System.out.println(calc);
                 break;
                 
             case "carregar":
                 calc.carregar (Integer.parseInt(ui[1]));
                 break;
                 
             case "somar":
                 String soma;
                 soma = calc.soma (Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                 if (soma.equals("")){

                 }
                 else {
                     System.out.println(soma);
                     
                 }
                 break;
        
           case "divisao":
               String valor1 = calc.divisao (Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
               if (!valor1.equals("")){
                   System.out.println (valor1);
               }        
               
               break;
 
             default:
                 System.out.println ("falha: comando invalido");
                 break;
         }  
     }   

    public static void main (String[]args) {
        Controller cont = new Controller ();

        while(true){
            String line = scan.nextLine() ;
            System.out.println ("$" + line);

            if (line.equals ("sair")){
                break;

            }
            cont.shell (line);
        }
    }
}