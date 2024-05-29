/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author aryen
 */
//package com.pdsapp.controller;
import dao.CategoryDaoImp;
import dao.LoginDaoImp;
import dao.ProductDaoImp;
import dao.PurchaseDaoImp;
import dao.SupplierDaoImp;
import dao.UserDaoImp;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OSServer {

    public static void main(String args[]) {
        try {
            UserDaoImp imp = new UserDaoImp();
            LoginDaoImp lg = new LoginDaoImp();
            PurchaseDaoImp pi = new PurchaseDaoImp();
            SupplierDaoImp si = new SupplierDaoImp();
            ProductDaoImp pri = new ProductDaoImp();
            CategoryDaoImp ci = new CategoryDaoImp();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.bind("UserDao", imp);
            reg.bind("LoginInterface", lg);
            reg.bind("PurchaseInterface", pi);
            reg.bind("SupplierInterface", si);
            reg.bind("ProductInterface", pri);
            reg.bind("CategoryInterface", ci);

            System.out.println("Server has been successfully initiated..");

        } catch (AlreadyBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
