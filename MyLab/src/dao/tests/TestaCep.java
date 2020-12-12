package dao.tests;

import javax.persistence.Column;

import model.Endereco;
import util.WebServiceCep;

public class TestaCep {
	public static void main(String[] args) {
		WebServiceCep busca = WebServiceCep.searchCep("88110-400");
		Endereco end = new Endereco();
		end.setLogradouro(busca.getLogradouro());
		end.setBairro(busca.getBairro());
		end.setCidade(busca.getCidade());
		end.setEstado(busca.getUf());
		
	}
}
