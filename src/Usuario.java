import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Jogo> biblioteca;
    //private ArrayList<Jogo> carrinho;
    private double saldoCarteira;

    public Usuario(String Nome, double SaldoCarteira){
        this.nome = Nome;
        this.biblioteca = new ArrayList<>();
        //this.carrinho = new ArrayList<>();
        this.saldoCarteira = SaldoCarteira;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoCarteira(){
        return saldoCarteira;
    }

    public ArrayList<Jogo> getBiblioteca(){
            return this.biblioteca;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }

    public void setSaldoCarteira(double Saldo){
        this.saldoCarteira = Saldo;
    }
    /*
    public ArrayList<Jogo> getCarrinho() {
        return carrinho;
    }

    public void adicionarAoCarrino(Jogo jogo){
        carrinho.add(jogo);
    }

    public void esvaziarCarrinho(){
        carrinho.clear();
    }
    */
}
