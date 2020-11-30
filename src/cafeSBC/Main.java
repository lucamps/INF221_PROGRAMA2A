/**
 * Main.java
 * @autor Lucas Santos Campos
 * 29/11/2020
 * */
package cafeSBC;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal: onde tudo acontece :)
 */
public class Main {
	
	public static void main(String[] args) {
		/**
		 * Arrays auxiliares cujas posiçoes representam os andares
		 */
		ArrayList<Integer> funcionarios = new ArrayList<Integer>();
		ArrayList<Integer> tempoTotal = new ArrayList<Integer>();
		
		/**
		 *  Realiza a leitura dos dados
		 */
		Scanner sc = new Scanner (System.in);
		int numAndares = sc.nextInt();
		for(int i=0; i<numAndares; i++) {
			int temp = sc.nextInt();
			funcionarios.add(temp);	
		}
		sc.close();
		
		/**
		 *  Calcula o tempo otimo e o tempo total de cada possibilidade
		 */
		int tempoOtimo = Integer.MAX_VALUE;
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
		
		/**
		 *  Imprime a resposta na tela
		 */
		boolean first = true;
		
		System.out.println(tempoOtimo);
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
