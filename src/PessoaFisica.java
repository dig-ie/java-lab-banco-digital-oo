public class PessoaFisica extends Cliente {
	
	private String rg;
	private String dataNascimento;
	private String profissao;
	
	public PessoaFisica(String cpf, String nome, String rg, String dataNascimento, String profissao) {
		super(cpf, nome);
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.profissao = profissao;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@Override
	public double calcularLimiteCredito() {

		switch (profissao.toLowerCase()) {
			case "médico":
			case "advogado":
			case "engenheiro":
				return 5000.0;
			case "professor":
			case "contador":
				return 3000.0;
			default:
				return 1000.0;
		}
	}
	
	@Override
	public double calcularTaxaJuros() {

		return 2.5;
	}
	
	@Override
	public boolean temDireitoDesconto() {
		return true;
	}
	
	@Override
	public String getTipoCliente() {
		return "Pessoa Física";
	}
	
	@Override
	public String toString() {
		return "PessoaFisica{" +
				"cpf='" + getCpf() + '\'' +
				", nome='" + getNome() + '\'' +
				", rg='" + rg + '\'' +
				", dataNascimento='" + dataNascimento + '\'' +
				", profissao='" + profissao + '\'' +
				", limiteCredito=" + calcularLimiteCredito() +
				", taxaJuros=" + calcularTaxaJuros() + "%" +
				'}';
	}
}
