public class PessoaJuridica extends Cliente {
	
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String ramoAtividade;
	private int numeroFuncionarios;
	
	public PessoaJuridica(String cpf, String nome, String cnpj, String razaoSocial, 
						  String nomeFantasia, String ramoAtividade, int numeroFuncionarios) {
		super(cpf, nome);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.ramoAtividade = ramoAtividade;
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}
	
	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public double calcularLimiteCredito() {
		double limiteBase = numeroFuncionarios * 1000.0;
		
		switch (ramoAtividade.toLowerCase()) {
			case "tecnologia":
			case "finanças":
				return limiteBase * 1.5; // 50% a mais
			case "comércio":
			case "indústria":
				return limiteBase * 1.2; // 20% a mais
			case "serviços":
				return limiteBase * 1.1; // 10% a mais
			default:
				return limiteBase;
		}
	}
	
	@Override
	public double calcularTaxaJuros() {

		return 3.5;
	}
	
	@Override
	public boolean temDireitoDesconto() {
		return numeroFuncionarios >= 50;
	}
	
	@Override
	public String getTipoCliente() {
		return "Pessoa Jurídica";
	}
	
	@Override
	public String toString() {
		return "PessoaJuridica{" +
				"cpf='" + getCpf() + '\'' +
				", nome='" + getNome() + '\'' +
				", cnpj='" + cnpj + '\'' +
				", razaoSocial='" + razaoSocial + '\'' +
				", nomeFantasia='" + nomeFantasia + '\'' +
				", ramoAtividade='" + ramoAtividade + '\'' +
				", numeroFuncionarios=" + numeroFuncionarios +
				", limiteCredito=" + calcularLimiteCredito() +
				", taxaJuros=" + calcularTaxaJuros() + "%" +
				'}';
	}
}
