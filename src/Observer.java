public interface Observer {
    public void handleAddEvent(Product product);
    public void handleRemoveEvent(String product);
}
