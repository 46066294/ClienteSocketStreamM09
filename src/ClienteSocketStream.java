import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 46066294p on 27/01/16.
 */

    /*
    TCP: Orientado a conexion segura (se pide acuse de recibo
    tanto emisor como receptor). Se comunican para acordar los envios
     */

    /*
    UDP: Envio mas rapido que TCP (sin acuse de recibo)
    p.ej. videoconferencias
     */

    /*
    Cliente - Servidor: Cliente era quien pedia informacion y el
    servidor quien tenia los recursos que pueden ser solicitados
     */

public class ClienteSocketStream {
    public static void main(String[] args) {
        Socket clienteSocket = new Socket();
        System.out.println("Creado el socket cliente");
        System.out.println("Estableciendo conexion");

        /*
        Un puerto es un lugar logico donde escuchar una conexion
        Hay asta 65 mil puertos. Hay algunos puertos reservados
        el 80 es http
        el 5432 es reservado para postgreSQL
        ...

         */

        InetSocketAddress addr = new InetSocketAddress("172.31.83.42", 5555);
        try {
            /*
            Este comando conecta el socket con la direccion y
            el puerto especificado
             */

            clienteSocket.connect(addr);

            /*
            Los comandos siguientes por donde va a escuchar y por
            donde va a hablar
             */
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            System.out.println("\n...enviando mensaje");

            String mensaje = "TONTUNO";

            /*
            Ponemos el mensaje en el canal
            RECORDAR que hay que ponerlo en bits
             */
            os.write(mensaje.getBytes());

            System.out.println("...mensaje enviado");

            clienteSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
