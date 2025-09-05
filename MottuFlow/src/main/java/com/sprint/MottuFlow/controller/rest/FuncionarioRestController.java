package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.funcionario.FuncionarioDTO;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioRestController {
	
	private final FuncionarioService fS;
	
	public FuncionarioRestController( FuncionarioService fS) {
		this.fS = fS;
	}

    private FuncionarioDTO convertToDTO(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getId_funcionario(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getCargo(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getSenha()
        );
    }

    private Funcionario convertToEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId_funcionario(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(dto.getSenha());
        return funcionario;
    }

    @GetMapping
    public List<FuncionarioDTO> getAll() {
        List<Funcionario> funcionarios = fS.listarFuncionarios();
        return funcionarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FuncionarioDTO> getById(@PathVariable Long id) {
        Funcionario funcionario = fS.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(convertToDTO(funcionario));
    }
    
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> getByCpf(@PathVariable String cpf) {
        Funcionario funcionario = fS.buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDTO(funcionario));
    }

    
    @PostMapping("/cadastro")
    public ResponseEntity<FuncionarioDTO> create(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = convertToEntity(funcionarioDTO);
        Funcionario saved = fS.cadastrarFuncionario(funcionario);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionarioDetails = convertToEntity(funcionarioDTO);
        Funcionario updated = fS.editarFuncionario(id, funcionarioDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fS.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
