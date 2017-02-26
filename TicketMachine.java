

public class TicketMachine
{
    private int price;
    private int balance;
    private int total;
    private int refund;
    private int tickets;
    
    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
        refund = 0;
        tickets = 0;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public void insertMoney(int amount)
    {
        if (amount > 0)
        {
            balance += amount;
        }
        else
        {
            System.out.println("Please insert a sensible amount of money.");
        }
    }
    
    public void printTicket()
    {
        if (balance > 0)
        {
            if (balance >= price)
            {
                tickets = purchaseTickets();
                
                int i = 1;
                
                while (i <= tickets)
                {
                    System.out.println("------------------");
                    System.out.println("--The BlueJ Line--");
                    System.out.println("--Ticket " + i);
                    System.out.println("- " + price + " dollars.");
                    System.out.println("------------------");
                    
                    i++;
                }
                
                total += balance;
                
                refund = refundBalance();
                
                if (refund == 0)
                {
                    System.out.println("No change given.");
                }
                else
                {
                    System.out.println("Amount to refund: " + refund + " dollars.");
                }
                
                balance = 0;
            }
            else
            {
               System.out.println("Please insert " + (price - balance) + " more cents."); 
            }
        }
        else
        {
            System.out.println("Please insert a positive amount of money.");
        }
    }
    
    public int refundBalance()
    {
        int amountToRefund;
        
        amountToRefund = balance - price * tickets;
        
        balance = 0;
        
        return amountToRefund;
    }
    
    public int purchaseTickets()
    {
        int numberOfTickets;
        
        numberOfTickets = balance / price;
        
        return numberOfTickets;
    }
    
}   
