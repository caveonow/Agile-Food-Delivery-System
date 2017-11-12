package Menu;
import java.util.Scanner;
/**
 * @author caveon
 */
public class CustomerMenu {

    public static void main(String[] args) {
        int userChoice;
        Scanner input = new Scanner(System.in);

        userChoice = CustomerMenu();
        
        switch (userChoice){
        case   1:  CustomerOrderMenu();
                   break;
        case   2:  CustomerHistoryMenu();
                   break;
        case   3:  CustomerProfileMenu();         
                   break;
        default :         
                }
    }
 
    public static int CustomerMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Order menu");
        System.out.println("2 - View Historical Order");
        System.out.println("3 - Configure Profile");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;    
    }
    
    public static int CustomerOrderMenu() {
        
        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Which menu would like to choose?");
        System.out.println("-------------------------------\n");
        System.out.println("1 - A");
        System.out.println("2 - B");
        System.out.println("3 - C");
        System.out.println("4 - D");

        selection = input.nextInt();
        return selection;    
    }
    
    public static int CustomerHistoryMenu() {
        
        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Select History Order for reference?");
        System.out.println("-----------------------------------\n");
        System.out.println("1 - A");
        System.out.println("2 - B");
        System.out.println("3 - C");
        System.out.println("4 - D");

        selection = input.nextInt();
        return selection;    
    }
    
     public static int CustomerProfileMenu() {
        
        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Select History Order for reference?");
        System.out.println("-----------------------------------\n");
        System.out.println("1 - A");
        System.out.println("2 - B");
        System.out.println("3 - C");
        System.out.println("4 - D");

        selection = input.nextInt();
        return selection;    
    }
}