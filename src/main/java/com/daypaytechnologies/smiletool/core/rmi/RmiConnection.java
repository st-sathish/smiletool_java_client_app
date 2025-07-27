package com.daypaytechnologies.smiletool.core.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class RmiConnection {

    private static Registry registry;

    private RmiConnection() {}

    public static synchronized Registry getRegistry() {
        try {
            if(registry == null) {
                registry = LocateRegistry.getRegistry("localhost", 1099);
            }
            return registry;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't get RMI Registry under port 1099");
        }
    }
}
