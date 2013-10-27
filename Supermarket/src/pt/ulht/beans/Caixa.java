package pt.ulht.beans;

import java.util.LinkedList;


public class Caixa implements Runnable {
	
	public static Integer nCaixas = 0;
	
	Integer id;
	Integer nClientesFila;
	Integer nClientesAtendidos;
	Integer tempoTotalAtendimento;
	Integer tempoMedioAtendimento;
	LinkedList<Cliente> listaClientes = new LinkedList<Cliente>();
	
	public Caixa(Integer id) {
		this.id = id;
		this.nClientesFila = listaClientes.size();
		this.nClientesAtendidos = 0;
		this.tempoMedioAtendimento = 0;
		this.tempoTotalAtendimento = 0;
		nCaixas += 1;
	}
	
	public Caixa(Integer id, Integer nClientesFila, Integer nClientesAtendidos, Integer tempoMedioAtendimento, Integer tempoTotalAtendimento) {
		this.id = id;
		this.nClientesFila = nClientesFila;
		this.nClientesAtendidos = nClientesAtendidos;
		this.tempoMedioAtendimento = tempoMedioAtendimento;
		this.tempoTotalAtendimento = tempoTotalAtendimento;
	}
	
	@Override
	public void run() {

		
	}
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public Integer getnClientesFila() {
		return listaClientes.size();
	}

	public Integer getnClientesAtendidos() {
		return nClientesAtendidos;
	}

	public Integer getTempoTotalAtendimento() {
		return tempoTotalAtendimento;
	}

	public Integer getTempoMedioAtendimento() {
		return tempoMedioAtendimento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setnClientesFila(Integer nClientesFila) {
		this.nClientesFila = nClientesFila;
	}

	public void setnClientesAtendidos(Integer nClientesAtendidos) {
		this.nClientesAtendidos = nClientesAtendidos;
	}

	public void setTempoTotalAtendimento(Integer tempoTotalAtendimento) {
		this.tempoTotalAtendimento = tempoTotalAtendimento;
	}

	public void setTempoMedioAtendimento(Integer tempoMedioAtendimento) {
		this.tempoMedioAtendimento = tempoMedioAtendimento;
	}


	//End of Getters and Setters
	
}
