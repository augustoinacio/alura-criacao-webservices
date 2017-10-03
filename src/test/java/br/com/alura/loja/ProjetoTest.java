package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {

	HttpServer server = new HttpServer();

	@Before
	public void inicia() {
		server = Servidor.startaServidor();
	}

	@Test
	public void testaConsultaProjetos() {
		ProjetoDAO banco = new ProjetoDAO();
		Projeto projeto = banco.busca(1l);
		Assert.assertTrue(projeto.getNome().equalsIgnoreCase("Minha loja"));

	}

	@Test
	public void testaConexaoComServidorFuncionaNoPathDeProjetos() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Projeto conteudo = target.path("/projetos/1").request().get(Projeto.class);
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.getNome().contains("Minha loja"));
	}

	@After
	public void finalizaServer() {
		server.stop();
	}
}
