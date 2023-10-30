import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Server {
	private File database = new File("Database.txt");
	private String data;
	private ArrayList<User> users;
	private ArrayList<Client> clients;
	private ArrayList<Owner> owners;

	public Server() {
		data = "";
		users = new ArrayList<User>();
		clients = new ArrayList<Client>();
		owners = new ArrayList<Owner>();
	}

	public boolean isClient(String username) {
		for(Client c: clients) {
			if(c.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public Client getClient(String username) {
		for(Client c: clients) {
			if(c.getUsername().equals(username))
				return c;
		}
		return null;
	}

	public void addClient(Client c) {
		clients.add(c);
	}

	public Client[] getClients() {
		Client[] c = new Client[clients.size()];
		for(int i = 0; i < c.length; i++) {
			c[i] = clients.get(i);
		}
		return c;
	}

	public boolean isOwner(String username) {
		for(Owner o: owners) {
			if(o.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public Owner getOwner(String username) {
		for(Owner o: owners) {
			if(o.getUsername().equals(username))
				return o;
		}
		return null;
	}

	public void addOwner(Owner o) {
		owners.add(o);
	}

	public boolean isUser(String username) {
		for(User u: users) {
			if(u.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public User getUser(String username) {
		for(User u: users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}

		return null;
	}

	public void addUser(User thisUser) {
		users.add(thisUser);
	}

	// public void printUsers() {
	// 	for(User u: users) {
	// 		System.out.println(u);
	// 	}
	// }

	public boolean accountFound(String username, String password) {
		for(User u: users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password))
				return true;
		}

		return false;
	}

	public void updateDatabase(String action, User user) {
		Date d = new Date();
		String newData = action + "|" + user + "|Time: " + d + "\n";
		data = data.concat(newData);

		try {
			FileWriter myWriter = new FileWriter(database);
			myWriter.write(data);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}