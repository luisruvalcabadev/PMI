import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

//import com.sun.tools.jdeprscan.scan.Scan;

public class Remote_Class
    extends UnicastRemoteObject
    implements Remote_Interface
{

    public Remote_Class() throws RemoteException {
        // Código del constructor
    }

    public void miMetodo1() throws RemoteException {
        // Aquí ponemos el código que queramos
        System.out.println("Estoy en miMetodo1()");
    }

    public int miMetodo2() throws RemoteException {
        // Aquí ponemos el código que queramos
        return 5;
    }

    public String mandarMensaje(String mensaje) throws RemoteException {
        System.out.println("Llego el mensaje al server");
        String respuesta =  "Llego tu mensaje!! :D \nMensaje: " + mensaje;

        return respuesta;
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(
                Integer.parseInt(args[0])
            );
            Remote_Interface mir = new Remote_Class();
            java.rmi.Naming.rebind(
                "//" +
                    java.net.InetAddress.getLocalHost().getHostAddress() +
                    ":" +
                    args[0] +
                    "/PruebaRMI",
                mir
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
