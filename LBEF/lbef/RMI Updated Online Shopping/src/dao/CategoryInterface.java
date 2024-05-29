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
public interface CategoryInterface extends Remote {
       //category
       public int getMaxCatRow() throws RemoteException;
       public boolean isCatIDExist(int id)throws RemoteException;
       public boolean isCategoryNameExist(String cname)throws RemoteException;
       public void insertCategory(int id, String cname, String desc)throws RemoteException;
       public void getCategoriesValue(JTable table, String search)throws RemoteException ;
       public void updateCategory(int cid, String cname, String cdesc)throws RemoteException;
       public void deleteCategory(int id)throws RemoteException;
       
       public void refund(int id)throws RemoteException;
       public void transaction(JTable table, String search) throws RemoteException;
}
