package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.data.Componente;
import modelo.data.Tipo;

public class ComponenteDao {
	private static Connection connection;
	
	public static boolean insertarUnComponente(Componente componente) {
		Conexion con= new Conexion();
		connection=con.getJdbcConnection();
		boolean rowInserted=false;
		try {
			Statement sentencia= connection.createStatement();
			
			//Si el tipo no esta en los tipos de la base de datos
			int idTipo=0;
			if((idTipo= TipoDao.isTipoInBD(componente.getTipo().getNombre()))==0) {
				TipoDao.insertarUnTipo(componente.getTipo());
				idTipo=TipoDao.isTipoInBD(componente.getTipo().getNombre());
			}
			String sql="INSERT INTO componente values("+componente.getID_componente()+",'"+componente.getNombre_componente()+"',"+
			"'"+componente.getFabricante()+"',"+componente.getPrecio()+","+"'"+componente.getDescripcion()+"',"+idTipo+")";
			
					
			rowInserted=sentencia.executeUpdate(sql)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	
	public static List<Componente> seleccionarComponente(){
		List<Componente> listaComponente= new ArrayList<Componente>();
		ResultSet rs;
		Conexion con= new Conexion();
		connection=con.getJdbcConnection();
		
		try {
			Statement sentencia= connection.createStatement();
			String sql="SELECT c.*,t.* FROM componente c, tipo t WHERE c.ID_tipo=t.id_tipo";
			rs=sentencia.executeQuery(sql);
			
			while(rs.next()) {
				listaComponente.add(new Componente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),new Tipo(rs.getInt(6),rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaComponente;
	}
	
}
