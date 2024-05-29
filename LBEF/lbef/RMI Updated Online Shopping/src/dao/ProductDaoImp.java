/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ProductDaoImp extends UnicastRemoteObject implements ProductInterface {
     public ProductDaoImp() throws RemoteException {
        super();
    }
     Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    JFrame frame;
        //get product table max row
    @Override
    public int getMaxProductRow() throws RemoteException {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(pid) from product");

            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    @Override
    public int countCategories()throws RemoteException{
        int total = 0;
        try {
            st= con.createStatement();
            rs = st.executeQuery("select count(*) as 'total' from category");
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;        
    }
    @Override
    public String[] getCat()throws RemoteException{
        String[] categories = new String[countCategories()];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from category");
            int i = 0;
            while(rs.next()){
                categories[i] = rs.getString(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    @Override
     //check product id already exists
    public boolean isProductIDExist(int id) throws RemoteException{
        try {
            ps = con.prepareStatement("select * from product where pid = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
      //check product and category exists
    public boolean isProCatExist(String pro, String cat)throws RemoteException {
        try {
            ps = con.prepareStatement("select * from product where pname =? and cname =?");
            ps.setString(1, pro);
            ps.setString(2, cat);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    //insert data into product table database
    public void insertProduct(int id, String pname, String cname, int  pqty, double pprice)throws RemoteException {
        String sql = "insert into product values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, pname);
            ps.setString(3, cname);
            ps.setInt(4,pqty);
            ps.setDouble(5,pprice);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product added successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//    @Override
//    //get product data
//    public void getProductsDValue(JTable table, String search) throws RemoteException{
//        String sql = "select * from product where concat(pid, pname, cname) like ? order by pid desc";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + search + "%");
//            rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            Object[] row;
//            while (rs.next()) {
//                row = new Object[5];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getInt(4);
//                row[4] = rs.getDouble(5);
//
//                model.addRow(row);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @Override
     //update product data
    public void updateProduct(int id, String pname, String cname, int qty, double price) throws RemoteException{
        String sql = "update product set pname=?, cname=?, pqty=?, pprice=? where pid = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, cname);
            ps.setInt(3, qty);
            ps.setDouble(4,price);
            ps.setInt(5,id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product successfully updated!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
        //delete product
    @Override
    public void deleteProduct(int id)throws RemoteException{
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product", "Delete Product", JOptionPane.OK_CANCEL_OPTION,0);
        if(x == JOptionPane.OK_OPTION){
            try {
                ps = con.prepareStatement("delete from product where pid=?");
                ps.setInt(1,id);
                if(ps.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Product deleted!");
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    
}
