package luta_ufc;

import java.util.Scanner;

public class Luta_UFC {

    public static void main(String[] args) {
      
        Scanner entr = new Scanner(System.in);
        Lutador lutador = null;
        Luta ufc = new Luta();
        Lutador lutador1 = new Lutador("Carlos","123","Brasil",19,85);
        Lutador lutador2 = new Lutador("Miguel","321","EUA",20,85);
        lutador1.addLutador(lutador1);
        lutador2.addLutador(lutador2);

        int op;
        do{
            System.out.println("\n--------------------------------");
            System.out.println("------------UFC WWWE------------");
            System.out.println("--------------------------------");
            System.out.println("1 - Cadastrar Lutador");
            System.out.println("2 - Buscar dados do Lutador");
            System.out.println("3 - Mostrar lista de lutadores");
            System.out.println("4 - Marcar Luta");
            System.out.println("5 - Lutar");
            System.out.println("6 - Sair do Menu");
            System.out.println("--------------------------------");
            op = entr.nextInt();
            if(op==1){
                System.out.println("Informe os dados do Lutador! ");
                System.out.print("Nome: ");
                entr.nextLine();
                String nome = entr.nextLine();
                System.out.print("CPF: ");
                String cpf = entr.next();
                while (lutador.validarCpf(cpf)) {
                    System.out.println("CPF já cadastrado. Por favor, digite outro CPF:");
                    cpf= entr.next();
                }
                System.out.print("Nacionalidade:");
                String nacion=entr.next();
                entr.nextLine();
                System.out.print("Idade: ");
                int idade=entr.nextInt();
                System.out.print("Peso: ");
                double peso = entr.nextFloat();         
        
                lutador = new Lutador(nome,cpf,nacion,idade,peso);
                lutador.addLutador(lutador);
                
            }else if(op==2){
                System.out.print("Informe CPF do lutador a ser buscado: ");
                String cpf=entr.next();
                lutador.mostrarBusca(cpf);
            }else if(op==3){
                Lutador.LutadoresCadastrados();
            }else if(op==4){
               System.out.print("Informe o CPF do desafiante: ");
                String cpf1=entr.next();
                System.out.print("Informe o CPF do desafiado: ");
                String cpf2 = entr.next();
                    if(lutador.validarCpf(cpf2)== false && lutador.validarCpf(cpf2) == false) {
                        System.out.println("\nIMPOSSIVEL MARCAR LUTA!!");
                    }else{
                        Lutador l1 = Lutador.buscarLutador(cpf1);
                        Lutador l2 =Lutador.buscarLutador(cpf2);
                        ufc.marcarluta(l1,l2);
                    }
            }else if(op==5){
                ufc.lutar();
               
            }else{
                 if (op==6) {
                    break;
                }
                System.out.println("Opção Invalida!");
           }
        }while(op!=6);
               
    }
    
}
