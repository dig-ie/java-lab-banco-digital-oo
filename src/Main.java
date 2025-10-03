
public class Main {

	public static void main(String[] args) {
		/** Sobre o CPF que usei nesta instância de Cliente:
		 * 
		 * Instanciando com CPF gerado pelo site https://www.4devs.com.br/gerador_de_cpf, tendo em vista que a implementação do algoritmo de validação de CPF é baseada no algoritmo oficial da Receita Federal do Brasil e causa um erro ao passar quaisquer CPFs inválidos.
		 */
		Cliente venilton = new Cliente("554.724.390-60", "Venilton");
		venilton.setNome("Venilton");
		
		System.out.println("=== DADOS DO CLIENTE ===");
		System.out.println(venilton);
		System.out.println();
	
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
