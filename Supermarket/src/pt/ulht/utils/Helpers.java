package pt.ulht.utils;

import java.util.Random;
import java.util.Scanner;

import pt.ulht.beans.Caixa;

public class Helpers {

	public static Integer modoFuncionamento() {
		Integer modo = 0;
		Scanner input = new Scanner(System.in);
		//Escolha do Modo de Funcionamento
		do {		
			System.out.println("Escolha o Modo de Funcionamento");
			System.out.println("");
			System.out.println("1 - Modo Autom�tico");
			System.out.println("2 - Modo Manual");
			System.out.println("");
			System.out.print("Op��o ->");
			
			modo = input.nextInt();
			
			if (modo != 1 && modo != 2) {
				System.out.println("Op��o n�o Dispon�vel");
			}
			
		} while (modo != 1 && modo != 2);
		
		
		
		switch(modo){
		case 1: 
			return 1;
		case 2: 
			return 2;
		}
		
		return 0; //Never returns 0
	}
	
	public static Integer continuarExec() {
		Integer continuar = 0;
		Scanner input = new Scanner (System.in);
		
		do {
			System.out.println("Escolha");
			System.out.println("1 - Nova Execu��o");
			System.out.println("2 - Continuar Execu��o");
			System.out.println("");
			System.out.print("Op��o -> ");
			
			continuar = input.nextInt();
			
			if (continuar != 1 && continuar != 2) {
				System.out.println("Op��o n�o Dispon�vel");
			}
			
		} while (continuar != 1 && continuar != 2);
		
		switch(continuar) {
		case 1: return 1;
		case 2: return 2;
		}
		
		return 0;
	}
	
	
	
	public static Integer generateRandomInteger(Integer start, Integer end, Random random){
		if (start > end) {
			throw new IllegalArgumentException("Start is bigger than End");
		}
		long range = (long)end - (long)start + 1;
		long fraction = (long)(range * random.nextDouble());
		int randomNumber = (int)(fraction + start);
		
		return randomNumber;
	}
	
}
