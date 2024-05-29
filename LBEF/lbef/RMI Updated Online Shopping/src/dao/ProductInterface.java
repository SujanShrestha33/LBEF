/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Administrator
 */
public interface ProductInterface extends Remote {
      //product
       public int getMaxProductRow() throws RemoteException;
       public int countCategories()throws RemoteException;
       public String[] getCat()throws RemoteException;
       public boolean isProductIDExist(int id) throws RemoteException;
       public boolean isProCatExist(String pro, String cat)throws RemoteException;
       public void insertProduct(int id, String pname, String cname, int  pqty, double pprice)throws RemoteException;
       public void updateProduct(int id, String pname, String cname, int qty, double price) throws RemoteException;
       public void deleteProduct(int id)throws RemoteException;
}
