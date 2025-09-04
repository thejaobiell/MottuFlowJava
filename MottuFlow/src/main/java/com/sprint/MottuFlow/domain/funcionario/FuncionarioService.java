package com.sprint.MottuFlow.domain.funcionario;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
		
		if ( funcionarioAtualizado.getNome() != null && !funcionarioAtualizado.getNome().isBlank() ) {
			funcionario.setNome( funcionarioAtualizado.getNome() );
		}
		
		if ( funcionarioAtualizado.getCpf() != null && !funcionarioAtualizado.getCpf().isBlank() ) {
			funcionario.setCpf( funcionarioAtualizado.getCpf() );
		}
		
		if ( funcionarioAtualizado.getCargo() != null && !funcionarioAtualizado.getCargo().isBlank() ) {
			funcionario.setCargo( funcionarioAtualizado.getCargo() );
		}
		
		if ( funcionarioAtualizado.getTelefone() != null && !funcionarioAtualizado.getTelefone().isBlank() ) {
			funcionario.setTelefone( funcionarioAtualizado.getTelefone() );
		}
		
		if ( funcionarioAtualizado.getEmail() != null && !funcionarioAtualizado.getEmail().isBlank() ) {
			funcionario.setEmail( funcionarioAtualizado.getEmail() );
		}
		
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
		return fR.findByEmailIgnoreCase( email ).orElseThrow( () -> new UsernameNotFoundException( "O usuário não foi encontrado!" ) );
	}
	
	@Transactional
	public void atualizarRefreshToken( Funcionario funcionario, String refreshToken, LocalDateTime expiracao ) {
		funcionario.setRefreshToken( refreshToken );
		funcionario.setExpiracaoRefreshToken( expiracao );
		fR.save( funcionario );
	}
	
	@Transactional
	public Funcionario validarRefreshToken( String refreshToken ) {
		Funcionario funcionario = fR.findByRefreshToken( refreshToken ).orElseThrow( () -> new RegraDeNegocioException( "Refresh token inválido!" ) );
		
		if ( funcionario.getExpiracaoRefreshToken().isBefore( LocalDateTime.now() ) ) {
			throw new RegraDeNegocioException( "Refresh token expirado!" );
		}
		
		return funcionario;
	}
}
