package pt.ulht.supermarket;

import java.util.Scanner;

import pt.ulht.beans.*;
import pt.ulht.tests.*;
import pt.ulht.utils.DataLogs;
import pt.ulht.utils.Helpers;


public class Supermarket {
	
	
	public static void main(String[] args) {
		//args[0] - Nº Clientes ; args[1] - Nº Caixas ??
		
		Integer modo;
		Integer continuar;
		boolean sairManual = false;
		/*Thread modoManual = new Thread(new ModoManual());*/
		
		
		modo = Helpers.modoFuncionamento();
		continuar = Helpers.continuarExec();
		
		switch(continuar) {
		case 1: 
			System.out.println("Escolheu Nova Execução");
			DataLogs.initLog(modo.toString());
			break;
		case 2:
			System.out.println("Escolheu Continuar Execução");
			break;
		}
		
		switch (modo) {
		case 1:
			System.out.println("Escolheu o modo Automático");
			/*modoAutomatico.start();*/
			break;
		case 2:
			System.out.println("Escolheu o modo Manual");
			Scanner scan = new Scanner (System.in);
			
			Integer escolha;
			do { //while (sairManual == false);
				do { //while escolha incorrecta
					System.out.println("Menu");
					System.out.println("1 - Criar Caixa");
					System.out.println("2 - Criar Cliente");
					System.out.println("3 - Mostrar Filas das Caixas");
					System.out.println("4 - Retirar Caixas não Utilizadas");
					System.out.println("5 - Atender Clientes");
					System.out.println("6 - Sair");
					System.out.print("Opção -> ");
					escolha = scan.nextInt();
									
					if (escolha != 1 &&
						escolha != 2 &&
						escolha != 3 &&
						escolha != 4 &&
						escolha != 5 &&
						escolha != 6) {
				
						System.out.println("Escolha não disponível");
					}
					
				} while (escolha != 1 &&
						 escolha != 2 &&
						 escolha != 3 &&
						 escolha != 4 &&
						 escolha != 5 &&
						 escolha != 6);
				
							
	
	
					switch (escolha) {
					
						case 1:
							ModoManual.criarCaixa();
							break;
						case 2:
							ModoManual.criarCliente();
							break;
						case 3:
							ModoManual.mostrarFilas();
							break;
						case 4:
							ModoManual.retirarCaixas();
							break;
						case 5:
							ModoManual.atenderClientes();
							break;
						case 6:
							sairManual = true;
							System.out.println("A Sair...");
							break;
					} 
					
			} while (sairManual == false);
			sairManual = false; //Reset sairManual
			
			
			break; //End Case 2 (Modo Manual)
		} //End Switch(modo) 
		
		

		
		
		
		
		
		/* LOG TESTING
		//DataLogs.InitLog();
		Cliente cliente1 = new Cliente(1, 10);
		Caixa Caixa1 = new Caixa(1, 4, 5, 440, 110);
				
		DataLogs.WriteNewClient(cliente1.getId().toString(),
								cliente1.getnProdutos().toString()
								);
		DataLogs.WriteNewClient(cliente1.getId().toString(),
								cliente1.getnProdutos().toString()
								);
		DataLogs.WriteNewClient(cliente1.getId().toString(),
								cliente1.getnProdutos().toString()
								);
		
		DataLogs.WriteNewRegister(Caixa1.getId().toString(),
								  Caixa1.getnClientesFila().toString(),
								  Caixa1.getnClientesAtendidos().toString(),
								  Caixa1.getTempoTotalAtendimento().toString(),
								  Caixa1.getTempoMedioAtendimento().toString()
								  );
		DataLogs.WriteNewRegister(Caixa1.getId().toString(),
								  Caixa1.getnClientesFila().toString(),
								  Caixa1.getnClientesAtendidos().toString(),
								  Caixa1.getTempoTotalAtendimento().toString(),
								  Caixa1.getTempoMedioAtendimento().toString()
				  				  );
		DataLogs.WriteNewRegister(Caixa1.getId().toString(),
				  				  Caixa1.getnClientesFila().toString(),
				  				  Caixa1.getnClientesAtendidos().toString(),
				  				  Caixa1.getTempoTotalAtendimento().toString(),
				  				  Caixa1.getTempoMedioAtendimento().toString()
				  				  );
				  				  
		DataLogs.readLog("clientes");
		DataLogs.readLog("caixas");
		*/
		
		
		

		
	}

}
