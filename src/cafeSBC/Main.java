/**
 * Main.java
 * @autor Lucas Santos Campos
 * 29/11/2020
 * */
package cafeSBC;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principal
public class Main {
	
	public static void main(String[] args) {
		
		// Arrays auxiliares cujas posiçoes representam os andares
		ArrayList<Integer> funcionarios = new ArrayList<Integer>();
		
		// Realiza a leitura dos dados
		Scanner sc = new Scanner (System.in);
		int numAndares = sc.nextInt();
		for(int i=0; i<numAndares; i++) {
			funcionarios.add(sc.nextInt());	
		}
		sc.close();
		
		Cafe sbc = new Cafe(funcionarios, numAndares);
		
		sbc.imprimeResultados();
	}
}
