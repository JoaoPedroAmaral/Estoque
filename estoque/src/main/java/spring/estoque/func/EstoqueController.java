package spring.estoque.func;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EstoqueController {

    @Autowired
    private IEstoqueRepository estoqueRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody EstoqueModel estoqueModel){

        EstoqueModel estoque = this.estoqueRepository.findByNomeAndMarca(estoqueModel.getNome(), estoqueModel.getMarca());

        
        if(estoque != null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto já cadastrado!");
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(this.estoqueRepository.save(estoqueModel));
    }


    @DeleteMapping("/delete")//http://localhost:8080/delete
    public ResponseEntity delete(@RequestBody InfoRequest DeleteRequest){//@RequestParam serve para receber parametros exclusivos

        String nome = DeleteRequest.getNome();
        String marca = DeleteRequest.getMarca();

        EstoqueModel estoque = this.estoqueRepository.findByNomeAndMarca(nome, marca);

        if(estoque != null){
            this.estoqueRepository.delete(estoque);//deleta no banco de dados
            return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        /*
         * "nome":"dale",
         * "marca":"dale"
         */
        
    }

    @GetMapping("/")
    public ResponseEntity mostrarProduto(@RequestBody InfoRequest searchUnique){

        String nome = searchUnique.getNome();
        String marca = searchUnique.getMarca();

        EstoqueModel estoque = this.estoqueRepository.findByNomeAndMarca(nome, marca);
        
        if(estoque != null){
            return ResponseEntity.status(HttpStatus.OK).body(estoque);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        
    }

    @PutMapping("/update/{id}")//http://localhost:8080/update/UUID-DO-PRODUTO
    public ResponseEntity updateProduct(@PathVariable UUID id, @RequestBody EstoqueModel estoqueModel) {

        Optional<EstoqueModel> existingProduct = estoqueRepository.findById(id);

        if (existingProduct.isPresent()) {
            EstoqueModel productToUpdate = existingProduct.get();

            productToUpdate.setNome(estoqueModel.getNome());
            productToUpdate.setMarca(estoqueModel.getMarca());
            productToUpdate.setQuantidade(estoqueModel.getQuantidade());

            estoqueRepository.save(productToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }


    
    //função de pesquisa unica e pesquisa geral
}
