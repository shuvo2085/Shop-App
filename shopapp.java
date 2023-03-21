// importing BufferedReader class
import java.io.BufferedReader;
// Importing inputStreamReader class
import java.io.InputStreamReader;
import java.util.Scanner;


class Product{
	int id;
	String name;
    int stockLevel;
	double price;
	public Product(int id, String name, int stockLevel,  double price) {
		this.id = id;
		this.name = name;
        this.stockLevel = stockLevel;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

    public int getStockLevel() {
        
		return stockLevel;
	}
	public double getPrice() {
		return price;
	}
}



public class shopapp
{	
	public static void main(String[] args)
    {
		Product Tshart = new Product(1, "Tshart", 4, 240);
		Product Pant = new Product(2, "Pant", 6, 500);
        Product Book = new Product(3, "Book", 8, 240);	
        Product pen = new Product(4, "pen", 20, 10);
        Product pencil = new Product(5, "pencil", 10, 5);
        
        Product[] productArray = {Tshart,Pant,Book,pen,pencil};



        boolean pro = true;
        while (pro) 
        {
                //All product  name:
                for (int i = 0; i < productArray.length; i++)
                 {
                    System.out.println(productArray[i].getId()+": "+productArray[i].getName());
                 }
                // creating input for user using bufferedReader class
		        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
                System.out.print("press 0 to exit=> /Select product id:=> ");  
                try
                {
                    // java user input of Int data type
                    int product = Integer.parseInt(input.readLine())-1;
                        //Checking if the product available here:
                    if (product <= productArray.length-1 && product>=0)
                    {
                        //Get product Name, StockLevel, Price:
                        String name = productArray[product].getName();
                        int stock = productArray[product].getStockLevel();
                        double productprice = productArray[product].getPrice();
                        int totalprice = ((int)productprice*stock); // all getName() product price;
    
		                System.out.println("Name:" + " " +name);           //Print Product Name;
		                System.out.println("Stock:" + " " +stock);         //Print Product StockLevel;
                        System.out.println("Price:" + " " +productprice);  //Print product Price;
                        System.out.println("All "+productArray[product].name +" price = " + totalprice); //Print all getName() product Price;
                        System.out.println("_______________________");
                        //::::::::::::::::::::::::[Start While Loop]::::::::::::::::::::::
                        boolean BSproduct = true;
                        while (BSproduct) {
        
                        //Product Buy, Sell and Set-Price option :
                        Scanner buysell = new Scanner(System.in);    
                        System.out.print("Bye:1 /Sell:2 /Set-Price:3 /Exit:press any int ");  
                        int BS = buysell.nextInt();
                            switch (BS) 
                            {
                                case 1:
                                    //Product Buying Process::::::::::::::::::::::::
                                    Scanner totalbuy = new Scanner(System.in);    
                                    System.out.print("Enter total product to buy: ");  
                                    int TB = totalbuy.nextInt();
                                    int totalproduct = productArray[product].getStockLevel()+TB; //Set totalproduct
                                    // System.out.println(totalproduct);
                                    productArray[product].stockLevel=totalproduct;   // Set new stockLevel
                                    System.out.println("buy.................");
                                    break;
                                case 2:
                                    //Product Selling Process::::::::::::::::::::::::
                                    // Checking if product stockLevel are grater then or equal to 1;
                                    if (productArray[product].stockLevel>=1) 
                                    {
                                        // Get Sell  input
                                        Scanner totals= new Scanner(System.in);
                                        System.out.print("Enter total product to sell: ");
                                        int TS = totals.nextInt();
                                        //Checking if there are as many products as will be purchased;
                                        if (0<=productArray[product].stockLevel-TS) 
                                        {
                                            //After purchase, the product is decreasing
                                            int totalproduct2 = productArray[product].stockLevel-TS;
                                            productArray[product].stockLevel = totalproduct2;
                                            System.out.println("sel.................");
                                        } 
                                        else 
                                        {
                                            System.out.println(TS+" pice "+productArray[product].name+" "+"are currently no available !!");
                                        }
                                    }
                                     else
                                      {
                                        System.out.println("No available"+" "+productArray[product].name+" "+"now !!");
                                      }
                                    break;    
                                case 3:
                                    //Set Product Price:::::::::::::::::::::::::
                                    Scanner newprice= new Scanner(System.in);
                                    System.out.print("Set product new price: ");
                                    double SP = newprice.nextDouble();
                                    //Checking product price are not less then 1
                                    if (0<SP) 
                                    {
                                        productArray[product].price = SP;
                                        System.out.println("set price................");
                                    } 
                                    else 
                                    {
                                        System.out.println("Please enter product price greater then < 1");
                                    }
                                    break;               
                                default:
                                    BSproduct = false;
                                System.out.println("---------------------");
                                    break;
                            }
                        }               
                    }
                    //Press 0 to exit;
                    else if (product==(-1)) {
                        pro = false;
                    }
                    else{
                        System.out.println("Please seleact availabel product");
                        System.out.println("_______________________");
        
                    }
    
                }
                catch (Exception e) 
                {
                    // printing the exception
                    System.out.println("Please enter Int type");

                }
                
        }
	}
}
