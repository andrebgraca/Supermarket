package pt.ulht.supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import pt.ulht.beans.Cliente;
import pt.ulht.beans.Caixa;
import pt.ulht.utils.Helpers;
import pt.ulht.utils.DataLogs;

public class ModoManual {
	
	public static List<Caixa> listaCaixasManual = new ArrayList<Caixa>();
	public static List<Cliente> listaClientesManual = new ArrayList<Cliente>();
	
	public static void criarCliente() {
		Random randomGen = new Random();
		Integer nProdutos = Helpers.generateRandomInteger(2, 120, randomGen);
		Cliente cliente = new Cliente(Cliente.nClientes, nProdutos);
		DataLogs.writeNewClient(Cliente.nClientes.toString(),
								nProdutos.toString());
		listaClientesManual.add(cliente);
	}
	
	public static void criarCaixa() {
		Caixa caixa = new Caixa(Caixa.nCaixas);
		DataLogs.writeNewRegister(Caixa.nCaixas.toString(),
							      caixa.getnClientesFila().toString(),
							      caixa.getnClientesAtendidos().toString(),
							      caixa.getTempoTotalAtendimento().toString(),
							      caixa.getTempoMedioAtendimento().toString());
		listaCaixasManual.add(caixa);
	}
	
	public static void mostrarFilas() {
		if (!Supermarket.listaCaixasLog.isEmpty()) {
			for (int i = 0; i < Supermarket.listaCaixasLog.size(); i++) {
				if (!Supermarket.listaCaixasLog.contains(listaCaixasManual.get(i))) {
					listaCaixasManual.add(Supermarket.listaCaixasLog.get(i));
				}
			}
		}
			for (int i = 0; i < listaCaixasManual.size(); i++)  {
				System.out.println("------------------------");
				System.out.println("| ID: "+( listaCaixasManual.get(i).getId() + 1 )+"                |");
				System.out.println("| Fila: "+listaCaixasManual.get(i).getnClientesFila()+"              |");
				System.out.println("| Atend: "+listaCaixasManual.get(i).getnClientesAtendidos()+"             |");
				System.out.println("| Total: "+listaCaixasManual.get(i).getTempoTotalAtendimento()+"             |");
				System.out.println("| Medio: "+listaCaixasManual.get(i).getTempoMedioAtendimento()+"             |");
				System.out.println("------------------------");
			}
		} 
	
	
	public static void retirarCaixas() { //Not Working
		if (!Supermarket.listaCaixasLog.isEmpty()) {
			for (int i = 0; i < Supermarket.listaCaixasLog.size(); i++) {
				if (!Supermarket.listaCaixasLog.contains(listaCaixasManual.get(i))) {
					listaCaixasManual.add(Supermarket.listaCaixasLog.get(i));
				}
			}
		}
		
		for (int i = 1; i < listaCaixasManual.size(); i++) { //For each Caixa in ListaCaixasManual
			if (listaCaixasManual.get(i).getnClientesFila() == 0) { //Se não tiver clientes em fila, remove-se da lista
				listaCaixasManual.remove(i);
				DataLogs.deleteRegister(listaCaixasManual.get(i).getId().toString());
			}
		}
		
		
	}
	
	public static void atenderClientes() {
		
	}
	
	
		
}
	
	
	

