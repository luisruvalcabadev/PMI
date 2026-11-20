import java.util.Scanner;
import java.rmi.Naming;

public class Client {

    public static void main(String[] args){
        try {
            Remote_Interface rm = (Remote_Interface)Naming.lookup("//127.0.0.1:1234/PruebaRMI");

            System.out.println("Escribe un mensaje: ");
            Scanner sc = new Scanner(System.in);
            String mensaje = sc.nextLine();

            //rm.mandarMensaje(mensaje);
            String res = rm.mandarMensaje(mensaje);
            System.out.println(res);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
