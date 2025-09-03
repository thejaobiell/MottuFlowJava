package com.sprint.MottuFlow.domain.funcionario;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements UserDetailsService {
	
	
	private final FuncionarioRepository fR;
	private final PasswordEncoder encoder;
	
	public FuncionarioService( FuncionarioRepository fR, PasswordEncoder encoder ) {
		this.fR = fR;
		this.encoder = encoder;
	}
	
	public List<Funcionario> buscarFuncionarios() {
		return fR.findAll();
	}
	
	public Funcionario buscarPorIDFuncionario( Long id ) {
		return fR.findById( id ).orElseThrow( () -> new RegraDeNegocioException( "Funcionario não encontrado com id: " + id ) );
	}
	
	@Transactional
	public Funcionario BuscarPorCPFFuncionario( String cpf ) {
		return fR.findByCpfNative( cpf );
	}
	
	@Transactional
	public Funcionario cadastrarFuncionario( Funcionario funcionario ) {
		funcionario.setSenha( encoder.encode( funcionario.getSenha() ) );
		return fR.save( funcionario );
	}
	
	@Transactional
	public Funcionario editarFuncionario( Long id, Funcionario funcionarioAtualizado ) {
		Funcionario funcionario = buscarPorIDFuncionario( id );
		
		funcionario.setNome( funcionarioAtualizado.getNome() );
		funcionario.setCpf( funcionarioAtualizado.getCpf() );
		funcionario.setCargo( funcionarioAtualizado.getCargo() );
		funcionario.setTelefone( funcionarioAtualizado.getTelefone() );
		funcionario.setEmail( funcionarioAtualizado.getEmail() );
		if ( funcionarioAtualizado.getSenha() != null && !funcionarioAtualizado.getSenha().isBlank() ) {
			funcionario.setSenha( encoder.encode( funcionarioAtualizado.getSenha() ) );
		}
		
		return fR.save( funcionario );
	}
	
	@Transactional
	public void deletarFuncionario( Long id ) {
		Funcionario funcionario = buscarPorIDFuncionario( id );
		fR.delete( funcionario );
	}
	
	
	@Override
	public UserDetails loadUserByUsername( String email ) throws UsernameNotFoundException {
		return fR.findByEmailIgnoreCase( email )
				.orElseThrow( () -> new UsernameNotFoundException( "O usuário não foi encontrado!" ) );
	}
}
