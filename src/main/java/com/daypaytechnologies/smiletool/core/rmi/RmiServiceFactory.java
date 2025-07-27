package com.daypaytechnologies.smiletool.core.rmi;

import com.daypaytechnologies.smiletool.executions.rmi.RestRmiExecutorService;

import java.rmi.registry.Registry;

public class RmiServiceFactory {

    private RmiServiceFactory() {};

    public static RmiServiceFactory getInstance() {
        return new RmiServiceFactory();
    }

    private Object lookUp(String serviceName) {
        try {
            Registry registry = RmiConnection.getRegistry();
            return registry.lookup(serviceName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(String.format("Service name not found %s ", serviceName));
        }
    }

    public RestRmiExecutorService getRestRmiExecutorService() {
        return  (RestRmiExecutorService) lookUp("RestRmiExecutorService");
    }
}
