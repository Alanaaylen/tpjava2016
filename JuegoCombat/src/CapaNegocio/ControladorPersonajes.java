package CapaNegocio;
import utils.ApplicationException;
import CapaEntidades.*;
import CapaDatos.*;
public class ControladorPersonajes
{
    public void agregarPer(Personaje per) throws ApplicationException
    {
    	PersonajeData pd=new PersonajeData();
    	pd.agregar(per);
    }
}
