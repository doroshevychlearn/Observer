public class Customer implements Observer {

    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void handleAddEvent(Product product) {
        System.out.println(Start.ANSI_PURPLE+"EMAIL:"+Start.ANSI_BLUE);
        System.out.println("Dear " + name + "!\n" +
                "We have some changes in our products\n");
        System.out.println("We added a new product to our product list\n");
        System.out.println(product+Start.ANSI_RESET);
    }

    @Override
    public void handleRemoveEvent(String product) {
        System.out.println(Start.ANSI_RED+"EMAIL:"+Start.ANSI_RESET);
        System.out.println("Dear " + name + "!\n" +
                "We have some changes in our products\n");
        System.out.println("We have removed product \""+product+"\" from our product list\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
