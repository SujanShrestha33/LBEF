package rmi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryen
 */
//package com.pdsapp.controller;

import dao.CategoryInterface;
import dao.LoginInterface;
import dao.ProductInterface;
import dao.UserDao;
import dao.PurchaseInterface;
import dao.SupplierInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class OSClient {
    private String host = "127.0.0.1";
    private String serviceName = "UserDao";
    private String service2Name = "LoginInterface";
    private String service3Name = "PurchaseInterface";
    private String service4Name = "SupplierInterface";
    private String service5Name = "ProductInterface";
    private String service6Name = "CategoryInterface";
    private int port = 1099;


    // return UserDao object
    public UserDao getRemoteService(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (UserDao) reg.lookup(serviceName);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
     public LoginInterface getRemote2Service(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (LoginInterface) reg.lookup(service2Name);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
     public PurchaseInterface getRemote3Service(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (PurchaseInterface) reg.lookup(service3Name);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
     
     public SupplierInterface getRemote4Service(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (SupplierInterface) reg.lookup(service4Name);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
     
      public ProductInterface getRemote5Service(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (ProductInterface) reg.lookup(service5Name);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
      
        public CategoryInterface getRemote6Service(){
        try{
            
            Registry reg = LocateRegistry.getRegistry(host, port);
            return (CategoryInterface) reg.lookup(service6Name);

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
            return null;
        }
    }
    

}