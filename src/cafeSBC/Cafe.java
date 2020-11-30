/**
 * Cafe.java
 * @autor Lucas Santos Campos
 * 29/11/2020
 * */
package cafeSBC;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
	// Arrays auxiliares cujas posiçoes representam os andares
	private ArrayList<Integer> funcionarios;
	private ArrayList<Integer> tempoTotal;
	// Inteiro para armazenar o menor tempo total
	private int tempoOtimo;
	private int numAndares;
	
	//Construtores
	Cafe(){
		setTempoOtimo(Integer.MAX_VALUE);
		funcionarios = new ArrayList<Integer>();
		tempoTotal = new ArrayList<Integer>();
		numAndares = 3;
	}
	
	Cafe(ArrayList<Integer> funcionarios, int numAndares){
		setTempoOtimo(Integer.MAX_VALUE);
		this.numAndares = numAndares;
		this.funcionarios = funcionarios;
		tempoTotal = new ArrayList<Integer>();
		calculaTempoOtimo();
	}
	
	//Metodos
	public int getTempoOtimo() {
		return tempoOtimo;
	}

	public void setTempoOtimo(int tempoOtimo) {
		this.tempoOtimo = tempoOtimo;
	}

	public int getNumAndares() {
		return numAndares;
	}

	public void setNumAndares(int numAndares) {
		this.numAndares = numAndares;
	}
	
	public ArrayList<Integer> getFuncionarios(){
		return funcionarios;
	}
	
	public void setFuncionarios(ArrayList<Integer> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void realizarLeitura() {
		Scanner sc = new Scanner (System.in);
		numAndares = sc.nextInt();
		for(int i=0; i<numAndares; i++) {
			funcionarios.add(sc.nextInt());	
		}
		sc.close();
	}
	
	public void calculaTempoOtimo() {
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
	}
	
	public ArrayList<Integer> getAndaresOtimos() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<numAndares; i++) {
			if(tempoTotal.get(i) == tempoOtimo) {
				temp.add((int)(i+1));
			}
		}
		return temp;
	}
	
	public void imprimeResultados() {
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
