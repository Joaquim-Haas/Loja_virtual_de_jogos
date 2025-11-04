public class Jogo {
    private String nome;
    private String descricao;
    private double valor;
    private int id;

    Jogo(String Nome, String Descricao, double Valor, int Id){
        this.nome = Nome;
        this.descricao = Descricao;
        this.valor = Valor;
        this.id = Id;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getId(){
        return id;
    }

    public double getValor(){
        return valor;
    }
}
