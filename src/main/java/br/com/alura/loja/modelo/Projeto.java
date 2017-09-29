package br.com.alura.loja.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {

	private long id;
	private String nome;
	private int anoInicio;
	private List<Projeto> projetos = new ArrayList<Projeto>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public Projeto(long id, String nome, int anoInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoInicio = anoInicio;
	}

	public Projeto() {
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	public void remove(long id) {
		for (Iterator iterator = projetos.iterator(); iterator.hasNext();) {
			Projeto projeto = (Projeto) iterator.next();
			if (projeto.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Projeto adiciona(Projeto projeto) {
			projetos.add(projeto);
			return this;
	}

}
