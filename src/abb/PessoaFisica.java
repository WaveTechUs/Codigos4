package abb;

import java.util.ArrayList;

import modelo.Cliente;

public class PessoaFisica {
	public static No raiz;

	PessoaFisica() {
		raiz = null;
	}

	class No {
		No direita;
		No esquerda;
		int altura;
		Cliente cliente;
	}

	public void inserir(No raiz, Cliente clienteNovo) {
		// TODO: Verificar se o cpf já existe na árvore

	}

	public void apagar(No raiz, Cliente clienteApagar) {

	}

	public void esvaziar(No raiz) {

	}

	public Cliente procurar(No raiz, String cpf) {
		Cliente cliente = new Cliente();

		return cliente;
	}

	public Cliente atualizarSaldo(No raiz, String numeroConta) {
		Cliente cliente = new Cliente();

		return cliente;
	}

	public int quantidadeExistente(No raiz) {

		return 0;
	}

	public int quantidadeExistenteSaldo(No raiz, double saldoMinimo) {

		return 0;
	}

	public ArrayList<Cliente> gerarLista(No raiz, double saldoMinimo) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		return lista;
	}
}
