import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CTemplateGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the template name from the user
        System.out.print("Enter the template name: ");
        String templateName = scanner.nextLine();

        // Get the directory from the user
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.out.println("Failed to create the directory. Please check the path and try again.");
                return;
            }
        }

        // Generate the C template content
        String templateContent = generateTemplateContent(templateName);

        // Create the C template file
        String fileName = templateName + ".c";
        File templateFile = new File(directory, fileName);

        try {
            // Write the template content to the file
            FileWriter writer = new FileWriter(templateFile);
            writer.write(templateContent);
            writer.close();

            System.out.println("C template created successfully at: " + templateFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while creating the template file: " + e.getMessage());
        }
    }

    private static String generateTemplateContent(String templateName) {
        // Customize the template content as per your requirements
        return "#include <stdio.h>\n\nint main() {\n    printf(\"Hello, " + templateName + "!\\n\");\n    return 0;\n}";
    }
}
