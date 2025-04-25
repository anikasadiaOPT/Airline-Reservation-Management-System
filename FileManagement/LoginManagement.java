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
}