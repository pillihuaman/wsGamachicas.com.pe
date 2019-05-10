package repository.System.DataAccess.MySql;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.BitSet;
import java.util.List;

import org.sql2o.Sql2o;
//import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class ImagenDa {

	
    public  static  int registerImagen (CrudImagenBE CrudImagenBE) 
    {
    	int idImagen=0;
    	BigInteger idImagen1;
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
	        	  idImagen1=(BigInteger) con.createQuery(sql,true)
	        			  .addParameter("name", CrudImagenBE.getImagen().getName())
	        			  .addParameter("idclothing", CrudImagenBE.getImagen().getIdclothing())
	        			  .addParameter("idposition", CrudImagenBE.getImagen().getIdposition())
	        			  .addParameter("positionweb", CrudImagenBE.getImagen().getPositionweb())
	        			  .addParameter("countViews", CrudImagenBE.getImagen().getCountViews())
	        			  .addParameter("imagendata", CrudImagenBE.getImagen().getImagendata())
	        			  .addParameter("url", "url")
	        			  .addParameter("DESCRIPTION", CrudImagenBE.getImagen().getDescription())
	        			  .addParameter("STATUS", true)
	        			  .addParameter("createdate", LocalDateTime.now())
	        			  .addParameter("updatedate", LocalDateTime.now())
	        			  .addParameter("idclothingline", CrudImagenBE.getImagen().getIdclothingline())
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
    public  static  int tesinsert (CrudImagenBE CrudImagenBE) 
    {
    	Integer idImagen=0;
    	BigInteger idImagen1;
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
	        	  idImagen1=(BigInteger) con.createQuery(sql,true)
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
	          String sql ="select * from gamachicas.Imagen  where idimagen = :idimagen;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result = con
	        	            .createQuery(sql)
	        	            .addParameter("idimagen", 3)
	        	            .executeAndFetch(Imagen.class);
	        	  
	          }
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
}
