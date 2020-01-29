import java.util.Scanner;
  
public class Determinista {
 
    static String [] caracteres;
    String []array;
    int contador;
 
    public static void main(String[] args) {
        Determinista automata = new Determinista();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese La cadena");
        String cad;
        cad = sc.nextLine();
        System.out.println("----------------------------\n");
        System.out.println("----Transiciones----");
        caracteres = cad.split("");
        if(caracteres.length==1){
            if(caracteres[0].equalsIgnoreCase("a")){
                System.out.println("(q0)----"+caracteres[0]+"---->(q1)");
                System.out.println("--------Y-------");
                System.out.println("(q0)----"+caracteres[0]+"---->(q3) ---->Estado de aceptacion");
            }else{
                System.out.println("Cadena Invalida");
                System.out.println("(q0)---->Estado actual");
            }
        }else if(caracteres.length>1){
            if(caracteres[0].equalsIgnoreCase("a")){
                automata.q3();
            }else{
                System.out.println("Cadena Invalida");
                System.out.println("(q0)---->Estado actual");
            }
            
        }
    }
    public void q3(){
        String valor="";
        String cadena="";
        if(caracteres.length == 2){ 
            for(int i=0; i<caracteres.length; i++){
                cadena= cadena+caracteres[i];
                if(cadena.equalsIgnoreCase("ab")){
                   q4();
                }else if(cadena.equalsIgnoreCase("ac")){
                    System.out.println("(q0)----"+caracteres[0]+"---->(q1)");
                    System.out.println("(q1)----"+caracteres[1]+"---->(q2)");
                    System.out.println("(q2)----->Estado de aceptacion");
                }
            }
            
        }else{
            for(int i=0; i<caracteres.length; i++){
                valor= valor+caracteres[i];
                contador++;
                if(valor.equalsIgnoreCase("ab")){
                    transiciones();
                }else if(valor.equalsIgnoreCase("ac")){
                    ac();
                }
            }
        }  
    }
    public void transiciones(){
        if(caracteres.length > 3){
            q2();
        }else{
            for(int i=contador; i<caracteres.length; i++ ){
                if(caracteres[i].equalsIgnoreCase("c")){
                    System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
                    System.out.println("(q3)----"+caracteres[1]+"---->(q1)");
                    System.out.println("(q1)----"+caracteres[i]+"---->(q2)");
                    System.out.println("(q2)---->Estado de aceptacion");
                    System.out.println("--------Y---------");
                    System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
                    System.out.println("(q3)----"+caracteres[1]+"---->(q4)");
                    System.out.println("(q4)----"+caracteres[i]+"---->(q2) ");
                    System.out.println("(q2)---->Estado de aceptacion");
                }
            }
        }  
    }
    public void q2(){
        String c = "c";
        int cont=2;

        System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
        System.out.println("(q3)----"+caracteres[1]+"---->(q1)");
        System.out.println("(q1)----"+caracteres[2]+"---->(q2)");

        System.out.println("--------Y---------");
        System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
        System.out.println("(q3)----"+caracteres[1]+"---->(q4)");
        System.out.println("(q4)----"+caracteres[2]+"---->(q2)\n ");

        for(int i=3; i<caracteres.length; i++){
            if(caracteres[i].equalsIgnoreCase(c)){
                if(cont == 2){
                    System.out.println("(q"+cont+")----C---->(q1)");
                    cont--; 
                }else if(cont == 1){
                    System.out.println("(q"+cont+")----C---->(q2)");
                    cont++;
                }
            }
        }
        if(cont == 2){
            System.out.println("(q2)---->Estado de aceptacion");
        }else{
            System.out.println("(q"+cont+")---->Estado actual");
        }
    }
    public void q4(){
        System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
        System.out.println("(q3)----"+caracteres[1]+"---->(q1)");
        System.out.println("(q1)----->Estado actual");
        System.out.println("--------Y---------");
        System.out.println("(q0)----"+caracteres[0]+"---->(q3)");
        System.out.println("(q3)----"+caracteres[1]+"---->(q4)");
        System.out.println("(q4)----->Estado actual");
    }
    public void ac(){
        String c = "c";
        int cont=1;

        System.out.println("(q0)----"+caracteres[0]+"---->(q1)");
        System.out.println("(q1)----"+caracteres[1]+"---->(q2)");

        for(int i=3; i<caracteres.length; i++){
            if(caracteres[i].equalsIgnoreCase(c)){
                if(cont == 2){
                    System.out.println("(q"+cont+")----C---->(q1)");
                    cont--; 
                }else if(cont == 1){
                    System.out.println("(q"+cont+")----C---->(q2)");
                    cont++;
                }
            }
        }
        if(cont == 2){
            System.out.println("(q2)---->Estado de aceptacion");
        }else{
            System.out.println("(q"+cont+")---->Estado actual");
        }
    }
}