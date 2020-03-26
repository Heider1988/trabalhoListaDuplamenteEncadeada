package duplamenteEncadeada;

import dados.Item;

public class ListaDupla {

	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public void setPrim(NoDupla novoNo) {
		this.prim = novoNo;
	}

	public NoDupla getPrim() {
		return this.prim;
	}

	public void setUlt(NoDupla novoNo) {
		this.ult = novoNo;
	}

	public NoDupla getUlt() {
		return this.ult;
	}

	public int setQuantNos(int valorNovo) {
		return this.quantNos = valorNovo;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public boolean eVazia() {
		return this.prim == null;
	}

	// INSERIR PASSAGEIRO NO FINAL DA FILA, SE ESTIVER VÁZIA CADASTRAR O PRIMEIRO NA
	// LISTA
	public void inserirUlt(Item elem) {
		NoDupla novoNo = new NoDupla(elem);

		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}

		this.ult = novoNo;
		this.quantNos++;
	}

	// PESQUISAR PASSAGEIRO NA LISTA
	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getcodPassagem() != chave)) {
			atual = atual.getProx();
		}

		return atual;
	}

	// REMOVER QUALQUER PASSAGEIRO
	public boolean removerNo(int chave) {
		NoDupla atual = this.prim;

		while ((atual != null) && (atual.getInfo().getcodPassagem() != chave)) {
			atual = atual.getProx();
		}

		if (atual == null) {
			return false;
		}

		else if (atual == this.prim) {
			this.prim = prim.getProx();
			if (this.prim == null)
				this.ult = null;
			else {
				this.prim.setAnt(null);
			}
		}

		else if (atual == this.ult) {
			this.ult = ult.getAnt();
			this.ult.setProx(null);
		} else {
			atual.getProx().setAnt(atual.getAnt());
			atual.getAnt().setProx(atual.getProx());
		}

		this.quantNos--;
		return true;
	}

	// TRANSFERIR PASSAGEIRO PARA OUTRA LISTA
	public void transPassageiro(ListaDupla lista2) {

		// L1 tem apenas um nó e L2 está vazia
		if (this.prim.getProx() == null && lista2.eVazia()) {
			lista2.prim = this.prim;
			lista2.ult = this.ult;
			this.prim = null;
			this.ult = null;

		}
		// Mais de 2 NÓS na L1 e L2 está vazia
		else if (this.prim != this.ult && lista2.eVazia()) {
			lista2.prim = this.ult;
			lista2.ult = this.ult;
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);

		}

		// L1 com apenas 1 Nó e L2 com 1 NÓ
		else if (this.prim.getProx() == null && !lista2.eVazia()) {
			lista2.prim.setProx(this.prim);
			lista2.ult = this.prim;
			lista2.ult.setAnt(lista2.ult.getAnt());
			lista2.ult.setProx(null);
			this.prim = null;
			this.ult = null;
		}

		// L1 com 2 NÓ e L2 tem mais de 1 NÓ
		else if (this.prim != this.ult && !lista2.eVazia()) {
			lista2.ult.setProx(this.ult);
			lista2.ult = this.ult;
			lista2.ult.setAnt(lista2.ult.getAnt());
			lista2.ult.setProx(null);
			this.prim.setProx(null);
			this.ult = this.prim;

		}

		// L1 com vários NÓS e L2 também
		else if (this.prim != this.ult && !lista2.eVazia()) {
			lista2.ult.setProx(this.ult);
			lista2.ult = this.ult;
			lista2.ult.setAnt(lista2.ult.getAnt());
			lista2.ult.setProx(null);
			this.ult.setAnt(null);
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);

		}

		this.quantNos--;
		lista2.quantNos++;

	}

	// IMPRIMIR LISTA
	public String toString() {
		String msg = "";
		NoDupla atual = this.prim;
		while (atual != null) {
			msg += "Código: " + atual.getInfo().getcodPassagem() + "\n" + "Nome: " + atual.getInfo().getNomePassageiro()
					+ "\n" + "Telefone: " + atual.getInfo().getTelefone() + "\n" + "Destino: "
					+ atual.getInfo().getDestino() + "\n";

			atual = atual.getProx();
		}

		return msg;
	}

}
