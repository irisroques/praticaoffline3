package roteador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/*Maquina P1 que RECEBE uma mensagem de P4 (p4: cliente; p1: servidor) e ENVIA(p1:cliente ; p2: servidor) uma mensagem a P2 */
public class SCP1 {
    public static void main(String args[])throws UnknownHostException, IOException{
        //Fazendo lado cliente primeiro

    		Socket socketCliente2 = new Socket("13.65.89.52", 80);
			Socket socketCliente3 = new Socket("104.214.90.202", 80); // adicionar IP de P3
			Socket socketCliente4 = new Socket("104.215.122.68", 80); // adicionar IP de P4
			System.out.println("INICIANDO CLIENTE P1 PARA RECEBER ENTRADAS");

			// Cria canal para enviar dados
			DataOutputStream fluxoSaida2 = new DataOutputStream(socketCliente2.getOutputStream());
			DataOutputStream fluxoSaida3 = new DataOutputStream(socketCliente3.getOutputStream());
			DataOutputStream fluxoSaida4 = new DataOutputStream(socketCliente4.getOutputStream());

			
			
			
			  //Fazendo o lado servidor que recebe de p4,p3 e p2
			
			 System.out.println("INICIANDO SERVIDOR");
	        
	         try (ServerSocket socketServidorP2 = new ServerSocket(80, 1, InetAddress.getByName("ip" ))) {

				 Socket socket2 = socketServidorP2.accept(); // aceito conexões via porta 5000
				 //Cria um canal para receber dados de P2
				 DataInputStream fluxoEntrada2 = new DataInputStream(socket2.getInputStream());
				 String msg2 = fluxoEntrada2.readUTF();
				 System.out.println(" Mensagem do Cliente 2 " + msg2);
				 
				 fluxoSaida3.writeUTF(msg2);
				
	         
	         }
	         
	         try(ServerSocket socketServidorP3 = new ServerSocket(80, 1, InetAddress.getByName("ip" ))){
	        	 
	        	 Socket socket3 = socketServidorP3.accept();
				 DataInputStream fluxoEntrada3 = new DataInputStream(socket3.getInputStream());
				 String msg3 = fluxoEntrada3.readUTF();
				 System.out.println("Mensagem do Cliente 3 " + msg3);
				 
				 fluxoSaida4.writeUTF(msg3);
				 
	         }
				
			try(ServerSocket socketServidorP4 = new ServerSocket(80, 1, InetAddress.getByName("ip" ))){
				
				 Socket socket4 = socketServidorP4.accept();
				 DataInputStream fluxoEntrada4 = new DataInputStream(socket4.getInputStream());
				 String msg4 = fluxoEntrada4.readUTF();
				 System.out.println("Mensagem do Cliente 4 " + msg4);
				 
				 fluxoSaida2.writeUTF(msg4);
				
			}	 
				 
				 	
				 

			socketCliente2.close();
			socketCliente3.close();
			socketCliente4.close();

				 
				 
				 
				 
			
			}
		     
		     
		     
		
        

      
}
