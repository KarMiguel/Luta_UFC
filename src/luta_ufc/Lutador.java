
package luta_ufc;

import java.util.ArrayList;

public class Lutador {
    
    private static ArrayList<Lutador> lutadores = new ArrayList<>();
    private String nome ,cpf, nacionalidade,categoria;
    private Double peso;
    private int vitorias,derrotas, empates,idade;
    
    public Lutador(String nome,String cpf, String nacionalidade, int idade,double peso) {
        this.nome = nome;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.setPeso(peso);
 
    }
    
    public void addLutador(Lutador l){
        lutadores.add(l);
    }
    
    public static ArrayList<Lutador> getLutadores() {
        return lutadores;
    }
    
    public static Lutador buscarLutador(String cpf){
        Lutador lutador = null;
        for(int i=0; i<getLutadores().size();i++){
            if(cpf.equals(getLutadores().get(i).getCpf())){
                lutador = Lutador.getLutadores().get(i);
            }
        }
        return lutador;
    }
    public void mostrarBusca(String cpf) {
        int busca=0;
        for (int i = 0; i < getLutadores().size(); i++) {
            if (getLutadores().get(i).getCpf().equals(cpf)) {
                System.out.println("Lutador Encontrado:\n");
                System.out.println(Lutador.getLutadores().get(i).toString());
                busca=1;
            }
        }if(busca!=1){
            System.out.println("Lutador não encontrado!");    
        }
    }
    public static boolean validarCpf(String cpf) {
        for (int i = 0; i < getLutadores().size(); i++) {
            if (getLutadores().get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public static void LutadoresCadastrados() {
        System.out.println("Lutadores Cadastrada:\n");
        for (Lutador x : getLutadores()) {
            System.out.println(x.toString());
        }
        System.out.println("");
    }
  
    public void mostrarCategoriaLutador(String cpf){
        for (int i = 0; i < getLutadores().size(); i++) {
            if (getLutadores().get(i).getCpf().equals(cpf)) {
                System.out.println("\n-------------------------------");
                System.out.println(getNome()+" e um peso "+getCategoria());
                System.out.println("Ganhou "+getVitorias()+" vezes");
                System.out.println("Perdeu "+getDerrotas()+" vezes");
                System.out.println("Empatou "+getEmpates()+" vezes");
            }else{
                System.out.println("Lutador Inexistente");
            }
        }
    }
      
    private void setCategoria() {
        if(getPeso()<52.2){
            this.categoria = "Inválido";
        }else if(getPeso() <70.3){
            this.categoria = "Leve";
        }else if (getPeso()<=83.9){
            this.categoria = "Médio";
        }else if(getPeso()<=120.2){
            this.categoria = "Pesado";
        }else{
            this.categoria = "Inválido";
        }
    }
    
     @Override
    public String toString() {
        return  nome +" diretamente do " + nacionalidade + "\n"
                +"com " +idade+" anos e "+",pesando " +String.format("%.2f",peso) + "kg\n"
                +"Categoria Peso "+getCategoria()+"\n"
                +vitorias +" vitoria, "+derrotas +" derrotas, "+empates +" empates\n"+
                "----------------------------------";
    }
    
    public void perderLuta(){
        this.setDerrotas(this.getDerrotas()+ 1);
    }
    public void ganharLuta(){
        this.setVitorias(this.getVitorias() + 1);
        
    }
    public void empatarLuta(){
        this.setEmpates(this.getEmpates() + 1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
