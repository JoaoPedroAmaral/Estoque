import java.util.Scanner;

public class App {
    // acessar a função de adicionar produto
    static ConfigProdutos config = new ConfigProdutos();
    public static void main(String[] args) throws Exception {
        // pegar o valor do banco de dados
            Scanner input = new Scanner(System.in);

            int opcao;// menu
        try {
            do {
                System.out.println(
                        "Escolha a função que deseja:\n 1-Adicionar Produto\n 2-Remover Produto\n 3-Atualizar dado\n 4-Conferir item no estoque\n 5-Conferir Estoque\n 6-Sair");
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        config.AdicionarProdutos(); // Recebe o objeto estoque do método
                        break;
                    case 2:
                        config.RemoverProdutos();// remove produto
                        break;
                    case 3:
                        config.AlterarProduto();
                        break;
                    case 4:
                    config.ConsultarProdutoUnico();
                        break;
                    case 5:// lista todos os produtos no estoque
                        config.ConsultarProdutos();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Selecione um valor valido");
                        break;
                }

            } while (opcao != 6);
        } finally {
            input.close();
        }

    }
}

/*
 * criar função:
 * Adicionar
 * Remover
 * Atualizar dado
 * Conferir se tem item no estoque disponivel
 */