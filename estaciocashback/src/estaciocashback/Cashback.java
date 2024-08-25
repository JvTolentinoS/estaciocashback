package estaciocashback;

import java.util.Scanner;


public class Cashback 
{

	public static void main(String[] args) 
	{
		Dados dados = entradaUsuario();
		Dados dados1 = calculoCashback(dados);
		
		limparConsole();
		
		System.out.println("Nome: " + dados.nome);
		System.out.println("Idade: " + dados.idade + " Anos" );
		System.out.printf("Valor do cashback: R$ %.2f", dados1.valorcashback);
	}
	
	public static void limparConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public static Dados entradaUsuario() 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Insira seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira sua idade: ");
        int idade = scanner.nextInt();
        
        System.out.print("Insira o valor da compra: ");
        double valor = scanner.nextDouble();
        
        scanner.close();
        
		return new Dados(nome, idade, valor, 0);
	}
	
	public static Dados calculoCashback(Dados dados) 
	{
		double cashback = 0; 
		double valorcashback = 0;
		{
		if (dados.idade < 21) 
		{
			if (dados.valor < 1000) 
			{
					cashback = 0.07; 
					valorcashback = (cashback * dados.valor);
			} 
			else 
			{
					cashback = 0.10; 
					valorcashback = (cashback * dados.valor);
			}
		}
		else if (dados.valor < 1000) 
		{
					cashback = 0.05;
					valorcashback = (cashback * dados.valor);	
			}
			else 
			{
					cashback = 0.07;
					valorcashback = (cashback * dados.valor);
			}
		}
			return new Dados(dados.nome, dados.idade, dados.valor, valorcashback);
	}
}
class Dados 
{
	String nome;
	int idade;
	double valor;
	double valorcashback;
	
	public Dados (String nome, int idade, double valor, double valorcashback) 
	{		
		this.nome = nome;
		this.idade = idade;
		this.valor = valor;
		this.valorcashback = valorcashback;
	}
}