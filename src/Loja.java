import java.util.ArrayList;
import java.util.HashMap;

public class Loja {

    private ArrayList<Jogo> catalogo;
    private HashMap<Integer, Jogo> buscaJogo;

    public Loja(){
        this.catalogo = new ArrayList<>();
        this.buscaJogo = new HashMap<>();
    }

    public void adicionarJogo(Jogo jogo){
        if(buscaJogo.containsKey(jogo.getId())){
            System.out.println("Esse ID já existe, crie novamente o jogo!");
            return;
        }
        catalogo.add(jogo);
        buscaJogo.put(jogo.getId(), jogo);
    }

    public void comprarJogo(Usuario user, int idJogo){
        Jogo jogo = buscaJogo.get(idJogo);

        if(jogo == null){
            System.out.println("Esse jogo não existe.");
            return;
        }

        if(user.getSaldoCarteira() >= jogo.getValor()){
            user.setSaldoCarteira(user.getSaldoCarteira() - jogo.getValor());
            System.out.println("Jogo comprado com sucesso! " + jogo.getNome());
            user.getBiblioteca().add(jogo);
        }
        else{
            System.out.println("Saldo insuficiente... R$" + user.getSaldoCarteira());
        }
    }

    public void mostrarCatalogo(){
        if(catalogo.isEmpty()){
            System.out.println("Catálogo vazio, adicione jogos.");
        }
        else{
            System.out.println("Catálogo da loja: ");

            for(Jogo jogos : catalogo){
                System.out.println("Id: " + jogos.getId());
                System.out.println("Nome: " + jogos.getNome());
                System.out.println("Valor: R$" + jogos.getValor());
                System.out.println("Descricao: " + jogos.getDescricao() + "\n");
            }
        }

    }
}
