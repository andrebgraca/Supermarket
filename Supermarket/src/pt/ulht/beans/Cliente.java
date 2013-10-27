package pt.ulht.beans;

public class Cliente implements Runnable {
	
	public static Integer nClientes = 0;
	
	private Integer id;
	private Integer nProdutos;
	
	public Cliente(Integer id, Integer nProdutos) {
		this.id = id;
		this.nProdutos = nProdutos;
		nClientes += 1;
	}
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public Integer getnProdutos() {
		return nProdutos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setnProdutos(Integer nProdutos) {
		this.nProdutos = nProdutos;
	}

	@Override
	public void run() {

		
	}
	
	//End of Getters and Setters	
	
}
