📚 Description

This project implements a calculator service using server socket in Java, capable of performing the four basic operations: addition, subtraction, multiplication, and division. The calculator receives client requests through a simple HTTP server, processing the URL parameters to perform the calculations. This project is part of the Operating Systems and Administration (SOA) course.

🚀 Features

Connection via server socket to receive HTTP requests.
Mathematical operations supported:
Addition
Subtraction
Multiplication
Division (with division by zero handling)
Responds to the client in HTML format with the calculation result.

⚙️ Requirements

Language: Java
Recommended Version: JDK 8 or later
Recommended IDE: IntelliJ, Eclipse, or any text editor with Java support

📦 Installation and Execution

1.Clone the repository:

git clone https://github.com/your-username/calculator-socket-java.git
cd calculator-socket-java

2.Compile the server:

javac server/Server.java

3.Run the server:

java server.Server

4.Make a request from the browser:
Open your browser and enter the URL:

http://localhost:9999/?num1=10&num2=5&operacion=suma

num1: First number
num2: Second number
operacion: Type of operation (suma, resta, multiplicacion, division)

Examples:

Addition: http://localhost:9999/?num1=10&num2=5&operacion=suma
Subtraction: http://localhost:9999/?num1=10&num2=5&operacion=resta
Multiplication: http://localhost:9999/?num1=10&num2=5&operacion=multiplicacion
Division: http://localhost:9999/?num1=10&num2=5&operacion=division


🛠️ Project Structure

server/Server.java: Source code of the server with the calculator logic.
README.md: Project documentation.

📧 Contact
Feel free to reach out if you have any questions or suggestions!
