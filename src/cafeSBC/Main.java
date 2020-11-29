/*
 * Main.java
 * 
 * Lucas Santos Campos - 92867
 * 
 * 29/11/2020
 * 
 * */

package cafeSBC;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		ArrayList<Integer> funcionarios = new ArrayList<Integer>();
		ArrayList<Integer> tempoTotal = new ArrayList<Integer>();
		
		int tempoOtimo = Integer.MAX_VALUE;
		
		Scanner sc = new Scanner (System.in);
		
		int numAndares = sc.nextInt();
		
		for(int i=0; i<numAndares; i++) {
			int temp = sc.nextInt();
			funcionarios.add(temp);	
		}
		
		sc.close();
		
		int soma = 0;
		for(int i=0; i<numAndares; i++) {
			for(int j=0; j<numAndares; j++) {
				if(i != j) {
					soma += Math.abs(i-j)* 2 * funcionarios.get(j);
				}
			}
			tempoTotal.add(soma);
			if (soma < tempoOtimo) {
				tempoOtimo = soma;
			}
			soma = 0;
		}
		
		// Imprimindo resposta
		System.out.println(tempoOtimo);
		boolean first = true;
		for(int i=0; i<numAndares; i++) {
			if(tempoTotal.get(i) == tempoOtimo) {
				if(first) {
					first = false;
					System.out.print((int)(i+1));
				}
				else
					System.out.print(" " + (int)(i+1));
			}
		}
		System.out.println();
	}

}
