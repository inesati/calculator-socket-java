package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

///Clase servidor para recibir las peticiones de los clientes 
public class Server 
{
    // The server socket
    protected ServerSocket server;
    
    public Server(int port)
    {
        try
        {
            this.server = new ServerSocket(port);
            // Accept connections while server is active.
            
            while(true)
            {
                String mensaje = "";                            
                Socket client = server.accept();
                InetAddress direc = client.getInetAddress();
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    mensaje = in.readLine();
                    int slash = mensaje.indexOf("/");
                    int space = mensaje.indexOf(" ", slash);
                    String getParam = mensaje.substring(slash + 2, space); 
                    
                    
                    String[] params = getParam.split("&"); // Procesar paarametros  usando & para separarlas correctamente
                    String num1Str = "", num2Str = "", operacion = "";

                   
                    
            // Buscar los valores correctos de cada parámetro
                    for (String param : params) {
                        if (param.startsWith("num1=")) {
                            num1Str = param.substring(5); // Obtener valor del primer numero 
                        } else if (param.startsWith("num2=")) {
                            num2Str = param.substring(5); // Obtener valor del segundo numero 
                        } else if (param.startsWith("operacion=")) {
                            operacion = param.substring(10); // Obtener valor de operacion
                        }
                    }

                    
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    double resultado = 0;

                    // seccion de Operaciones suma y resta y multip y division 
                    switch (operacion.toLowerCase()) {
                        case "suma":
                            resultado = num1 + num2;
                            break;
                        case "resta":
                            resultado = num1 - num2;
                            break;
                        case "multiplicacion":
                            resultado = num1 * num2;
                            break;
                        case "division":
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                resultado = Double.NaN; // Para división entre 0
                            }
                            break;
                        default:
                            resultado = Double.NaN; // Cuando la Operacion sera no valida 
                            break;
                    }
                    
                    
                    
                    

                    // Respuesta 
                    PrintStream out = new PrintStream(client.getOutputStream());                                
                    out.print("HTTP/1.0 200 OK\r\n");
                    out.print("Content-type: text/html\r\n");
                    out.println("\r\n");
                    out.println("<html><head><title>Resultado de la Calculadora</title></head><body>");
                    out.println("<p>Operacin solicitada: " + operacion + "</p>");
                    out.println("<p> el Primer numero  es : (num1): " + num1 + "</p>");
                    out.println("<p>el Segundo numero es :  (num2): " + num2 + "</p>");
                    out.println("<p>Resultado: " + resultado + "</p>");
                    out.println("</body></html>");
                    out.flush();

                    System.out.println("la Operacion realizada es : " + operacion + " entre " + num1 + " y " + num2);
                    System.out.println("la Direccion de la llamada es: " + direc.getHostAddress());
                     client.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main( String[] arg ) {
        int port = 9999;
        new Server(port);
    }

    // Cerrar  server
    public void close()
    {
        try
        {
            server.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
