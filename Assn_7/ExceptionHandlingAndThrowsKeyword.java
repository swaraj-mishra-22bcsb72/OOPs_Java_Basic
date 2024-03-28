import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionHandlingAndThrowsKeyword {

    public static void createFile() throws FileAlreadyExistsException, IOException {
        File myObj = new File("Demo.txt");

        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                throw new FileAlreadyExistsException("File already exists!");
            }

            try (FileWriter myWriter = new FileWriter("Demo.txt")) {
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("File Closed Successfully");
        }
    }

    public static void main(String[] args) {
        try {
            createFile();
        } catch (FileAlreadyExistsException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Driver's finally block: Clean up resources here.");
        }
    }
}
