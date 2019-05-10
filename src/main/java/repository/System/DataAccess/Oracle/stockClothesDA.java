package repository.System.DataAccess.Oracle;
import domain.System.BusinessEntity.Base.Clothing;
import domain.System.BusinessEntity.ViewStockBE;
import infrastructure.System.Adapters.OracleAdapter;
import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
public class stockClothesDA {
	
	   public static   List<ViewStockBE>  getViewStock( ViewStockBE objs)
				throws SQLException {

			Connection dbConnection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;
	            List<ViewStockBE> lst =new ArrayList<ViewStockBE>();
			String getDBUSERCursorSql = "{call getlitsas(?,?)}";

			try {
				dbConnection = OracleAdapter.getConnection();
				callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

				callableStatement.setInt(1, 5);
				callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

				// execute getDBUSERCursor store procedure
				callableStatement.executeUpdate();

				// get cursor and cast it to ResultSet
				rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
	                         ViewStockBE ob= new ViewStockBE();
	                          Clothing clo= new Clothing();
	                            clo.setIdclothing(rs.getBigDecimal("idclothing"));
	                              clo.setName(rs.getString("name"));
	                              clo.setDescription(rs.getString("description"));
	                              ob.setClothing(clo);
				       lst.add(ob);   
//					
				}

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			} finally {

				if (rs != null) {
					rs.close();
				}

				if (callableStatement != null) {
					callableStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			}
	 return lst;
		}

}
