package br.com.sysprise.endereco.repository;


import br.com.sysprise.endereco.model.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("select case when count(c.id) > 0 then true else false end " +
            "from Cidade c join c.estado where c.estado.id = :id")
    Boolean haCidadesVinculadasEstado(Long id);
}
