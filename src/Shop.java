import java.util.ArrayList;
import java.util.List;

public class Shop implements ShopI {

    List<Customer> customers = new ArrayList<>();

    List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {
        for (Product p: products){
            if(p.getName().equals(product.getName())){
                return false;
            }
        }
        notifyCustomers("adding",product);
        products.add(product);
        return true;
    }

    public boolean removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(name)) {
                products.remove(product);
                notifyCustomers("removing",product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        for(Customer c: this.customers){
            if(c.getName().equals(customer.getName())){
                return false;
            }
        }
        this.customers.add(customer);
        return true;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        for(Customer c: this.customers){
            if(c.getName().equals(customer.getName())){
                customers.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public void notifyCustomers(String event,Product product) {
        if(event.equals("adding")){
            for (Observer observer : customers){
                observer.handleAddEvent(product);
            }
        }else if(event.equals("removing")){
            for (Observer observer : customers){
                observer.handleRemoveEvent(product.getName());
            }
        }else{
            System.out.println("Unknown error!");
            System.exit(0);
        }
    }
}
