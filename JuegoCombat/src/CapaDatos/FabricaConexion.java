package CapaDatos;
import java.sql.*;
import utils.*;

public class FabricaConexion 
{
    private String dbDriver="com.mysql.jdbc.Driver";
    private String host="localhost";
    private String port="3306";
    private String user="team";
    private String pass="java";
    private String db="tp";
    private String dbType="mysql";
    
    private Connection conn;
	private int cantConn=0;
	
	private FabricaConexion() throws ApplicationException{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			throw new ApplicationException("Error del Driver JDBC",e);
		}
	}
	
	private static FabricaConexion instancia;
	
	public static FabricaConexion getInstancia() throws ApplicationException{
		if (instancia==null){
			instancia = new FabricaConexion();
		}
		return instancia;
	}
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass);
				cantConn++;
			}
		} catch (SQLException e) {
			new ApplicationException("Error al conectar a la DB",e);

		}
		return conn;
	}
	
	public void releaseConn() throws ApplicationException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ApplicationException("Error al cerrar conexi�n",e);
		}
		
	}
}


