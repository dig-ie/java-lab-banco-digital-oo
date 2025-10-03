public abstract class Cliente {
	private final String cpf;
	private String nome;

	public Cliente(String cpf, String nome) {
		if (!validarCPF(cpf)) {
			throw new IllegalArgumentException("CPF inválido: " + cpf);
		}
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	/**
	 * Valida um CPF usando o algoritmo oficial da Receita Federal do Brasil.
	 * <p>
	 * <strong>Implementação do algoritmo oficial:</strong>
	 * </p>
	 * <ol>
	 *   <li>Remove caracteres não numéricos</li>
	 *   <li>Verifica se possui exatamente 11 dígitos</li>
	 *   <li>Rejeita sequências com todos os dígitos iguais</li>
	 *   <li>Calcula primeiro dígito verificador: soma dos 9 primeiros dígitos multiplicados por 10,9,8,7,6,5,4,3,2</li>
	 *   <li>Calcula segundo dígito verificador: soma dos 10 primeiros dígitos multiplicados por 11,10,9,8,7,6,5,4,3,2</li>
	 *   <li>Valida se os dígitos calculados coincidem com os fornecidos</li>
	 * </ol>
	 * 
	 * @param cpf CPF a ser validado (pode conter formatação)
	 * @return {@code true} se o CPF for válido segundo o algoritmo oficial, {@code false} caso contrário
	 * 
	 * @see <a href="https://www.receita.fazenda.gov.br/Aplicacoes/ATBHE/CPF/ConsultaPublica.asp">Consulta CPF - Receita Federal</a>
	 */
	private boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("\\D", "");
		
		if (cpf.length() != 11) {
			return false;
		}
		
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}
		
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}
		int primeiroDigito = 11 - (soma % 11);
		primeiroDigito = primeiroDigito >= 10 ? 0 : primeiroDigito;
		if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigito) {
			return false;
		}
		
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		int segundoDigito = 11 - (soma % 11);
		segundoDigito = segundoDigito >= 10 ? 0 : segundoDigito;
		if (Character.getNumericValue(cpf.charAt(10)) != segundoDigito) {
			return false;
		}
		
		return true;
	}

	/**
	 * Calcula o limite de crédito específico para cada tipo de cliente
	 * @return valor do limite de crédito
	 */
	public abstract double calcularLimiteCredito();
	
	/**
	 * Calcula a taxa de juros específica para cada tipo de cliente
	 * @return taxa de juros em percentual
	 */
	public abstract double calcularTaxaJuros();
	
	/**
	 * @return true se tem direito a desconto
	 */
	public abstract boolean temDireitoDesconto();
	
	/**
	 * Retorna o tipo de cliente
	 * @return string identificando o tipo
	 */
	public abstract String getTipoCliente();

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", tipo='" + getTipoCliente() + '\'' +
				'}';
	}
}