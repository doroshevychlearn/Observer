public interface ShopI {
    public boolean addCustomer(Customer customer);
    public boolean removeCustomer(Customer customer);
    public void notifyCustomers(String event, Product product);

}
