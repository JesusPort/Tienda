package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.data.Tipo;

public class TipoDao {

	private static Connection connection;
	
	public static void insertarUnTipo(Tipo tipo) {
		Conexion con= new Conexion();
		connection=con.getJdbcConnection();
		
		try {
			Statement sentencia= connection.createStatement();
			
			String sql ="INSERT INTO tipo(nombre_tipo) VALUES('"+tipo.getNombre()+"')";
			
			//Comprobamos si las lineas afectadas son mayores que 0
			boolean rowInserted = sentencia.executeUpdate(sql) > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean deleteTipo(int id) {
		Conexion con = new Conexion();
	    connection = con.getJdbcConnection();
	    boolean rowDeleted = false;
	    try {
	        // Eliminar componentes asociados al tipo
	        String deleteComponentesSQL = "DELETE FROM componente WHERE ID_tipo = " + id;
	        Statement statement = connection.createStatement();
	        statement.executeUpdate(deleteComponentesSQL);

	        // Eliminar el tipo una vez que los componentes están eliminados
	        String deleteTipoSQL = "DELETE FROM tipo WHERE id_tipo = " + id;
	        rowDeleted = statement.executeUpdate(deleteTipoSQL) > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rowDeleted;
	}
	
	public static List<Tipo> seleccionarTipos(){
		List<Tipo> listaTipo= new ArrayList<Tipo>();
		ResultSet resultSet;
		Conexion con = new Conexion();
		connection=con.getJdbcConnection();
		
		
		try {
			Statement sentencia=connection.createStatement();
			String sql="SELECT id_tipo, nombre_tipo FROM tipo";
			resultSet=sentencia.executeQuery(sql);
			
			while(resultSet.next()) {
				listaTipo.add(new Tipo(resultSet.getInt(1),resultSet.getString("nombre_tipo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTipo;
	}
	
	public static int isTipoInBD(String nombre_tipo) {
		List<Tipo> listaTipo=new ArrayList<Tipo>();
		ResultSet resultSet;
		Conexion con = new Conexion();
		connection= con.getJdbcConnection();
		int idTipo=0;
		try {
			Statement sentencia= connection.createStatement();
			String sql="SELECT id_tipo FROM tipo WHERE nombre_tipo='"+nombre_tipo+"'";
			resultSet=sentencia.executeQuery(sql);
			
			if(resultSet.next()) {
				idTipo=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idTipo;
		
	}
}
