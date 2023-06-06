package br.com.sysprise.endereco.controller;


import br.com.sysprise.endereco.model.estado.*;
import br.com.sysprise.endereco.service.EstadoService;
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
@RequestMapping("/estado")
@AllArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    @Cacheable("estados")
    public ResponseEntity<Page<DadosListagemEstado>> listar(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
        Page<DadosListagemEstado> dadosListagem = estadoService.listar(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(dadosListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEstado> detalhar(@PathVariable("id") Long id) {
        DadosDetalhamentoEstado dadosDetalhamento = estadoService.detalhar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamento);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEstado> cadastrar(@RequestBody @Valid DadosCadastroEstado dadosCadastro, UriComponentsBuilder componentsBuilder) {
        DadosDetalhamentoEstado dadosDetalhamento = estadoService.cadastrar(dadosCadastro);
        URI uri = componentsBuilder.path("/estado/{id}").buildAndExpand(dadosDetalhamento.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamento);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEstado> atualizar(@RequestBody @Valid DadosAtualizarEstado dadosAtualizar) {
        DadosDetalhamentoEstado dadosDetalhamento = estadoService.atualizar(dadosAtualizar);
        return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamento);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        estadoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
