package p4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*Maquina P4 que RECEBE uma mensagem de P3 (p3: cliente; p4: servidor) e ENVIA(p4:cliente ; p1: servidor) uma mensagem a P1 */
public class SCP4 {
    public static void main(String args[])throws UnknownHostException, IOException{
        //Fazendo lado cliente primeiro

        Socket socketCliente = new Socket("104.214.90.202", 80); // adicionar endereço IP de P3
        System.out.println("INICIANDO CLIENTE P4");

        // Cria canal para enviar dados
        DataOutputStream fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());

        fluxoSaida.writeUTF("Oi eu sou P4");

        //Fazendo o lado servidor que recebe de p3
         ServerSocket socketServidor = new ServerSocket(80);

         System.out.println("INICIANDO SERVIDOR P4");

         Socket socket = socketServidor.accept(); // aceito conexões via porta 5000

         System.out.println("IP do cliente conectado" + socket.getInetAddress().getHostAddress());

         //Cria um canal para receber dados de P4
        DataInputStream fluxoEntrada = new DataInputStream(socket.getInputStream());

        String msg = fluxoEntrada.readUTF();

        System.out.println(" Mensagem recebida do cliente: " + msg);
    }
    
}