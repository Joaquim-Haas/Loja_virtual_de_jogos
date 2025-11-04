import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        Loja loja = new Loja();
        int escolha, idJogo, tentativaAdmin = 0;
        String senhaAdmin = "KLOJ#BFAJC-@";

        System.out.println("Crie um Usuario! ");
        System.out.println("Digite o nome de usuario: ");
        String usuario = scan.nextLine();
        System.out.println("Digite o saldo na sua carteira: R$");
        double saldoInicial = verificaDouble(scan);
        scan.nextLine();
        Usuario user = new Usuario(usuario, saldoInicial);

        if(user.getNome().equalsIgnoreCase("admin")){
            String senhaAdminTentativa;

            do{
                System.out.println("Digite a senha do admin, terá 5 tentativas: ");
                senhaAdminTentativa = scan.nextLine();

                if(!senhaAdminTentativa.equals(senhaAdmin)){
                    System.out.println("Senha do administrador incorreta, tente novamente...");
                    tentativaAdmin++;
                }
                else{
                    System.out.println("\nVocê é administrador.\n");
                    user.setSaldoCarteira(99999999999999.99);
                    break;
                }
                if(tentativaAdmin == 5){
                    do {
                        System.out.println("Você não virou ADMIN!");
                        System.out.println("Crie um outro Usuario! ");
                        System.out.println("Digite o nome de usuario: ");
                        usuario = scan.nextLine();
                        user.setNome(usuario);
                    }while(usuario.equalsIgnoreCase("admin"));
                }
            }while(tentativaAdmin != 5);
        }

        do {
            System.out.println("\n|-------------------------------|\n");
            System.out.println("Bem vindo ao Vapor - loja virtual de jogos! \n");
            System.out.println("1 - Mostrar Catalogo de jogos da Loja\n2 - Adicionar Jogos na Loja (admin)\n3 - Mostrar Saldo da carteira\n4 - Comprar Jogos\n5 - Mostrar Biblitoeca\n6 - Sair");
            System.out.println("\n|-------------------------------|\n");
            escolha = verificaInt(scan);

            switch(escolha){
                case 1:
                    loja.mostrarCatalogo();

                    break;
                case 2:
                    if(!user.getNome().equalsIgnoreCase("admin")){
                        System.out.println("\nVocê não pode adicionar jogos pois não é administrador\n");
                        break;
                    }
                    else{
                        String nomeJogo;
                        String descJogo;
                        double valorJogo;
                        int id1;

                        System.out.println("Digite o nome do jogo: ");
                        scan.nextLine();
                        nomeJogo = scan.nextLine();
                        System.out.println("Digite a descricao do jogo: ");
                        descJogo = scan.nextLine();
                        System.out.println("Digite o valor do jogo: ");
                        valorJogo = scan.nextDouble();
                        id1 = random.nextInt(0, 9999);
                        loja.adicionarJogo(new Jogo(nomeJogo, descJogo, valorJogo, id1));
                    }

                    break;
                case 3:
                    System.out.println("\nSeu usuário: " + user.getNome());
                    System.out.printf("Seu saldo: R$%.2f\n\n", user.getSaldoCarteira());

                    break;
                case 4:
                    int id2;

                    System.out.println("Digite o ID do jogo que você quer comprar: ");
                    id2 = verificaInt(scan);
                    loja.comprarJogo(user, id2);

                    break;
                case 5:
                    System.out.println("\nMinha biblioteca: ");

                    if(user.getBiblioteca().isEmpty()){
                        System.out.println("Biblioteca vazia, adicione e compre novos jogos!");
                    }

                    else{
                        for(Jogo jogos : user.getBiblioteca()){
                            System.out.println("- " + jogos.getNome());
                        }
                    }

                    break;
                case 6:
                    System.out.println("Adeus...");
                    break;

                default:
                    System.out.println("Escolha invalida, tente novamente.");
            }

        }while(escolha != 6);

        System.out.println("Obrigado por usar o Vapor");

        scan.close();
    }

    public static int verificaInt(Scanner Scan){
        while(true){
            try {
                return Scan.nextInt();
            }
            catch (Exception e) {
                System.out.println("Digite apenas numeros.");
                Scan.nextLine();
            }
        }
    }

    public static double verificaDouble(Scanner Scan){
        while(true){
            try {
                return Scan.nextDouble();
            }
            catch (Exception e) {
                System.out.println("Digite apenas numeros.");
                Scan.nextLine();
            }
        }
    }
}