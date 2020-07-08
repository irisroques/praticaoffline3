package questao1.p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*Maquina P2 que RECEBE uma mensagem de P1 (p1: cliente; p2: servidor) e ENVIA(p2:cliente ; p3: servidor) uma mensagem a P2 */
public class SCP2 {
    public static void main(String args[])throws UnknownHostException, IOException{
        //Fazendo lado cliente primeiro

        Socket socketCliente = new Socket(address, 5000); // adicionar endereço IP de P2
        System.out.println("INICIANDO CLIENTE P2");

        // Cria canal para enviar dados
        DataOutputStream fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());

        fluxoSaida.writeUTF("Oi eu sou P2");

        //Fazendo o lado servidor que recebe de p1
         ServerSocket socketServidor = new ServerSocket(5000);

         System.out.println("INICIANDO SERVIDOR P2");

         Socket socket = socketServidor.accept(); // aceito conexões via porta 5000

         System. out .println("IP do cliente conectado" + socket.getInetAddress().getHostAddress());

         //Cria um canal para receber dados de P4
        DataInputStream fluxoEntrada = new DataInputStream(socket.getInputStream());

        String msg = fluxoEntrada.readUTF();

        System. out .println(" Mensagem recebida do cliente: " + msg);
}