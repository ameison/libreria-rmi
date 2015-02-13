package com.proyecto.rmi;

import java.rmi.*;

public interface InterfaceRemota extends Remote {
    public int suma (int a, int b) throws RemoteException; 
}
