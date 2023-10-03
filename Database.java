import java.io.File;
import java.util.ArrayList;

public class Database {

// 	public static void main(String[] args) {
	
//     Scanner scanner = new Scanner(System.in);
// 		List<Client> client = new ArrayList<>();


// 		while (true) {
// 			System.out.println("Enter user information or type 'quit' to exit:");
			
// 			String quit = scanner.nextLine();

// 			if (quit.equalsIgnoreCase("quit")) {
// 				break;
// 			}

// 			System.out.print("First Name: ");
// 			String firstName = scanner.nextLine();

// 			System.out.print("Last Name: ");
// 			String lastName = scanner.nextLine();

// 			System.out.print("Email: ");
// 			String Email = scanner.nextLine();

// 			System.out.print("License Plate: ");
// 			String licensePlate = scanner.nextLine();

// 			Client user = new Client(firstName, lastName, Email, licensePlate);
// 			client.add(user);	
// 	}

// 	scanner.close();
// 	  // Save user information to a text file
// 		try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientInformation.txt"))) {
// 			for (Client user : client) {
// 					writer.write(user.toString());
// 					writer.newLine();
// 			}
// 			System.out.println("User information saved to clientInformation.txt");
// 	} catch (IOException e) {
// 			System.err.println("Error writing to file: " + e.getMessage());
// 	}
//   }

	private File database = new File("Database.txt");
	private String data;
	private ArrayList<Client> clients;

	public Database() {
		data = "";
		clients = new ArrayList<Client>();
	}
}