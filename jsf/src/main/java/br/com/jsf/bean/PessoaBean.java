package br.com.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jsf.dao.DaoGeneric;
import br.com.jsf.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public String salvar() {
		daoGeneric.salvar(pessoa);
		pessoa = new Pessoa();
		carregaPessoas();
		return "";
	}

	public String modificar() {
		pessoa = daoGeneric.merge(pessoa);
		carregaPessoas();
		return "";
	}

	@PostConstruct
	public void carregaPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public String novo() {
		pessoa = new Pessoa();
		return "";
	}

	public String delete() {
		daoGeneric.deleteById(pessoa);
		novo();
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
