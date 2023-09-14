package banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.model.Pessoa;
import banco.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	public void salvarPessoa(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public List<Pessoa> listarPessoas(){
		return repository.findAll();
	}
	
	public Pessoa buscarPessoaPorId(int idPessoa) {
		return repository.findById(idPessoa).get();
	}
	
	
}
