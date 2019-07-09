package br.com.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private String nome;
	
	private HtmlCommandButton commandButton;

	private List<String> nomes = new ArrayList<String>();

	public String addNome() {
		nomes.add(nome);
		if (nomes.size() > 2) {
			commandButton.setDisabled(true);
			return "paginanavagada";
		}
		return ""; // null ou vazio fica na mesma pagina - > outcome
	}
	
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
