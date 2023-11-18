package modern.challenge;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) throws SocketException {

        Enumeration allNetworkInterfaces = NetworkInterface.getNetworkInterfaces();

        while (allNetworkInterfaces.hasMoreElements()) {

            NetworkInterface ni = (NetworkInterface) allNetworkInterfaces.nextElement();
            System.out.println("\nDisplay Name: " + ni.getDisplayName());
            System.out.println(ni.getDisplayName() + " is up and running ? " + ni.isUp());
            System.out.println(ni.getDisplayName() + " is multicast capable ? " + ni.supportsMulticast());
            System.out.println(ni.getDisplayName() + " name: " + ni.getName());
            System.out.println(ni.getDisplayName() + " is virtual ? " + ni.isVirtual());

            Enumeration ips = ni.getInetAddresses();
            if (!ips.hasMoreElements()) {
                System.out.println("IP addresses: none");
            } else {
                System.out.println("IP addresses:");
                while (ips.hasMoreElements()) {
                    InetAddress ip = (InetAddress) ips.nextElement();
                    System.out.println("IP: " + ip);
                }
            }
        }
    }
}
