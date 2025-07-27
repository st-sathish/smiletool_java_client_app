package com.daypaytechnologies.smiletool.executions.rmi;

import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RestRmiExecutorService extends Remote {

    String execute(RestRequestDTO restRequestDTO) throws RemoteException;
}
