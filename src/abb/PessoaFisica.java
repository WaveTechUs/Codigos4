package abb;

import java.util.ArrayList;

import modelo.Cliente;

public class PessoaFisica {
	public static No raiz;

	PessoaFisica() {
		raiz = null;
	}

	class No {
		No direita = null;
		No esquerda = null;
		int altura = 1;
		Cliente cliente;
	}

	private int obterAltura(No raiz) {
		if (raiz == null)
			return 0;
		return Math.max(obterAltura(raiz.esquerda), obterAltura(raiz.direita)) + 1;
	}
	
	private int fatorBalaceador(No raiz) {
		int direita = obterAltura(raiz.direita);
		int esquerda = obterAltura(raiz.esquerda);
		return esquerda - direita;
	}
	
	private No rotacaoEsquerda(No raiz) {
		No direita = raiz.direita;
		No centro = direita.esquerda;

		direita.esquerda = raiz;
		raiz.direita = centro;

		return direita;
	}

	private No rotacaoDireita(No raiz) {
		No esquerda = raiz.esquerda;
		No centro = esquerda.direita;

		esquerda.direita = raiz;
		raiz.esquerda = centro;

		return esquerda;
	}
	
	private No balancear(No raiz) {
		int fb = fatorBalaceador(raiz);
		
		if(fb > 1) {
			if(fatorBalaceador(raiz.esquerda) < 0)
				raiz.esquerda = rotacaoEsquerda(raiz.esquerda);

			raiz = rotacaoDireita(raiz);
		}
		
		if(fb < -1) {
			if(fatorBalaceador(raiz.direita) > 1)
				raiz.direita = rotacaoDireita(raiz.direita);
			
			raiz = rotacaoEsquerda(raiz);
		}

		return raiz;
	}
	
	private void atualizarAltura(No raiz) {
		if(raiz == null) return;
		
		atualizarAltura(raiz.esquerda);
		atualizarAltura(raiz.direita);
		raiz.altura = obterAltura(raiz);
	}

	public No inserir(No raiz, Cliente clienteNovo) {
		// TODO: Verificar se o cpf já existe na árvore
		if (raiz == null) {
			raiz = new No();
			raiz.cliente = clienteNovo;
			return raiz;
		}

		if (clienteNovo.getSaldoAplicacao() < raiz.cliente.getSaldoAplicacao()) {
			raiz.esquerda = inserir(raiz.esquerda, clienteNovo);
			raiz.esquerda.altura = obterAltura(raiz.esquerda);
		}

		if (clienteNovo.getSaldoAplicacao() < raiz.cliente.getSaldoAplicacao()) {
			raiz.direita = inserir(raiz.direita, clienteNovo);
			raiz.direita.altura = obterAltura(raiz.direita);
		}
		
		raiz = balancear(raiz);
		atualizarAltura(raiz);

		return raiz;
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
