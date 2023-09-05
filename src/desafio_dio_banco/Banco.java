package desafio_dio_banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
	private String nome;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Conta> contas = new ArrayList<Conta>();
	
	static Scanner sc = new Scanner(System.in);
	
	public void cadastrarCliente() {
		
			Cliente cliente = new Cliente();
			
			System.out.println("Nome: ");
			cliente.setNome(sc.next());
			System.out.println("CPF: ");
			cliente.setCpf(sc.next());
			System.out.println("Telefone: ");
			cliente.setTelefone(sc.next());
			System.out.println("Endereço: ");
			cliente.setEndereco(sc.next());
			
			clientes.add(cliente);
			
		}
		
	
	
	public void criarConta(Cliente cliente) {
		
		String opcao = "";
		System.out.println("Tipo de conta:\n[1] - Conta corrente\n[2] - Conta poupança");
		do {
			
			opcao = sc.next();
			
			
		}
		while (!opcao.equals("1") && !opcao.equals("2"));
		
		if (opcao.equals("1")) {
			Conta conta = new ContaCorrente(cliente);
			contas.add(conta);
			System.out.println("criando conta corrente");
		}
		else {
			Conta conta = new ContaPoupanca(cliente);
			contas.add(conta);
			System.out.println("criando conta poupança");
		}
		
	}
	
	
	public Conta encontrarConta (int numeroConta) {
		for (Conta conta : this.getContas()) {
			if (conta.getNumero() == numeroConta) {
				return conta;
			}
		}
		return null;
	}
	
	public void listarContas() {
		for (Conta conta : this.getContas())
				System.out.println("Agência: " + conta.getAgencia() + "\tConta: "+ conta.getNumero() + "\tCliente: " + conta.getCliente().getNome() + "\tSaldo:" + conta.getSaldo());
		
	}
	
	
	public void listarClientes() {
		for (Cliente cliente: this.getClientes()) {
			System.out.println("Nome: " + cliente.getNome() + "\t CPF: " + cliente.getCpf() + "\t Telefone: " + cliente.getTelefone() + "\t Endereço: " + cliente.getEndereco());
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
