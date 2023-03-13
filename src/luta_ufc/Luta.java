
package luta_ufc;


import java.util.Random;
public class Luta {
    
    private Lutador desafiado;
    private Lutador desafiante;
    private boolean aprovada;
    
   
    public void marcarluta(Lutador l1,Lutador l2){
        if (l1.getCategoria().equals(l2.getCategoria())&& l1 != l2) {
            this.aprovada= true;
            this.desafiado = l1;
            this.desafiante = l2;
            System.out.println("Luta marcada com sucesso!!");
        }else{
            this.aprovada= false;
            this.desafiado = null;
            this.desafiante = null;
            System.out.println("Impossivel marcar a luta !!");
        }
    }
    public void lutar(){
        if (this.aprovada ) {
            System.out.println("\n##### DESAFIADO #####");
            System.out.println(desafiado.toString());
            System.out.println("\n##### DESAFIANTE #####");
            System.out.println(desafiante.toString());
            
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);
            System.out.println("======= RESULTADO DA LUTA =======");
            switch (vencedor) {
                case 0: //EMPATE
                    System.out.println("EMPATOU !");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                    break;
                case 1: // DESAFIADO VENCE
                    System.out.println("VITORIA Do "+desafiado.getNome()+"!!!");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                    break;
                case 2://DESAFIANTE VENCE
                    System.out.println("VITORIA DO "+desafiante.getNome()+"!!!");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
                }
        }else{
            System.out.println("Luta não pode acontecer!!!");
        }
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
}