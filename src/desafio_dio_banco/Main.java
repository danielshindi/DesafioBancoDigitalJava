package desafio_dio_banco;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		banco.setNome("Banco Java");
		

		menu(banco);
		sc.close();
		
		banco.listarClientes();
		banco.listarContas();

		
	}
	
	public static void menu(Banco banco) {
		while (true) {
		
			System.out.println("========== Menu ==========");
			System.out.println("1 - Cadastrar cliente\n2 - Criar conta\n3 - Depositar\n4 - Sacar\n5 - Transferir\n6 - Imprimir extrato\n0 - Sair");
			String opcao = sc.next();
			
			if (opcao.equals("1")) banco.cadastrarCliente();
			else if (opcao.equals("2")) {
				System.out.println("Digite o CPF: ");
				String cpf = sc.next();
				banco.criarConta(banco.encontrarCliente(cpf));	
				
			}
			else if (opcao.equals("3")) {
				System.out.println("Conta: ");
				int numeroConta = sc.nextInt();
				Conta conta = banco.encontrarConta(numeroConta);
				System.out.println("Valor: ");
				double valor = sc.nextDouble();
				conta.depositar(valor);
			}
			else if (opcao.equals("4")) {
				System.out.println("Conta: ");
				int numeroConta = sc.nextInt();
				Conta conta = banco.encontrarConta(numeroConta);
				System.out.println("Valor: ");
				double valor = sc.nextDouble();
				conta.sacar(valor);
			}
			else if (opcao.equals("5")) {
				System.out.println("Conta origem: ");
				int numeroConta = sc.nextInt();
				Conta conta = banco.encontrarConta(numeroConta);
				System.out.println("Valor: ");
				double valor = sc.nextDouble();
				System.out.println("Conta destino: ");
				numeroConta = sc.nextInt();
				Conta contaDestino = banco.encontrarConta(numeroConta);
				conta.transferir(valor, contaDestino);
			}
			else if (opcao.equals("6")) {
				System.out.println("Conta: ");
				int numeroConta = sc.nextInt();
				Conta conta = banco.encontrarConta(numeroConta);
				conta.imprimirExtrato();
				
			}
			else if (opcao.equals("0")) break;
			else {
				System.out.println("Opção inválida.");
			}
			
		}
		
	}

	

}



