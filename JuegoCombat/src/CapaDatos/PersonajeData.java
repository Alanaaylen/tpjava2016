package CapaDatos;
//importa la libreria de java q me permite conectarme con la base de datos
import java.sql.*;
import CapaEntidades.*;
import utils.*;

public class PersonajeData
{
	 public void agregar(Personaje pers) throws ApplicationException
	 {   ResultSet rta=null;
		 PreparedStatement stmt=null;
		 try{
			 stmt=FabricaConexion.getInstancia().getConn().prepareStatement(
					 "insert into personajes(idPersonaje,nombrePer,vida,energia,defensa,evasion,puntosTotales)"+
			 " values(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		    
		    stmt.setInt(1,pers.getIdPersonaje());
		    stmt.setString(2, pers.getNombrePer());
		    stmt.setFloat(3,pers.getVida());
		    stmt.setFloat(4,pers.getEnergia());
		    stmt.setFloat(5,pers.getDefensa());
		    stmt.setFloat(6, pers.getEvasion());
		    stmt.setFloat(7,pers.getPuntosTotales());
		    stmt.execute();
		    }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 finally{
	            try{	
	            	    if(rta!=null){ rta.close();}
			            if(stmt!=null){stmt.close();}
			            FabricaConexion.getInstancia().releaseConn();
		           }   
	            catch (ApplicationException e)
	            {
				   e.printStackTrace();
				}
		       catch(SQLException e)
		           {
			         e.printStackTrace();
		           }
		 	   }
	   }
	
}
