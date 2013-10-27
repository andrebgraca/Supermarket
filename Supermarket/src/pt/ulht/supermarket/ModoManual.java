package pt.ulht.supermarket;

import java.util.Random;
import java.util.Scanner;

import pt.ulht.beans.Cliente;
import pt.ulht.beans.Caixa;
import pt.ulht.utils.Helpers;
import pt.ulht.utils.DataLogs;

public class ModoManual {
	
	public static void criarCliente() {
		Random randomGen = new Random();
		Integer nProdutos = Helpers.generateRandomInteger(2, 120, randomGen);
		Cliente cliente = new Cliente(Cliente.nClientes, nProdutos);
		DataLogs.writeNewClient(Cliente.nClientes.toString(),
								nProdutos.toString());
	}
	
	public static void criarCaixa() {
			Caixa caixa = new Caixa(Caixa.nCaixas);
			DataLogs.writeNewRegister(Caixa.nCaixas.toString(),
								      caixa.getnClientesFila().toString(),
								      caixa.getnClientesAtendidos().toString(),
								      caixa.getTempoTotalAtendimento().toString(),
								      caixa.getTempoMedioAtendimento().toString());
	}
	
	public static void mostrarFilas() {
		
	}
	
	public static void retirarCaixas() {
		
	}
	
	public static void atenderClientes() {
		
	}
	
	
		
}
	
	
	

