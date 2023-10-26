import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigProdutos {
    // criando uma lista que vai armazenar os dados, já que não usaremos banco de
    // dados
    public List<Estoque> produto = new ArrayList<>();
    public int ID = 1000;

    // poder transportar os valores dele em outros arquivos

    // função adicionar
    public void AdicionarProdutos() {
        Scanner input = new Scanner(System.in);
        String nome;
        String marca;
        int quantidade;
        float preco;

        ID++;

        System.out.println("Insira o nome: ");
        nome = input.nextLine();

        System.out.println("Insira a marca: ");
        marca = input.nextLine();

        System.out.println("Insira a quantidade: ");
        quantidade = input.nextInt();

        System.out.println("Insira o preço: ");
        preco = input.nextFloat();
        // dá espaçamento nas linhas

        LocalDateTime data = LocalDateTime.now();

        Estoque estoque = new Estoque(ID, nome, marca, quantidade, preco, data);
        produto.add(estoque);

    }

    public void RemoverProdutos() {
        Scanner input = new Scanner(System.in);
        int ID;

        System.out.println("Digite o ID do produto que deseja ser removido: ");
        ID = input.nextInt();

        for (Estoque item : produto) {
            System.out.println("ID do item no estoque: " + item.getID());
            System.out.println("ID digitado: " + ID);
            if (ID == item.getID()) {
                produto.remove(ID - 1001);
                System.out.println("Produto Removido!");
                break;
            } else {
                System.out.println("Produto não encontrado!");
            }
        }
    }

    public void AlterarProduto() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do produto a ser alterado");
        int ID = input.nextInt();
        for (Estoque item : produto) {
            if (ID == item.getID()) {
                System.out.println("ID: " + item.getID());

                System.out.println("Nome atual: " + item.getNomeItem());
                System.out.println("Novo nome: ");
                String novoNome = input.next();
                item.setNomeItem(novoNome);

                System.out.println("Marca atual: " + item.getMarca());
                System.out.println("Nova marca: ");
                String novaMarca = input.nextLine();
                item.setMarca(novaMarca);

                System.out.println("Quantidade atual: " + item.getQuantidade());
                System.out.println("Nova quantidade: ");
                int novaQuantidade = input.nextInt();
                item.setQuantidade(novaQuantidade);

                System.out.println("Preço atual: " + item.getPreco());
                System.out.println("Novo preço: ");
                float novoPreco = input.nextFloat();
                item.setPreco(novoPreco);

                System.out.println("Produto atualizado!");
                break;
            }
        }

    }

    public void ConsultarProdutoUnico() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do produto");
        int ID = input.nextInt();
        for (Estoque item : produto) {
            if (ID == item.getID()) {
                System.out.println("ID: " + item.getID());

                System.out.println("Nome: " + item.getNomeItem());
                System.out.println("Marca: " + item.getMarca());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.println("Preço: " + item.getPreco());
                System.out.println("Data de Adição: " + item.getDataDeAdicao());
            } else {
                System.out.println("Produto não cadastrado!");
            }
        }
    }

    public void ConsultarProdutos() {
        Scanner input = new Scanner(System.in);
        for (Estoque item : produto) {
            System.out.println("ID: " + item.getID());

            System.out.println("Nome: " + item.getNomeItem());
            System.out.println("Marca: " + item.getMarca());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço: " + item.getPreco());
            System.out.println("Data de Adição: " + item.getDataDeAdicao());
        }
    }

    public List<Estoque> getProduto() {
        return produto;
    }

}
