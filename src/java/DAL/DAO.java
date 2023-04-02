/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author TM080522
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private String status = "";

    public String getStatus() {
        return status;
    }

    public List<product> getallProduct() {
        List<product> productList = new ArrayList<>();
        String sql = "select * from\n"
                + "products_HE163548 inner join Collections_HE163548\n"
                + "on products_HE163548.collectionID = Collections_HE163548.collectionID";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productList.add(new product(rs.getString(1),
                        rs.getNString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return productList;
    }

    public product getProductbyID(String id) {
        product p = new product();
        String sql = "select * from\n"
                + "products_HE163548 inner join Collections_HE160075\n"
                + "on products_HE163548.collectionID = Collections_HE163548.collectionID\n"
                + "where productID like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new product(rs.getString(1),
                        rs.getNString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(13));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertProduct(String id, String name, String des, String size, int price, int stock, String image, String category, String collection) {
        String sql = "insert into products_HE163548\n"
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, des);
            ps.setString(4, size);
            ps.setInt(5, price);
            ps.setInt(6, stock);
            ps.setString(7, image);
            ps.setString(8, category);
            ps.setString(9, collection);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void updateProduct(String id, String name, String des, String size, int price, int stock, String image, String category, String collection) {
        String sql = "update products_HE163548 set\n"
                + "productName=?,description=?,size=?,price=?,stock=?,image=?,catID=?,collectionID=?\n"
                + "where productID like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, size);
            ps.setInt(4, price);
            ps.setInt(5, stock);
            ps.setString(6, image);
            ps.setString(7, category);
            ps.setString(8, collection);
            ps.setString(9, id);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void deleteProduct(String productID) {
        String sql = "delete from products_HE163548 where productID like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, productID);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public List<category> getallCategory() {
        List<category> categoryList = new ArrayList<>();
        String sql = "select * from categories_HE163548";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                categoryList.add(new category(rs.getString(1), rs.getNString(2), rs.getNString(3)));
            }
        } catch (Exception e) {
        }
        return categoryList;
    }

    public void insertCategory(String id, String name, String des) {
        String sql = "insert into categories_HE163548\n"
                + "values(?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, des);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void deleteCategory(String catID) {
        String sql = "delete from Categories_HE163548 where catID like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, catID);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public List<collection> getallCollection() {
        List<collection> collectionList = new ArrayList<>();
        String sql = "select * from Collections_HE163548";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                collectionList.add(new collection(rs.getString(1),
                        rs.getNString(2),
                        rs.getInt(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return collectionList;
    }

    public void insertCollection(String id, String name, int discount, String image) {
        String sql = "insert into collections_HE163548\n"
                + "values(?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, discount);
            ps.setString(4, image);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void removeCollection(String colID) {
        String sql = "update products_HE163548\n"
                + "set collectionID='none'\n"
                + "where collectionID=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, colID);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public void deleteCollection(String colID) {
        String sql = "delete from Collections_HE163548 where collectionID like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, colID);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public List<account> getallAccount() {
        List<account> accountList = new ArrayList<>();
        String sql = "select * from Accounts_HE163548 where [status] = 1";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new account(rs.getString(1),
                        rs.getNString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getNString(6), rs.getNString(7), rs.getNString(8),
                        rs.getNString(9),
                        rs.getNString(10)));
            }
        } catch (Exception e) {
        }
        return accountList;
    }

    public void insertAccount(String username, String email, String password, String quiz, String answer) {
        boolean isAdmin = false;
        boolean autoActive = true;
        String sql = "insert into Accounts_HE163548 (Username,Email,[Password],SecurityQuiz,SecurityAnswer,Role,Status)\n"
                + "values(?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setNString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setNString(4, quiz);
            ps.setNString(5, answer);
            ps.setBoolean(6, isAdmin);
            ps.setBoolean(7, autoActive);
            ps.execute();
        } catch (Exception e) {
            status += "Error at add order " + e.getMessage();
        }
    }

    public void updateAccount(String email, String name, String phone, String city, String district, String address) {
        String sql = "update Accounts_HE163548\n"
                + "set Username = ?, Phone = ?, City = ?, District = ?, [Address] = ?\n"
                + "where Email = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setNString(1, name);
            ps.setString(2, phone);
            ps.setNString(3, city);
            ps.setNString(4, district);
            ps.setNString(5, address);
            ps.setString(6, email);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void updatepassword(String email, String password) {
        String sql = "update accounts_HE163548\n"
                + "set Password = ?\n"
                + "where Email like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void deleteacc(String email) {
        String sql = "delete from accounts_HE163548 where Email like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void addOrder(account cus, cart cart) {
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        String address = "demo";
        try {
            String sql = "insert into [Orders_HE163548] values(?, ?, ?, ?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, cus.getEmail());
            ps.setInt(3, cart.getTotal());
            ps.setString(4, address);
            ps.execute();

            String sql2 = "Select top 1 OrderID from [Orders_HE163548] order by OrderID desc";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            rs = ps2.executeQuery();
            if (rs.next()) {
                int orderID = rs.getInt(1);
                for (item i : cart.getItems()) {
                    String sql3 = "Insert into OrderDetails_HE163548 values(?, ?, ?, ?)";
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setInt(1, orderID);
                    ps3.setString(2, i.getProduct().getProductid());
                    ps3.setInt(3, i.getQuantity());
                    ps3.setInt(4, i.getPrice());
                    ps3.execute();
                }
            }
            //Update product stock
            String sql4 = "update products_HE163548 set stock = stock - ? where productID like ?";
            PreparedStatement ps4 = con.prepareStatement(sql4);
            for (item i : cart.getItems()) {
                ps4.setInt(1, i.getQuantity());
                ps4.setString(2, i.getProduct().getProductid());
                ps4.executeUpdate();
            }
        } catch (Exception e) {
            status += "Error at add order " + e.getMessage() + "|" + date + "|" + cus.getEmail() + "|" + cart.getTotal();
        }
    }

    public void updateStatus(String email) {
        String sql = "UPDATE [dbo].[Accounts_HE163548]\n"
                + "   SET[status] = True\n"
                + " WHERE email = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<account> accList = dao.getallAccount();
        for (account a : accList) {
            System.out.println(a.getSecurityanswer());
        }
    }
}
