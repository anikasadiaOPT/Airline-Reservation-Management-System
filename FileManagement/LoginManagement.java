package FileManagement;
import Entities_All.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
 
public class LoginManagement{
	String filePath;

	public LoginManagement(){
		this.filePath = "DataFiles/user.txt";
	}

	public void writeUserToFile(User u, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file, append);  
            writer.write(u.FileWriteFormat() + ""); 
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println("An error occurred while writing to the file: " + ex.getMessage());
        }
    }
    public void addUser(String username, String email, String password) {
        User newUser = new User(username, email, password);
        writeUserToFile(newUser, true);
    }
    public void writeMultipleUsersToFile(User[] users) {
        for (User user : users) {
            writeUserToFile(user, true);
        }
    }

    public boolean validateUser(String username, String email, String password) {
        try {
            File file = new File(filePath);
            java.util.Scanner scanner = new java.util.Scanner(file);
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
    
                if (parts.length >= 3) {
                    String storedUsername = parts[0].trim();
                    String storedEmail = parts[1].trim();
                    String storedPassword = parts[2].trim();
    
                    if (storedUsername.equals(username) &&
                        storedEmail.equals(email) &&
                        storedPassword.equals(password)) {
                        scanner.close();
                        return true;
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();  // This will help you debug by printing the stack trace
        }
    
        return false;
    }
    
}