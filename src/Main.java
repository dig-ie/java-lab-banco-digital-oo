
public class Main {

	public static void main(String[] args) {
		/** Sobre o CPF que usei nesta instância de Cliente:
		 * 
		 * Instanciando com CPF gerado pelo site https://www.4devs.com.br/gerador_de_cpf, tendo em vista que a implementação do algoritmo de validação de CPF é baseada no algoritmo oficial da Receita Federal do Brasil e causa um erro ao passar quaisquer CPFs inválidos.
		 */
		
		PessoaFisica venilton = new PessoaFisica("554.724.390-60", "Venilton", 
												"12.345.678-9", "15/03/1985", "Engenheiro");
		
		PessoaJuridica empresaTech = new PessoaJuridica("111.444.777-35", "João Silva", 
														"12.345.678/0001-90", "Tech Solutions LTDA", 
														"TechSol", "Tecnologia", 25);
		
		System.out.println("=== DADOS DOS CLIENTES ===");
		System.out.println("Pessoa Física:");
		System.out.println(venilton);
		System.out.println();
		
		System.out.println("Pessoa Jurídica:");
		System.out.println(empresaTech);
		System.out.println();
		
		// Demonstrando regras de negócio específicas
		System.out.println("=== REGRAS DE NEGÓCIO ===");
		System.out.println("Pessoa Física - Limite de Crédito: R$ " + venilton.calcularLimiteCredito());
		System.out.println("Pessoa Física - Taxa de Juros: " + venilton.calcularTaxaJuros() + "%");
		System.out.println("Pessoa Física - Tem direito a desconto: " + venilton.temDireitoDesconto());
		System.out.println();
		
		System.out.println("Pessoa Jurídica - Limite de Crédito: R$ " + empresaTech.calcularLimiteCredito());
		System.out.println("Pessoa Jurídica - Taxa de Juros: " + empresaTech.calcularTaxaJuros() + "%");
		System.out.println("Pessoa Jurídica - Tem direito a desconto: " + empresaTech.temDireitoDesconto());
		System.out.println();
	
		Conta ccVenilton = new ContaCorrente(venilton);
		Conta poupancaVenilton = new ContaPoupanca(venilton);
		
		Conta ccEmpresa = new ContaCorrente(empresaTech);
		Conta poupancaEmpresa = new ContaPoupanca(empresaTech);

		ccVenilton.depositar(1000);
		ccVenilton.transferir(500, poupancaVenilton);
		
		ccEmpresa.depositar(5000);
		ccEmpresa.transferir(2000, poupancaEmpresa);
		
		System.out.println("=== EXTRATOS BANCÁRIOS ===");
		System.out.println("Conta Corrente - Venilton:");
		ccVenilton.imprimirExtrato();
		System.out.println();
		
		System.out.println("Conta Poupança - Venilton:");
		poupancaVenilton.imprimirExtrato();
		System.out.println();
		
		System.out.println("Conta Corrente - Tech Solutions:");
		ccEmpresa.imprimirExtrato();
		System.out.println();
		
		System.out.println("Conta Poupança - Tech Solutions:");
		poupancaEmpresa.imprimirExtrato();
	}

}
