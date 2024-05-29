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
public interface PurchaseInterface extends Remote{
    public String[] getUserValue(String email)throws RemoteException;
     public void insertPurchase(int id, int uid, String uName, String uPhone, int pid, String pname, int qty, double price, double total, String pDate, String address, String rDate, String supplier, String status)throws RemoteException;
     public int getProductQty(int pid)throws RemoteException;
     public void qtyUpdate(int pid, int qty)throws RemoteException;
     public void setSuppStatus(int id, String supp, String status)throws RemoteException;
      public void setDateStatus(int id, String rDate, String status)throws RemoteException;
      public void getProductsValue(JTable table, String search, int uid)throws RemoteException;
      public void getProductsValue(JTable table, String search)throws RemoteException;
       public void getOnTheWayProducts(JTable table, String search, String supplier)throws RemoteException;
       public void getSuppDeliProducts(JTable table, String search, String supplier)throws RemoteException;
}
