package duplamenteEncadeada;

import java.util.Scanner;

import dados.Item;

public class Aplicativo {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ListaDupla listaRecife = new ListaDupla();
		ListaDupla listaFortaleza = new ListaDupla();
		ListaDupla listaJoaoPessoa = new ListaDupla();

		int valor;
		int codPassagem;
		int telContato;
		String nomePasageiro;
		String destPassageiro;

		NoDupla pesqNo = null;
		char opcao;

		do {
			opcao = menu();
			switch (opcao) {
			case '1':
				System.out.println("Digite 1 para cadastrar o passageiro para Recife, 2 para Fortaleza"
						+ " ou 3 para Jo�o Pessoa.");
				valor = scan.nextInt();

				System.out.println("C�digo da passagem: ");
				codPassagem = scan.nextInt();

				System.out.println("Nome do passageiro: ");
				nomePasageiro = scan.next();

				System.out.println("Telefone de contato: ");
				telContato = scan.nextInt();

				System.out.println("Destino do passageiro: ");
				destPassageiro = scan.next();

				if (valor == 1) {
					listaRecife.inserirUlt(new Item(codPassagem, nomePasageiro, telContato, destPassageiro));
				} else if (valor == 2) {
					listaFortaleza.inserirUlt(new Item(codPassagem, nomePasageiro, telContato, destPassageiro));
				} else if (valor == 3) {
					listaJoaoPessoa.inserirUlt(new Item(codPassagem, nomePasageiro, telContato, destPassageiro));
				}
				System.out.println("\n");
				break;

			case '2':
				System.out.println("Informe o c�digo de passagem a ser procurado");
				valor = scan.nextInt();
				System.out.println("Informe o destino: 1.P/ Recife - 2.P/ Fortaleza - 3.P/ Jo�o Pessoa.");
				int destino = scan.nextInt();
				if (destino == 1) {
					pesqNo = listaRecife.pesquisarNo(valor);
					if (pesqNo == null) {
						System.out.println("O " + valor + " n�o foi localizado");
					} else
						System.out.println("O " + pesqNo.getInfo().getcodPassagem() + " foi achado na lista.\n");
				}
				if (destino == 2) {
					pesqNo = listaFortaleza.pesquisarNo(valor);
					if (pesqNo == null) {
						System.out.println("O " + valor + " n�o foi localizado");
					} else
						System.out.println("O " + pesqNo.getInfo().getcodPassagem() + " foi achado na lista.\n");
				}
				if (destino == 3) {
					pesqNo = listaJoaoPessoa.pesquisarNo(valor);
					if (pesqNo == null) {
						System.out.println("O " + valor + " n�o foi localizado");
					} else
						System.out.println("O " + pesqNo.getInfo().getcodPassagem() + " foi achado na lista.");
				}
				break;

			case '3':
				System.out.println("Digite o c�digo da passagem a ser removido");
				valor = scan.nextInt();
				System.out.println("Informe o destino: 1.P/ Recife - 2.P/ Fortaleza - " + "3.P/ Jo�o Pessoa.");
				int localidade = scan.nextInt();
				if (localidade == 1) {
					if (listaRecife.removerNo(valor)) {
						System.out.println("Remo��o efetuada.");
					} else {
						System.out.println("Remo��o n�o efetuada.");
					}
				} else if (localidade == 2) {
					if (listaFortaleza.removerNo(valor)) {
						System.out.println("Remo��o efetuada.");
					} else {
						System.out.println("Remo��o n�o efetuada.");
					}
				} else if (localidade == 3) {
					if (listaJoaoPessoa.removerNo(valor)) {
						System.out.println("Remo��o efetuada.");
					} else {
						System.out.println("Remo��o n�o efetuada.");
					}
				}
				break;
			case '4':
				System.out.println(
						"Exibir dados dos passageiros: 1.P/ lista de Recife - " + "2.P/ Fortaleza - 3.P/ Jo�o Pessoa.");
				valor = scan.nextInt();
				if (valor == 1) {
					System.out.println("lista de Recife:\n" + listaRecife.toString());
				} else if (valor == 2) {
					System.out.println("lista de Fortaleza:\n" + listaFortaleza.toString());
				} else if (valor == 3) {
					System.out.println("lista de Jo�o Pessoa:\n" + listaJoaoPessoa.toString());
				}
				break;

			// CASE TRANSFERIR PASSAGEIRO
			case '5':
				System.out.println("Informe o c�digo do passageiro a ser transferido: ");
				codPassagem = scan.nextInt();

				System.out.println("Informe para onde deseja transferir:\n" + "1.Recife P/ Fortaleza\n"
						+ "2.Recife P/ Jo�o Pessoa\n" + "3.Jo�o Pessoa P/ Recife\n" + "4.Fortaleza P/ Recife\n");
				valor = scan.nextInt();

				int codTrans = codPassagem;

				if (valor == 1) {
					if (listaRecife.pesquisarNo(codPassagem) != null) {
						codTrans = codPassagem;
						if (listaRecife.getPrim().getInfo().getcodPassagem() == codTrans) {
							listaRecife.transPassageiro(listaFortaleza);
							System.out.println("Transferido com sucesso!\n");
						}
					}
				}

				if (valor == 2) {
					if (listaRecife.pesquisarNo(codPassagem) != null) {
						codTrans = codPassagem;
						if (listaRecife.getPrim().getInfo().getcodPassagem() == codTrans) {
							listaRecife.transPassageiro(listaJoaoPessoa);
							System.out.println("Transferido com sucesso!\n");
						}
					}
				}
				if (valor == 3) {
					if (listaJoaoPessoa.pesquisarNo(codPassagem) != null) {
						codTrans = codPassagem;
						if (listaJoaoPessoa.getPrim().getInfo().getcodPassagem() == codTrans) {
							listaJoaoPessoa.transPassageiro(listaRecife);
							System.out.println("Transferido com sucesso!\n");
						}
					}
				}

				if (valor == 4) {
					if (listaFortaleza.pesquisarNo(codPassagem) != null) {
						codTrans = codPassagem;
						if (listaFortaleza.getPrim().getInfo().getcodPassagem() == codTrans) {
							listaFortaleza.transPassageiro(listaRecife);
							System.out.println("Transferido com sucesso!\n");
						}
					}
				}

				else if (listaFortaleza.pesquisarNo(codPassagem) == null && listaRecife.pesquisarNo(codPassagem) == null
						&& listaJoaoPessoa.pesquisarNo(codPassagem) == null) {
					System.out.println("C�digo n�o localizado nas listas.\n");
				}

				break;

			case '6':
				System.out.println("Fim do programa");

			}
		} while (opcao != '6');
		System.exit(0);

	}

	public static char menu() {
		System.out.println("Escolha uma op��o:\n" + "1.Inclus�o de passageiros ao fim da lista de passageiros \n"
				+ "2.Apresentar dados de passageiros de acordo com o c�digo da passagem pesquisado \n"
				+ "3.Exclus�o de passageiro da lista de acordo com o c�digo de passagem \n"
				+ "4.Apresentar dados dos passageiros de um determinado v�o \n"
				+ "5.Transfer�ncia de passageiro de um v�o para outro destino\n" + "6.para sair."

		);

		return scan.next().charAt(0);
	}

}
