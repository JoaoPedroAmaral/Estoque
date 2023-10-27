package spring.estoque.func;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstoqueRepository extends JpaRepository<EstoqueModel, UUID>{
    EstoqueModel findByNomeAndMarca(String nome, String marca);
    

}
