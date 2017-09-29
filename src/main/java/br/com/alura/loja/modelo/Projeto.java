package br.com.alura.loja.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {

	private long id;
	private String nome;
	private int anoInicio;

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

}
