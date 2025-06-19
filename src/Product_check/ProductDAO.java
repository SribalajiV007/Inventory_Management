package Product_check;

import Database.DBUtil;

import java.sql.*;
import java.util.*;

public class ProductDAO {

    // Insertproduct
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

    // --- get all products
    public List<Product> getAllProducts(){
        List<Product> list = new ArrayList();

        String sql = "select * from products";

        try(Connection conn = DBUtil.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(sql)){
            while(rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int reorder = rs.getInt("reorder_level");

                list.add(new Product(id, name, quantity, reorder));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    // Update Product

    public boolean updateProduct(int pid,String newName, int newQty, int newReorder){
        String sql = "update products SET name=?, quantity = ?, reorder_level =? where product_id = ?";
        try(Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,newName);
            ps.setInt(2,newQty);
            ps.setInt(3, newReorder);
            ps.setInt(4, pid);
             return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Delete Product
    public boolean deleteProduct(int pid){
        String sql = "delete from products where product_id = ?";
        try(Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, pid);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public int getProductCount() {
        String sql = "SELECT COUNT(*) FROM products";

        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
