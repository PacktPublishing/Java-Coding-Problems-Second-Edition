package modern.challenge;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {
    
    public static void main(String[] args) throws SocketException {
        
        Enumeration enumInterfaces = NetworkInterface.getNetworkInterfaces();
        
        while (enumInterfaces.hasMoreElements()) {
            
            NetworkInterface net = (NetworkInterface) enumInterfaces.nextElement();
            System.out.println("\nNetwork Interface Display Name: " + net.getDisplayName());
            System.out.println(net.getDisplayName() + " is up and running ? " + net.isUp());
            System.out.println(net.getDisplayName() + " Supports Multicast: " + net.supportsMulticast());
            System.out.println(net.getDisplayName() + " Name: " + net.getName());
            System.out.println(net.getDisplayName() + " Is Virtual:  " + net.isVirtual());
            
            System.out.println("IP addresses:");
            
            Enumeration enumIP = net.getInetAddresses();
            while (enumIP.hasMoreElements()) {
                InetAddress ip = (InetAddress) enumIP.nextElement();
                System.out.println("IP address:" + ip);
            }
        }
    }
}