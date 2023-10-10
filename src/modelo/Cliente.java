package modelo;

public class Cliente {
	String nomeString;
	String cpfcnpj;
	String numeroConta;
	String tipoConta;
	double saldoAplicacao;

	@Override
	public String toString() {
		return "Cliente [nomeString=" + nomeString + ", cpfcnpj=" + cpfcnpj + ", numeroConta=" + numeroConta
				+ ", tipoConta=" + tipoConta + ", saldoAplicacao=" + saldoAplicacao + "]";
	}

	public String getNomeString() {
		return nomeString;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public String getNumeroConta() {
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
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public void setSaldoAplicacao(double saldoAplicacao) {
		this.saldoAplicacao = saldoAplicacao;
	}
}
