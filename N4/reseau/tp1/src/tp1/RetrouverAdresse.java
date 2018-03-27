package tp1;
/*
 * Deschamps Geoffrey groupe s
 */
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

public class RetrouverAdresse {

	//question 1: 65535 - 20(header)- 8(entete udp) = 65507
	
	//question 3: 1500 -20(header) - 8 = 1472
	
	public static void main(String[] args) throws UnknownHostException, SocketException {
		
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				try {
				NetworkInterface ni = e.nextElement();
				System.out.println(ni.getDisplayName() + " " + ni.getInterfaceAddresses() + " : MTU " + ni.getMTU());
				byte[] bytes = ni.getHardwareAddress();
				String rep = "";
				for (int i = 0; i < bytes.length; i++) {
					
					rep += String.format("%02x", bytes[i]);
				}
				System.out.println("@Mac: " + rep);
				} catch (Exception error) {
					System.out.println("pas d'@ mac");
					//error.printStackTrace();
				}
			}
			
		
	}
	
}
