import java.util.Scanner;

public class Start {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();

    public void mainPage() {
        System.out.println(
                "Enter \'reg\' for add customer to our customer list!\n" +
                "Enter \'add\' for add product!\n" +
                "Enter remove for \'remove\' product!\n" +
                "Enter \'del\' for delete customer from our customer list!\n" +
                "Enter \'close\' for stop the program:>\n");
        String event = scanner.next();
        if (event.toLowerCase().equals("add")) {
            addProduct();
        }else if(event.toLowerCase().equals("remove")){
            removeProduct();
        }else if(event.toLowerCase().equals("reg")){
            addCustomer();
        }else if(event.toLowerCase().equals("del")){
            removeCustomer();
        }
        else if(event.toLowerCase().equals("close")){
            System.exit(0);
        }
        else{
            System.out.println(ANSI_RED + "Command not found.Please try again!\n \n"+ANSI_RESET);
            mainPage();
        }
    }

    public void addProduct() {
        String name;
        int price;
        System.out.println("Add product:");
        System.out.println("Enter name: ");
        name = scanner.next();
        System.out.println("Enter price(only number): ");
        price = scanner.nextInt();
        boolean b = shop.addProduct(new Product(name, price));
        if(b){
            System.out.println(ANSI_GREEN+"We have added new product!\n \n"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+"Such a product already exists!"+ANSI_RESET);
        }
        mainPage();
    }

    public void removeProduct(){
        String name;
        System.out.println("Remove product by name:");
        System.out.println("Enter Name: ");
        name = scanner.next();
        boolean result = shop.removeProduct(name);
        if(result){
            System.out.println(ANSI_GREEN+"Product deleted successfully\n \n"+ANSI_RESET);
        }else {
            System.out.println(ANSI_RED+"Such a product does not exist\n \n"+ANSI_RESET);
        }
        mainPage();
    }
    public void addCustomer(){
        String name;
        System.out.println("Remove product by name:");
        System.out.println("Enter Name: ");
        name = scanner.next();
        boolean b = shop.addCustomer(new Customer(name));
        if(b){
            System.out.println(ANSI_GREEN+"Customer added successfully\n \n"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+"Such a user already exists\n"+ANSI_RESET);
        }
        mainPage();
    }
    public void removeCustomer(){
        String name;
        System.out.println("Remove customer by name:");
        System.out.println("Enter Name: ");
        name = scanner.next();
        boolean b = shop.removeCustomer(new Customer(name));
        if(b){
            System.out.println(ANSI_GREEN+"Customer removed successfully\n \n"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+"Such a customer does not exist\n"+ANSI_RESET);
        }
        mainPage();
    }


}
