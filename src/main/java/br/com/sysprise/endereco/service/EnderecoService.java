package br.com.sysprise.endereco.service;

import br.com.sysprise.endereco.model.cidade.Cidade;
import br.com.sysprise.endereco.model.endereco.Endereco;
import br.com.sysprise.endereco.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pb.CriarEnderecoRequest;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final CidadeService cidadeService;
    private final EnderecoRepository enderecoRepository;


    Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("O endereço requisitado não foi encontrado!"));
    }

    public Long cadastrar(CriarEnderecoRequest request) {
        Cidade cidade = cidadeService.findCidadeById(request.getCidadeId());
        Endereco endereco = new Endereco(request, cidade);
        enderecoRepository.save(endereco);
        return endereco.getId();
    }

    public pb.Endereco getEnderecoRpcById(Long id) {
        Endereco endereco = this.getEnderecoById(id);
        return pb.Endereco
                .newBuilder()
                .setId(endereco.getId())
                .setRua(endereco.getRua())
                .setNumero(endereco.getNumero())
                .setBairro(endereco.getBairro())
                .setComplemento(endereco.getComplemento())
                .setCep(endereco.getCep())
                .setCidadeId(endereco.getCidade().getId())
                .setEstadoId(endereco.getCidade().getEstado().getId())
                .build();
    }

    public void deletar(Long id) {
        Endereco endereco = this.getEnderecoById(id);
        enderecoRepository.delete(endereco);
    }

    public void atualizar(pb.Endereco dadosAtualizar) {
        Endereco endereco = this.getEnderecoById(dadosAtualizar.getId());
        Cidade cidade = cidadeService.findCidadeById(dadosAtualizar.getCidadeId());
        endereco.atualizarCadastro(dadosAtualizar, cidade);
    }
}
