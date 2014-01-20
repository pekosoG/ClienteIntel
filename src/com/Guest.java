package com;

/**
 * ***CLIENT SIDE***</br>
 * Clase que se contiene la informacion basica de los GUEST</br>
 * que están conectados a la Nube
 * <ul>
 * 		<li>Numero ID</li>
 * 		<li>Sistema Operativo</li>
 * 		<li>Direccion IP</li>
 * 		<li>Numero Cores</li>
 * 		<li>Memoria Disponible</li>
 * </ul>
 * @author Pekosog@IntelCloudTeam
 * @version 1.0
 */
public class Guest {
	
	private String ID=null;
	private String OS=null;
	private String IP=null;
	private String numCores=null;
	private String memoriaLibre=null;
	
	public Guest(String ID,String IP,String OS,String cores,String mem){
		this.ID=ID;
		this.IP=IP;
		this.OS=OS;
		this.numCores=cores;
		this.memoriaLibre=mem;
	}
	
	public String getID() {
		return ID;
	}	
	public String getIP() {
		return IP;
	}
	
	public String getOS() {
		return OS;
	}
	public String getCores(){
		return this.numCores;
	}
	public String getMem(){
		return this.memoriaLibre;
	}
	
	public Runnable getInput(){
		return null;
	}
	
	@Override
	public String toString(){
		//{ID=[ID],IP=[IP],OS=[OS]}
		return "{ID="+this.ID+",IP="+this.IP+",OS="+this.OS+"};";
	}
}
