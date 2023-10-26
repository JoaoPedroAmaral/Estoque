import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Estoque {
    //declarando variavel
    
    private int ID;
    private String nomeItem, marca;
    private int quantidade; 
    private float preco; 
    private LocalDateTime dataDeAdicao;

    public Estoque(){

    }
    //colocando eles em uma função
    public Estoque(int ID,String nomeItem, String marca, int quantidade, float preco, LocalDateTime dataDeAdicao){
        this.ID = ID;
        this.nomeItem = nomeItem;
        this.marca = marca;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataDeAdicao = dataDeAdicao;
    }

    //getter e setter
    public int getID() {
        return ID;
    }
    public String getNomeItem() {
        return nomeItem;
    }
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getDataDeAdicao() {
        //formatando a maneira que é impressa o horario
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss\n");

        String dataFormatada = dataDeAdicao.format(formatter);
        
        return dataFormatada;
    }
    public void setDataDeAdicao(LocalDateTime dataDeAdicao) {
        this.dataDeAdicao = dataDeAdicao;
    }

}
