package br.com.sysprise.endereco.repository;


import br.com.sysprise.endereco.model.cidade.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("select case when count(e.id) > 0 then true else false end " +
            "from Endereco e join e.cidade where e.cidade.id = :id")
    Boolean haEnderecosVinculadosCidade(Long id);

    Page<Cidade> findAllByEstado_Id(Pageable pageable, Long id);
}
