import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 54660);
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite sua 'Mesagem' ou 'Sair' para finalizar aplicação");
            String mensagemCompleta = "";
            String mensagem = "";
            Boolean continua = true;
            while (continua){
                mensagem = br.readLine();
                if(mensagem.equals("Sair")) {
                    continua = false;
                    mensagem = "";
                }
                mensagemCompleta = mensagemCompleta + " " + mensagem;
                mensagem = "";
            }
            saida.writeUTF(mensagemCompleta);

        } catch (IOException e) {
            System.out.println("Não foi possível conectar...");
        }

    }
}
