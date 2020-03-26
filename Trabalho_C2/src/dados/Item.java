package dados;

public class Item {

	private int codPassagem;
	private String nomePassageiro;
	private int telefone;
	private String destino;

	public Item(int codPassagem, String nomePassageiro, int telefone, String destino) {
		this.codPassagem = codPassagem;
		this.nomePassageiro = nomePassageiro;
		this.telefone = telefone;
		this.destino = destino;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDestino() {
		return destino;
	}

	public void setcodPassagem(int ch) {
		this.codPassagem = ch;
	}

	public int getcodPassagem() {
		return this.codPassagem;
	}

}
