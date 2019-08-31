package br.com.fujitsu.cobol;

public class SomaCobolTeste {
	
	
	public static void main(String[] args) {
		SomaCobol teste = new SomaCobol();
		int resultado = teste.chamaLibCobol("15", "17");
		System.out.println("O resultado da soma é: " + resultado);

	}

}
