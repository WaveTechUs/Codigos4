package abb;

import java.util.ArrayList;

import modelo.Cliente;

public class PessoaFisica {
	No raiz;

	public class No {
		No direita = null;
		No esquerda = null;
		int altura = 1;
		Cliente cliente;
	}

	public No init() {
		raiz = null;
		return raiz;
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

		if (fb > 1) {
			if (fatorBalaceador(raiz.esquerda) < 0)
				raiz.esquerda = rotacaoEsquerda(raiz.esquerda);

			raiz = rotacaoDireita(raiz);
		}

		if (fb < -1) {
			if (fatorBalaceador(raiz.direita) > 1)
				raiz.direita = rotacaoDireita(raiz.direita);

			raiz = rotacaoEsquerda(raiz);
		}

		return raiz;
	}

	private void atualizarAltura(No raiz) {
		if (raiz == null)
			return;

		atualizarAltura(raiz.esquerda);
		atualizarAltura(raiz.direita);
		raiz.altura = obterAltura(raiz);
	}

	private Cliente obterSaldoMinimo(No raiz) {
		while (raiz.esquerda != null) {
			raiz = raiz.esquerda;
		}
		return raiz.cliente;
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

		if (clienteNovo.getSaldoAplicacao() > raiz.cliente.getSaldoAplicacao()) {
			raiz.direita = inserir(raiz.direita, clienteNovo);
			raiz.direita.altura = obterAltura(raiz.direita);
		}

		raiz = balancear(raiz);
		atualizarAltura(raiz);

		return raiz;
	}

	public No apagar(No raiz, Cliente clienteApagar) {
		if (raiz == null)
			return raiz;
		else if (clienteApagar.getSaldoAplicacao() < raiz.cliente.getSaldoAplicacao())
			raiz.esquerda = apagar(raiz.esquerda, clienteApagar);
		else if (clienteApagar.getSaldoAplicacao() > raiz.cliente.getSaldoAplicacao())
			raiz.direita = apagar(raiz.direita, clienteApagar);
		else {
			if (raiz.esquerda == null && raiz.direita == null) {
				raiz = null;
				return raiz;
			} else if (raiz.esquerda == null) {
				raiz = raiz.direita;
			} else if (raiz.direita == null) {
				raiz = raiz.esquerda;
			} else {
				Cliente clienteSaldoMinimo = obterSaldoMinimo(raiz.direita);
				raiz.cliente = clienteSaldoMinimo;
				raiz.direita = apagar(raiz.direita, clienteSaldoMinimo);
			}
		}

		atualizarAltura(raiz);
		raiz = balancear(raiz);
		atualizarAltura(raiz);

		return raiz;
	}

	public ArrayList<Cliente> esvaziar(No raiz) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		esvaziarHelper(raiz, lista);
		return lista;
	}

	private void esvaziarHelper(No raiz,ArrayList<Cliente> lista) {
		if (raiz == null)
			return;

		esvaziarHelper(raiz.esquerda, lista);
		esvaziarHelper(raiz.direita, lista);
		lista.add(raiz.cliente);
		raiz = null;
	}

	public Cliente procurar(No raiz, String cpf) {
		return procurarAjuda(raiz, cpf);
	}

	private Cliente procurarAjuda(No raiz, String cpf) {
		if (raiz == null)
			return null;

		if (raiz.cliente.getCpfcnpj().equals(cpf))
			return raiz.cliente;

		Cliente encontradoNaEsquerda = procurarAjuda(raiz.esquerda, cpf);
		if (encontradoNaEsquerda != null) {
			return encontradoNaEsquerda;
		}

		return procurarAjuda(raiz.direita, cpf);
	}

	public Cliente atualizarSaldo(No raiz, double numeroConta, double saldoNovo) {
		return atualizarSaldoAjuda(raiz, numeroConta, saldoNovo);
	}

	private Cliente atualizarSaldoAjuda(No raiz, double numeroConta, double saldoNovo) {
		if (raiz == null)
			return null;

		if (raiz.cliente.getNumeroConta() == numeroConta) {
			raiz.cliente.setSaldoAplicacao(saldoNovo);
			return raiz.cliente;
		}

		Cliente encontradoNaEsquerda = atualizarSaldoAjuda(raiz.esquerda, numeroConta, saldoNovo);
		if (encontradoNaEsquerda != null) {
			return encontradoNaEsquerda;
		}

		return atualizarSaldoAjuda(raiz.direita, numeroConta, saldoNovo);
	}

	public int quantidadeExistente(No raiz) {
		if (raiz == null)
			return 0;
		if (raiz.esquerda == null && raiz.direita == null)
			return 1;

		int totalEsquerda = quantidadeExistente(raiz.esquerda);
		int totalDireita = quantidadeExistente(raiz.direita);
		return totalEsquerda + totalDireita;
	}

	public int quantidadeExistenteSaldo(No raiz, double saldoMinimo) {
		if (raiz == null)
			return 0;

		if (raiz.esquerda == null && raiz.direita == null)
			if (raiz.esquerda.cliente.getSaldoAplicacao() >= saldoMinimo
					&& raiz.direita.cliente.getSaldoAplicacao() >= saldoMinimo)
				return 1;

		int totalEsquerda = quantidadeExistente(raiz.esquerda);
		int totalDireita = quantidadeExistente(raiz.direita);
		return totalEsquerda + totalDireita;
	}

	public ArrayList<Cliente> gerarLista(No raiz, double saldoMinimo) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		gerarListaHelper(raiz, saldoMinimo, lista);
		return lista;
	}

	private void gerarListaHelper(No raiz, double saldoMinimo, ArrayList<Cliente> lista) {
		if (raiz == null)
			return;

		gerarListaHelper(raiz.esquerda, saldoMinimo, lista);
		if (raiz.cliente.getSaldoAplicacao() >= saldoMinimo)
			lista.add(raiz.cliente);
		gerarListaHelper(raiz.direita, saldoMinimo, lista);
	}
}
