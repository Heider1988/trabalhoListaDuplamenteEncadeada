package duplamenteEncadeada;

import dados.Item;

public class NoDupla {

	private Item info;
	private NoDupla prox;
	private NoDupla ant;

	public NoDupla(Item elem) {
		this.info = elem;
		this.prox = null;
		this.ant = null;
	}

	public void setProx(NoDupla novoNo) {
		this.prox = novoNo;
	}

	public NoDupla getProx() {
		return this.prox;
	}

	public void setAnt(NoDupla novoNo) {
		this.ant = novoNo;
	}

	public NoDupla getAnt() {
		return this.ant;
	}

	public Item getInfo() {
		return this.info;
	}

}
