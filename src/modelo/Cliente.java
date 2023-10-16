package modelo;

public class Cliente {
	String nomeString;
	String cpfcnpj;
	int numeroConta;
	String tipoConta;
	double saldoAplicacao;

	public Cliente(String nomeString, String cpfcnpj, int numeroConta, String tipoConta, double saldoAplicacao) {
		super();
		this.nomeString = nomeString;
		this.cpfcnpj = cpfcnpj;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.saldoAplicacao = saldoAplicacao;
	}

	@Override
	public String toString() {
		String toString = "Nome: " + nomeString + "\n" + 
						  "CPF/CNPJ: " + cpfcnpj + "\n" + 
						  "Número da Conta: " + numeroConta + "\n" + 
						  "Tipo da Conta: " + tipoConta + "\n" + 
						  "Saldo da Aplicação: " + saldoAplicacao + "\n";
		
		return toString;
	}

	public String getNomeString() {
		return nomeString;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public double getSaldoAplicacao() {
		return saldoAplicacao;
	}
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public void setSaldoAplicacao(double saldoAplicacao) {
		this.saldoAplicacao = saldoAplicacao;
	}
}
