package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import javax.swing.JFrame;

public class UserDaoImp extends UnicastRemoteObject implements UserDao{
    public UserDaoImp() throws RemoteException {
        super();
    }

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    JFrame frame;

    //get user table max row
    @Override
    public int getMaxUserRow() throws RemoteException{
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(uid) from user");

            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    //check email already exists
    @Override
    public boolean isUserEmailExist(String email) throws RemoteException {
        try {
            ps = con.prepareStatement("select * from user where uemail = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //check phone number already exists
    
    
    @Override
    public boolean isUserPhoneExist(String phone) throws RemoteException {
        try {
            ps = con.prepareStatement("select * from user where uphone = ?");
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //insert data into user table database
    @Override
    public void insertUser(int id, String username, String email, String pass, String phone, 
            String seq, String ans, String address1, String address2)throws RemoteException
    {
        String sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, pass);
            ps.setString(5, phone);
            ps.setString(6, seq);
            ps.setString(7, ans);
            ps.setString(8, address1);
            ps.setString(9, address2);
            if(ps.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "User added successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //update user data
    @Override
    public void updateUser(int id, String username, String email, String pass, String phone, 
            String seq, String ans, String address1, String address2) throws RemoteException {
        String sql = "update user set uname=?, uemail=?, upassword=?, uphone=?, usecqus=?, uans=?, uaddress1=?, uaddress2=? where uid = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, phone);
            ps.setString(5, seq);
            ps.setString(6, ans);
            ps.setString(7, address1);
            ps.setString(8, address2);
            ps.setInt(9, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "User data successfully updated!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //delete user
    @Override
    public void deleteUser(int id) throws RemoteException{
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this account", "Delete Account", JOptionPane.OK_CANCEL_OPTION,0);
        if(x == JOptionPane.OK_OPTION){
            try {
                ps = con.prepareStatement("delete from user where uid=?");
                ps.setInt(1,id);
                if(ps.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Account deleted!");
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
        
    //get user id
    @Override
    public int getUserId(String email)throws RemoteException {
        int id = 0;
        try {
            ps = con.prepareStatement("select uid from user where uemail = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }        
    
    //get user data
    @Override
    public void getUsersValue(JTable table, String search)throws RemoteException{
        String sql = "select * from user where concat(uid, uname, uemail) like ? order by uid desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();   
            Object[] row;
            while(rs.next()){
                row = new Object[9];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                model.addRow(row);
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   
    @Override
        public String[] getUserValue(int id) throws RemoteException {
            String[] value = new String[9];
        try {
            ps = con.prepareStatement("select * from user where uid = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                value[0] = rs.getString(1);
                value[1] = rs.getString(2);
                value[2] = rs.getString(3);
                value[3] = rs.getString(4);
                value[4] = rs.getString(5);
                value[5] = rs.getString(6);
                value[6] = rs.getString(7);
                value[7] = rs.getString(8);
                value[8] = rs.getString(9);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    
    
}

    
    

