// Ginny Ritchie
// Java Final Project
// 10-15-2025

//CH 14 SWING
import javax.swing.JOptionPane;

// CH 4 CLASSES AND OBJECTS
public class GinnyRoseStudio 

{
    private String serviceDescription;
    private double price;

    public GinnyRoseStudio() {
        // default constructor
    }

    public GinnyRoseStudio(String serviceDescription, double price) {
        this.serviceDescription = serviceDescription;
        this.price = price;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showServiceDialog() {
        JOptionPane.showMessageDialog(null, "Service added: " + serviceDescription + " for $" + price);
    }
}
