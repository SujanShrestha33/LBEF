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
 * @author Administrator
 */
public interface SupplierInterface extends Remote {
    //Supplier part
    public int getMaxSuppRow() throws RemoteException;
    public boolean isSuppEmailExist(String email)throws RemoteException;
    public boolean isSuppPhoneExist(String phone)throws RemoteException;
    public boolean isSuppUsernameExist(String name)throws RemoteException;
     public void insertSupp(int id, String username, String email, String pass, String phone,
            String address1, String address2) throws RemoteException;
     public void getSupplierValue(JTable table, String search)throws RemoteException;
     public void updateSupp (int id, String username, String email, String pass, String phone,
            String address1, String address2) throws RemoteException;
     public void deleteSupp(int id) throws RemoteException;
     public int getSupplierId(String email) throws RemoteException;
     public String getSupplierName(String email) throws RemoteException;
     public String[] getSupplierValue(int id) throws RemoteException;
     public int countSuppliers() throws RemoteException;
     public String[] getSuppliers() throws RemoteException;
}
