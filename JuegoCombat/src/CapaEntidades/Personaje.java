package CapaEntidades;

public class Personaje 
{
	private int idPersonaje;
	private String nombrePer;
	private float vida;
	private float energia=0;
	private float defensa=0;
	private float evasion=0;
	private float puntosTotales=200;
	 
	public void setIdPersonaje(int ide)
	{
		this.idPersonaje=ide;
	}
	
	public int getIdPersonaje()
	{
		return this.idPersonaje;
	}

	public String getNombrePer() 
	{
		return nombrePer;
	}

	public void setNombrePer(String nombrePer)
	{
		this.nombrePer = nombrePer;
	}

	public float getVida() 
	{
		return vida;
	}

	public void setVida(float vida) 
	{
		this.vida = vida;
	}

	public float getEnergia() 
	{
		return energia;
	}

	public void setEnergia(float energia) 
	{
		this.energia = energia;
	}

	public float getDefensa() 
	{
		return defensa;
	}

	public void setDefensa(float defensa) 
	{
		this.defensa = defensa;
	}

	public float getEvasion() 
	{
		return evasion;
	}

	public void setEvasion(float evasion) 
	{
		this.evasion = evasion;
	}

	public float getPuntosTotales()
	{ 
		return puntosTotales;
	}

	public void setPuntosTotales(float puntosTotales) 
	{
		this.puntosTotales = puntosTotales;
	}
	
	public boolean validarPuntos()
	{   float suma=0;
		suma=(this.vida+this.energia+this.defensa+this.evasion);
		if(suma<=200)
		{return true;}
		else{return false;}
    }
	

}
