import java.util.Scanner;
interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Microsoft Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel spreadsheet...");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
public class FactoryMethodDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        System.out.println("Welcome to the Document Management System");
        System.out.println("Please choose the type of document to create:");
        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                factory = new WordDocumentFactory();
                break;
            case 2:
                factory = new PdfDocumentFactory();
                break;
            case 3:
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return;
        }

        Document doc = factory.createDocument();
        doc.open();

        scanner.close();
    }
}

