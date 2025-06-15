package Product_check;

import Database.DBUtil;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    public void insertProduct(Product product){
        String sql = "insert into products(name,quantity,reorder_level) values(?,?,?)";

        try(Connection  conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,product.getName());
            ps.setInt(2,product.getQuantity());
            ps.setInt(3,product.getreorderLevel());
            ps.executeUpdate();

        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts(){
        List<Product> list = new ArrayList();

        String sql = "select * from products";

        try(Connection conn = DBUtil.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(sql)){
            while(rs.next()){
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int reorder = rs.getInt("reorder_level");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
