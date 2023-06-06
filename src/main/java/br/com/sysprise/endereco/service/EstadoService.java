package br.com.sysprise.endereco.service;


import br.com.sysprise.endereco.model.estado.*;
import br.com.sysprise.endereco.repository.EstadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public Estado findEstadoById(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("O estado requisitado não foi encontrado!"));
    }

    public Page<DadosListagemEstado> listar(Pageable pageable) {
        return estadoRepository.findAll(pageable).map(DadosListagemEstado::new);
    }

    public DadosDetalhamentoEstado detalhar(Long id) {
        Estado estado = this.findEstadoById(id);
        return new DadosDetalhamentoEstado(estado);
    }

    public DadosDetalhamentoEstado cadastrar(DadosCadastroEstado dadosCadastro) {
        Estado estado = new Estado(dadosCadastro);
        estadoRepository.save(estado);
        return new DadosDetalhamentoEstado(estado);
    }

    public DadosDetalhamentoEstado atualizar(DadosAtualizarEstado dadosAtualizar) {
        Estado estado = this.findEstadoById(dadosAtualizar.id());
        estado.atualizarCadastro(dadosAtualizar);
        return new DadosDetalhamentoEstado(estado);
    }

    public void deletar(Long id) {
        Estado estado = this.findEstadoById(id);
        Boolean haCidadesVinculadas = estadoRepository.haCidadesVinculadasEstado(estado.getId());
        if(haCidadesVinculadas) throw new RuntimeException("Estado não pode ser deletado pois há cidades vinculadas a ele");
        estadoRepository.delete(estado);
    }
}
