package br.com.sysprise.endereco.controller;

import br.com.sysprise.endereco.model.cidade.*;
import br.com.sysprise.endereco.service.CidadeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/cidade")
@AllArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping
    @Cacheable("cidades")
    public ResponseEntity<Page<DadosListagemCidade>> listar(@PageableDefault(sort = "id", size = 5) Pageable pageable, @RequestParam(name = "estadoId", required = false) Long estadoId) {
        Page<DadosListagemCidade> dadosListagem = cidadeService.listar(pageable, estadoId);
        return ResponseEntity.status(HttpStatus.OK).body(dadosListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCidade> detalhar(@PathVariable("id") Long id) {
        DadosDetalhamentoCidade dadosDetalhamento = cidadeService.detalhar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamento);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCidade> cadastrar(@RequestBody @Valid DadosCadastroCidade dadosCadastro, UriComponentsBuilder componentsBuilder) {
        DadosDetalhamentoCidade dadosDetalhamento = cidadeService.cadastrar(dadosCadastro);
        URI uri = componentsBuilder.path("/cidade/{id}").buildAndExpand(dadosDetalhamento.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamento);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCidade> atualizar(@RequestBody @Valid DadosAtualizarCidade dadosAtualizar) {
        DadosDetalhamentoCidade dadosDetalhamento = cidadeService.atualizar(dadosAtualizar);
        return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamento);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
