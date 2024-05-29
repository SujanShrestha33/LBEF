/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTable;
/**
 *
 * @author aryen
 */
public interface UserDao extends Remote{
    public boolean isUserEmailExist(String email) throws RemoteException;
    public boolean isUserPhoneExist(String phone) throws RemoteException;
    public void insertUser(int id, String username, String email, String pass, String phone, 
            String seq, String ans, String address1, String address2)throws RemoteException;
    public int getMaxUserRow() throws RemoteException;
    public int getUserId(String email)throws RemoteException;
    public String[] getUserValue(int id) throws RemoteException;
    public void deleteUser(int id) throws RemoteException;
    public void updateUser(int id, String username, String email, String pass, String phone, 
            String seq, String ans, String address1, String address2) throws RemoteException;
    public void getUsersValue(JTable table, String search)throws RemoteException;
    
    
     
       
   
//       public void getProductsDValue(JTable table, String search) throws RemoteException;
       
    
       
       

     
     
    
    
    
    
}

