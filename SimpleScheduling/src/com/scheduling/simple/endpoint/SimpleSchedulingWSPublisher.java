/*
 * SimpleSchedulingMain.java
 */
package com.scheduling.simple.endpoint;

import com.scheduling.simple.ws.SimpleSchedulingWS;
import javax.xml.ws.Endpoint;

public class SimpleSchedulingWSPublisher {
    
    public static void main(String args[]) {
        Endpoint.publish("http://localhost:9999/simplescheduling", new SimpleSchedulingWS());
        System.out.println("Service listening at: http://localhost:9999/simplescheduling?wsdl");
    }
}
