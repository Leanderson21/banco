package banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import banco.model.Pessoa;
import banco.service.PessoaService;
import jakarta.validation.Valid;

@Controller
public class PessoaController {

	@Autowired
	PessoaService Pservice;
	
	
	@GetMapping("/pessoas")
	public ModelAndView listarPessoas() {
	    ModelAndView mv = new ModelAndView("cadastrarPessoa");
	    List<Pessoa> pessoas = Pservice.listarPessoas();
	    mv.addObject("pessoas", pessoas);
	    return mv;
	}
	
	
	@GetMapping("/editar/{id}")
	public String editarPessoa(@PathVariable("id") int id) {
	    ModelAndView mv = new ModelAndView();
	   Pessoa pessoa = Pservice.buscarPessoaPorId(id);
	    mv.addObject("pessoa", pessoa);
	    return "redirect:/pessoas";
	}
	
	
	//@GetMapping("/editar/{id}")
	//public ModelAndView editarPessoa(@PathVariable("id") int id) {
	  //  ModelAndView mv = new ModelAndView("cadastrarPessoa");
	  //  List<Pessoa> pessoas = Pservice.listarPessoas(); // Lista de todas as pessoas
	   // Pessoa pessoa = Pservice.buscarPessoaPorId(id); // Pessoa específica para edição
	   // mv.addObject("pessoas", pessoas);
	   // mv.addObject("pessoa", pessoa);
	   // mv.addObject("novaPessoa", new Pessoa()); // Adicione um novo objeto Pessoa com o nome "novaPessoa" ao modelo
	   // return mv;
	//}
	
	@GetMapping("/pessoa/{id}")
	public ModelAndView buscarPessoa(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("cadastrarPessoa");
		Pessoa pessoa = Pservice.buscarPessoaPorId(id);
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	@PostMapping("/cadastrar/pessoa")
	public String cadastrar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes ){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos obrigatórios");
			return "redirect:/pessoas";
		}
		Pservice.salvarPessoa(pessoa);
		return "redirect:/pessoas";
	}
	
	
	
}
