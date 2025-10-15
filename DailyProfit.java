// Ginny Ritchie
// Java Final Project- Child Page
// 10-15-2025

// CH 14 SWING
import java.awt.Color;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

// CH4 DECLARING AND USING CLASSES/OBJECTS
public class DailyProfit extends GinnyRoseStudio
{
    // CH 3 MAIN METHOD
    public static void main(String[] args)
    {
    
    // TRYING TO MAKE A PRETTY INTERFACE
    UIManager.put("Panel.background", new Color(157, 193, 131));
    UIManager.put("OptionPane.background", new Color(157, 193, 131));
    UIManager.put("OptionPane.messageForeground", new Color(255, 253, 208));
    UIManager.put("OptionPane.messageFont", new Font("Serif", Font.BOLD, 16));


        // NEED TO DCLARE MY TOTAL PROFIT
        double totalProfit = 0.0;

        // CH 8 ARRAY LIST
        ArrayList<GinnyRoseStudio> services = new ArrayList<>();

        // CH 6 LOOPING
        for (int i = 1; i <= 3; ++i)
        {
            String service = JOptionPane.showInputDialog("Enter a service (Facial, Massage, Wax, Spray Tan or Permanent Jewlery)" + i + "or type QUIT to stop and calculate the total profit.");
        
            if (service.equalsIgnoreCase("QUIT"))
            {
                break;
            }

            //CH 10 EXCEPTION TRY/CATCH BLOCK
            try
            {
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price for " + service + ":"));
            GinnyRoseStudio newService = new GinnyRoseStudio(service, price);
            newService.showServiceDialog();
            services.add(newService);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "That was an invalid number entry. Please try again!");
                i--;
            }
        }

        // DAILY PROFIT CALCULATION
        double dailyProfit = calculateTotalProfit(services);
        JOptionPane.showMessageDialog(null, String.format("The Daily Profit is: $ %.2f", dailyProfit));
        saveToFile(services);

        // CH 5 MAKE DECISIONS WITH IF/ELSE
         if (dailyProfit < 100)
        {
        JOptionPane.showMessageDialog(null, "You need to make more money girlfriend!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You made a good profit today! I'm proud of you!");
        }
    }

    // CH 11 FILE I/O
    public static void saveToFile(ArrayList<GinnyRoseStudio> services)
    {
        try
        {
            FileWriter writer = new FileWriter("GRS_Daily_Profit.txt");
            for (GinnyRoseStudio s : services)
            {
                writer.write(s.getServiceDescription() + ": $" + s.getPrice() + "\n");
            }
            writer.close();
            System.out.println("Your data is saved to GRS_Daily_Profit.txt");
        }
        catch (IOException e)
        {
            System.out.println("There was an error writing to the file: " + e.getMessage());
        }
    }

        // CH 8 ARRAY + CH 3 STATIC METHOD
    public static double calculateTotalProfit(ArrayList<GinnyRoseStudio> services)
    {
        double total = 0.0;
        for (GinnyRoseStudio service : services)
        {
            total += service.getPrice();
        }
        return total;
    }
}
