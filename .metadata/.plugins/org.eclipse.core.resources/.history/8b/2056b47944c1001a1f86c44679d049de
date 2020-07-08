package questao1.p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/*Maquina P1 que RECEBE uma mensagem de P4 (p4: cliente; p1: servidor) e ENVIA(p1:cliente ; p2: servidor) uma mensagem a P2 */
public class SCP1 {
    public static void main(String args[])throws UnknownHostException, IOException{
        //Fazendo lado cliente primeiro

        Socket socketCliente = new Socket(address, 5000); // adicionar endereço IP de P1
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
