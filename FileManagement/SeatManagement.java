package FileManagement;

import Entities_All.SeatSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SeatManagement {

    private String filePath;

    // Constructor that defines the file path
    public SeatManagement() {
        this.filePath = "DataFiles/seat.txt"; 
    }

    public void writeSeatToFile(SeatSelection seat, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file, append);  
            writer.write(seat.FileWriteFormat() + ""); 
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to the file: " + ex.getMessage());
        }
    }
    public void writeMultipleSeatsToFile(SeatSelection[] seats) {
        for (SeatSelection seat : seats) {
            writeSeatToFile(seat, true);
        }
    }
}
