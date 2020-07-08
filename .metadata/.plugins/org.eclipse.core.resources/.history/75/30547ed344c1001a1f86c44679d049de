package questao1.p3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*Maquina P3 que RECEBE uma mensagem de P2 (p2: cliente; p3: servidor) e ENVIA(p3:cliente ; p4: servidor) uma mensagem a P4 */
public class SCP3 {
    public static void main(String args[])throws UnknownHostException, IOException{
        //Fazendo lado cliente primeiro

        Socket socketCliente = new Socket(address, 5000); // adicionar endereço IP de P3
        System.out.println("INICIANDO CLIENTE P1");

        // Cria canal para enviar dados
        DataOutputStream fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());

        fluxoSaida.writeUTF("Oi eu sou P1");

        //Fazendo o lado servidor que recebe de p4
         ServerSocket socketServidor = new ServerSocket(5000);

         System.out.println("INICIANDO SERVIDOR P1");

         Socket socket = socketServidor.accept(); // aceito conexões via porta 5000

         System. out .println("IP do cliente conectado" + socket.getInetAddress().getHostAddress());

         //Cria um canal para receber dados de P4
        DataInputStream fluxoEntrada = new DataInputStream(socket.getInputStream());

        String msg = fluxoEntrada.readUTF();

        System. out .println(" Mensagem recebida do cliente: " + msg);
    }
    
}