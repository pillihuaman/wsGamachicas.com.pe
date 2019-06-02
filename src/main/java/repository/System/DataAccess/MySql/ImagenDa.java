package repository.System.DataAccess.MySql;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.codegen.TypeAnnotationCodeStream;
import org.sql2o.Sql2o;
//import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class ImagenDa {

	
    public  static  BigInteger registerImagen (CrudImagenBE CrudImagenBE) 
    {
    	BigInteger idImagen1=null;
    	int idImagen=0;
    	String valor=null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="INSERT INTO Gamachicas.imagen(name,idclothing,idposition,positionweb,countViews,imagendata,url,DESCRIPTION,STATUS,createdate,updatedate,idclothingline) " + 
	          		"VALUES(:name,:idclothing,:idposition,:positionweb,:countViews,:imagendata,:url,:DESCRIPTION,:STATUS,:createdate,:updatedate,:idclothingline)";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	  idImagen1= (BigInteger)  con.createQuery(sql,true)
	        			  .addParameter("name", CrudImagenBE.getImagen().getName())
	        			  .addParameter("idclothing", CrudImagenBE.getImagen().getIdclothing())
	        			  .addParameter("idposition", CrudImagenBE.getImagen().getIdposition())
	        			  .addParameter("positionweb", CrudImagenBE.getImagen().getPositionweb())
	        			  .addParameter("countViews", CrudImagenBE.getImagen().getCountViews())
	        			  .addParameter("imagendata", CrudImagenBE.getImagen().getImagendata())
	        			  .addParameter("url", "fsdfs")
	        			  .addParameter("DESCRIPTION", CrudImagenBE.getImagen().getDescription())
	        			  .addParameter("STATUS", true)
	        			  .addParameter("createdate", LocalDateTime.now())
	        			  .addParameter("updatedate", LocalDateTime.now())
	        			  .addParameter("idclothingline", CrudImagenBE.getImagen().getIdclothingline())
	        			 .executeUpdate()
	        			 . getKey();
	        	 
	 	     	  
	          }
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return idImagen1;
    } 
   
    public  static  int RegisterDetailImagen (ViewStockBE ViewStockBE) 
    {
    
    	int idImagen1= 0;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="INSERT INTO gamachicas.detailimagen(idimagen,Descripcion,vista,imagendata,url,createdate,updatedate,status) " + 
	          		"VALUES(:idimagen,:Descripcion,:vista,:imagendata,:url,:createdate,:updatedate,:status);";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	  idImagen1=(int) con.createQuery(sql,true)
	        			  .addParameter("idimagen", ViewStockBE.getDetailimagen().getIdimagen())
	        			  .addParameter("Descripcion", ViewStockBE.getDetailimagen().getDescripcion())
	        			  .addParameter("vista", ViewStockBE.getDetailimagen().getVista())
	        			  .addParameter("imagendata", ViewStockBE.getDetailimagen().getImagendata())
	        			  .addParameter("url", "url test")
	        			  .addParameter("createdate", LocalDateTime.now())
	        			  .addParameter("updatedate",LocalDateTime.now())
	        			  .addParameter("status", true)
	        			 .executeUpdate()
	        			 .getKey();
	          }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return idImagen1;
    } 
    
    public  static  int tesinsert (CrudImagenBE CrudImagenBE) 
    {
    	Integer idImagen=0;
    	int idImagen1;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="INSERT INTO Gamachicas.Test(idimagen) " + 
	          		"VALUES(:idimagen)";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	  idImagen1=(int) con.createQuery(sql,true)
	        			  .addParameter("idimagen", CrudImagenBE.getTest().getIdimagen())
	        			 .executeUpdate()
	        			 .getKey();
	          }
			return idImagen;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return idImagen;
    } 
    public  static List<Imagen> list() 
    {
   	 List<Imagen> result= null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select  * from gamachicas.Imagen  order by positionweb desc limit 10;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result = con
	        	            .createQuery(sql)
	        	            //.addParameter("idimagen", 1)
	        	            .executeAndFetch(Imagen.class);
	        	  
	          }
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
    public  static List<Imagen>  getimg(int idimagen) 
    {

      	 List<Imagen> result= null;
     	try {
 			Class.forName("com.mysql.jdbc.Driver");
 		} catch (ClassNotFoundException e1) {
 			e1.printStackTrace();
 		} 
     	try {
 			EntityDBConnection conne= MySqlAdapter.getConnectionString();
 			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
 	          String sql ="select  * from gamachicas.Imagen  where idimagen= :idimagen;";
 	          try (org.sql2o.Connection con =  sql2o.open()){
 	        	     result = con
 	        	            .createQuery(sql)
 	        	            .addParameter("idimagen", idimagen)
 	        	            .executeAndFetch(Imagen.class);
 	        	  
 	          }
 			return result;
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     	return result;	
    	
    }
    public  static List<Detailimagen>  ListaDetalleImagenXID(int idimagen) 
    {

      	 List<Detailimagen> result= null;
     	try {
 			Class.forName("com.mysql.jdbc.Driver");
 		} catch (ClassNotFoundException e1) {
 			e1.printStackTrace();
 		} 
     	try {
 			EntityDBConnection conne= MySqlAdapter.getConnectionString();
 			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
 	          String sql ="select * from gamachicas.detailimagen where idimagen= :idimagen;";
 	          try (org.sql2o.Connection con =  sql2o.open()){
 	        	     result = con
 	        	            .createQuery(sql)
 	        	            .addParameter("idimagen", idimagen)
 	        	            .executeAndFetch(Detailimagen.class);
 	        	  
 	          }
 			return result;
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     	return result;	
    	
    }
    public static  int   InsertImagen( CrudImagenBE CrudImagenBE)
			throws SQLException, IOException {
    	 int idimagen=0;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

            List<CrudImagenBE> lst =new ArrayList<CrudImagenBE>();
		String getDBUSERCursorSql = "{call sp_InsertImagen (?,?,?,?,?,?,?,?,?,?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
		 	callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
		 	callableStatement.setString(1, CrudImagenBE.getImagen().getName());
			callableStatement.setInt(2, CrudImagenBE.getImagen().getIdclothing());
			callableStatement.setInt(3, CrudImagenBE.getImagen().getIdposition());
			callableStatement.setInt(4, CrudImagenBE.getImagen().getPositionweb());
			callableStatement.setInt(5, CrudImagenBE.getImagen().getCountViews());
			callableStatement.setBytes(6, CrudImagenBE.getImagen().getImagendata());
			callableStatement.setString(7, CrudImagenBE.getImagen().getUrl());
			callableStatement.setString(8, CrudImagenBE.getImagen().getDescription());
			callableStatement.setInt(9, CrudImagenBE.getImagen().getIdclothingline());
			callableStatement.registerOutParameter(10,java.sql.Types.INTEGER);   
		    callableStatement.executeUpdate();
		    ResultSet rs = callableStatement.getGeneratedKeys();
		    if (rs.next()){
		    	idimagen=rs.getInt(10);
		    }
		    
		    
				   //ResultSet resultSet = callableStatement.getResultSet();
                //while (resultSet.next()) {
                	//   idimagen = resultSet.ge7tInt("idimagen");
	                    //String path = resultSet.getString("path");
                  
               // }
                //resultSet.close();
 

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
 return idimagen;
	}
    public static  int   InsertDetalleImagen( ViewStockBE ViewStockBE)
			throws SQLException, IOException {
    	 int idimagen=0;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

            List<CrudImagenBE> lst =new ArrayList<CrudImagenBE>();
		String getDBUSERCursorSql = "{call sp_InsertDetalleImagen (?,?,?,?,?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
		 	callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
		 	callableStatement.setInt(1,  ViewStockBE.getDetailimagen().getIdimagen());
			callableStatement.setString(2, ViewStockBE.getDetailimagen().getDescripcion());
			callableStatement.setInt(3,  ViewStockBE.getDetailimagen().getVista());
			callableStatement.setBytes(4, ViewStockBE.getDetailimagen().getImagendata());
			//callableStatement.setInt(5, " ");
			//callableStatement.setBoolean(5,  true);
			callableStatement.registerOutParameter(5,java.sql.Types.INTEGER);   
		    callableStatement.executeUpdate();
		    ResultSet rs = callableStatement.getGeneratedKeys();
		    if (rs.next()){
		    	idimagen=rs.getInt(5);
		    }
		    
		    
				   //ResultSet resultSet = callableStatement.getResultSet();
                //while (resultSet.next()) {
                	//   idimagen = resultSet.ge7tInt("idimagen");
	                    //String path = resultSet.getString("path");
                  
               // }
                //resultSet.close();
 

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
 return idimagen;
	}
}
   