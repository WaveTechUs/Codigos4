package menu;

import java.util.Scanner;

import abb.PessaABB.No;
import abb.PessoaFisica;
import abb.PessoaJuridica;
import modelo.Cliente;

/*
 * Erik Giuseppe Kato Bandeira 92988
 * João Tancredi Dela Rocca 93527
 * Matheus Stelutti Sepulveda 96272
 * Rafael Ioshi Imamura Pereira 93102/
 */

public class Menu {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);

		PessoaFisica arvorePF = new PessoaFisica();
		No raizPF = arvorePF.init();

		PessoaJuridica arvorePJ = new PessoaJuridica();
		No raizPJ = arvorePJ.init();

		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		String tipoConta = null;
		double saldo;

		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscrição cliente");
			System.out.println(" 2 - Oferta de novo serviço e/ou aplicação");
			System.out.println(" 3 – Entrar no Submenu ");
			opcao = le.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite nome: ");
				nome = le.next();
				System.out.print("Digite cpf/cnpj: ");
				cpfCnpj = le.next();
				System.out.print("Digite número da conta: ");
				numeroConta = le.nextInt();
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();
				if (op == 1) {
					Cliente pf = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);
					raizPF = arvorePF.inserir(raizPF, pf);
				} else if (op == 2) {
					Cliente pj = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);
					raizPJ = arvorePJ.inserir(raizPJ, pj);
				}
				break;
			case 2:
				System.out.print("Qual tipo de conta a oferta se destina? ");
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				saldo = le.nextDouble();
				/*
				 * Fazendo uso de um método da classe ABB, desenvolvido para este problema, uma
				 * lista de clientes aptos para a oferta é gerada. Nesse trecho de programa que
				 * tentar fazer o contato com todos os clientes presente na lista.
				 */
				break;
			case 3:
				System.out.print("Qual tipo de conta a oferta se destina? ");
				int opTipoConta = -1;
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					opTipoConta = le.nextInt();
					switch (opTipoConta) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						opTipoConta = -1;
					}
				} while (opTipoConta == -1);
				do {
					System.out.println(" 1 - Consultar cliente por cpf/cnpj");
					System.out.println(" 2 - Atualizar saldo por número da conta");
					System.out.println(" 3 – Quantidade de clientes na ABB");
					System.out.println(" 4 – Quantidade de clientes com saldo acima de um valor");
					System.out.println(" 5 - Voltar ao menu principal");
					op = le.nextInt();
					switch (op) {
					case 1:
						if (opTipoConta == 1) {
							System.out.println("Digite o cpf para consultar o cliente");
							cpfCnpj = le.next();
							Cliente pf = arvorePF.procurar(raizPF, cpfCnpj);
							System.out.println(pf);
						} else {
							System.out.println("Digite o cnpj para consultar o cliente");
							cpfCnpj = le.next();
							Cliente pj = arvorePJ.procurar(raizPJ, cpfCnpj);
							System.out.println(pj);
						}
						break;
					case 2:
						if (opTipoConta == 1) {
							System.out.println("Digite o número da conta");
							numeroConta = le.nextInt();
							System.out.println("Digite o novo saldo da conta");
							saldo = le.nextInt();
							Cliente pf = arvorePF.atualizarSaldo(raizPF, numeroConta, saldo);
							System.out.println(pf);
						} else {
							System.out.println("Digite o número da conta");
							numeroConta = le.nextInt();
							System.out.println("Digite o novo saldo da conta");
							saldo = le.nextInt();
							Cliente pj = arvorePJ.atualizarSaldo(raizPJ, numeroConta, saldo);
							System.out.println(pj);
						}
						break;
					case 3:
						if (opTipoConta == 1) {
							int quantidade = arvorePF.quantidadeExistente(raizPF);
							System.out.println("Existem " + quantidade);
						} else {
							int quantidade = arvorePJ.quantidadeExistente(raizPJ);
							System.out.println("Existem " + quantidade);
						}
						break;
					case 4:
						if (opTipoConta == 1) {
							System.out.println("Digite o saldo mínimo");
							saldo = le.nextInt();
							int quantidade = arvorePF.quantidadeExistenteSaldo(raizPF, saldo);
							System.out.println("Existem " + quantidade + " com o saldo de no mínimo " + saldo);
						} else {
							System.out.println("Digite o saldo mínimo");
							saldo = le.nextInt();
							int quantidade = arvorePJ.quantidadeExistenteSaldo(raizPJ, saldo);
							System.out.println("Existem " + quantidade + " com o saldo de no mínimo " + saldo);
						}
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				break;
			}
		} while (opcao != 0);
		System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
		/*
		 * Esvazia as ABBs apresentando todos os clientes que aguardam nova portunidade
		 */
		le.close();

	}

}
