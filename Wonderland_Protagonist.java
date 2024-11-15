import java.util.ArrayList;

/**
 * A class creating a protagonist of an Alice in Wonderland style adventure. 
 */
public class Wonderland_Protagonist implements Contract{
    private int height;
    private int start_height;
    private String name;
    private boolean can_fly;
    private boolean can_grow;
    private boolean can_shrink;
    private int speed;
    private ArrayList<String> inventory;
    
    /**
     * A constructor creating a wonderland protagonist
     * @param name the name of the protagonist
     * @param start_height the starting height of the protagonist
     */
    public Wonderland_Protagonist(String name, int start_height){
        this.name = name;
        this.start_height = start_height;
        this.height = start_height; 
        this.can_fly = false; 
        this.can_grow = false;
        this.can_shrink = false;
        this.speed = 4;
        inventory = new ArrayList<String>();
        System.out.println(name + " was beginning to get very tired of sitting by her sister on the bank.");
    }

    /**
     * A method printing out the current height and abilities of the protagonist. 
     */
    public void printStats(){
        System.out.println(this.name + " is " + this.height + " feet tall. ");
        System.out.println("Flight: " + this.can_fly);
        System.out.println("Grow: " + this.can_grow);
        System.out.println("Shrink: " + this.can_shrink);
    }

    /**
     * a method making the protagonist walk in a certain direction at their speed. 
     * @param direction the direction the protagonist is walking
     * @return a boolean indicating that the protagonist is currently walking
     */
    public boolean walk(String direction){
        System.out.println(this.name + " is now walking " + direction + " at " + this.speed + " mph.");
        return true;
    }

    /**
     * a method making the protagonist stop walking if they are currently walking.
     */
    public void rest(){
        if(this.walk("east")){
            System.out.println(this.name + " has stopped.");
        }
        else{
            throw new RuntimeException(this.name + " is not currently walking");
        }
       
    }

    /**
     * A method setting the scene for the protagonist
     */
    public void fall(){
        System.out.println(this.name + " has fallen down a rabbit hole! In front of her are three bottles labeled 'EAT ME' 'DRINK ME' and 'SMELL ME'");
    }

    /**
     * a method printing the protagonist's inventory
     */
    public void printInventory(){
        System.out.println(this.inventory);
    }

    /**
     * a method adding a specified item to the protagonist's inventory
     * @param item the item to be grabbed
     */
    public void grab(String item){
        if(inventory.contains(item)){
            throw new RuntimeException("You have already taken this potion!");  
        }
        else{
            if(item == "EAT ME"){
                inventory.add(item);
                System.out.println(this.name + " takes the potion labeled EAT ME");
            }
            else if(item == "DRINK ME"){
                inventory.add(item);
                System.out.println(this.name + " takes the potion labeled DRINK ME");
            }
            else if(item == "SMELL ME"){
                inventory.add(item);
                System.out.println(this.name + " takes the potion labeled SMELL ME");
            }
            else{
                throw new RuntimeException("Can't find an object with this name, try 'EAT ME', 'DRINK ME', or 'SMELL ME'");
            }
            
        }    
    }

    /**
     * a method removing an item from the protagonist's inventory
     * @param item the item to be removed
     * @return the item that was removed
     */
    public String drop(String item){
        if(inventory.contains(item)){
            inventory.remove(item);
            System.out.println(this.name + " dropped the potion labeled " + item); 
            return item; 
        }
        else{
            throw new RuntimeException("This item isn't in your inventory.");
        }
    }

    /**
     * a method allowing the protagonist to examine an item closer
     * @param item the item to be examined
     */
    public void examine(String item){
        if(inventory.contains(item)){
            if(item == "EAT ME"){
                System.out.println("This potion has a color quite similar to black currants.");
            }
            if(item == "DRINK ME"){
                System.out.println("This potion smells like a mixed flavour of cherry-tart, custard, pine-apple, roast turkey, toffee, and hot buttered toast.");
            }
            if(item == "SMELL ME"){
                System.out.println("This potion seems to be fizzing with carbonated bubbles.");
            }
        }
        else{
            throw new RuntimeException("You can't examine an object that's not in your inventory.");
        }  
    }

    /**
     * a method allowing the protagonist to eat/drink/smell a specific item 
     * @param item the item for the protagonist to use
     */
    public void use(String item){
        if(inventory.contains(item)){
            if(item == "EAT ME"){
                inventory.remove(item);
                this.can_grow = true;
                System.out.println(this.name + " can now grow taller!");
            }
            if(item == "DRINK ME"){
                inventory.remove(item); 
                this.can_shrink = true;
                System.out.println(this.name + " can now shrink!");
            }
            if(item == "SMELL ME"){
                inventory.remove(item); 
                this.can_fly = true;
                System.out.println(this.name + " can now fly!");
            }
        }
        else{
            throw new RuntimeException("You can't examine an object that's not in your inventory.");
        } 
    }

    /**
     * a method allowing the the protagonist to grow, given they have used the EAT ME item
     * @return the height of the protagonist
     */
    public Number grow(){
        if(this.can_grow){
            this.height += 1;
            this.speed += 1;
            System.out.println("'Curiouser and curiouser!' cried " + this.name + ", 'I'm opening out like the largest telescope that ever was!'");
            System.out.println(this.name + " is now " + this.height + " feet tall!"); 
            return this.height;
        }
        else{
            throw new RuntimeException("You don't have the ability to grow");
        }
    }

    /**
     * a method allowing the protagonist to shrink, given they have used the DRINK ME item
     * @return the protagonist's  new height
     */
    public Number shrink(){
        if(this.can_shrink){
            this.height -= 1;
            this.speed -= 1;
            System.out.println("'What a curious feeling!' said " + this.name + " 'I must be shutting up like a telescope.'");
            System.out.println(this.name + " is now " + this.height + " feet tall!"); 
            return this.height;
        }
        else{
            throw new RuntimeException("You don't have the ability to shrink");
        }
    }

    /**
     * A method allowing the protagonist to fly given they have used the SMELL ME item
     * @param height the height the protagonist is flying at
     * @param speed the speed the protagonist is flying at
     * @return a boolean returning whether the protagonist is flying or not
     */
    public boolean fly(int height, int speed){
        if(this.can_fly){
            System.out.println(this.name + " is now flying " + height + " feet in the air at " + speed + " mph!" );
            return true;
        }
        else{
            System.out.println(this.name + " doesn't have the ability to fly!");
            return false;
        }
    }

    /**
     * A method undoing everything supernatural
     */
    public void undo(){
        System.out.println("`Wake up, " + this.name + " dear!' said her sister; `Why, what a long sleep you've had!' ");
        this.height = start_height; 
        this.speed = 4;
        this.can_fly = false; 
        this.can_grow = false;
        this.can_shrink = false;
    }

    public static void main(String[] args) {
        Wonderland_Protagonist Alice = new Wonderland_Protagonist("Alice", 5);
        Alice.fall();
        Alice.printStats();
        Alice.walk("East");
        Alice.grab("EAT ME");
        Alice.printInventory();
        Alice.grab("DRINK ME");
        Alice.printInventory();
        Alice.drop("EAT ME");
        Alice.printInventory();
        Alice.examine("DRINK ME");
        Alice.grab("EAT ME"); 
        Alice.use("EAT ME");
        Alice.grow();
        Alice.walk("east");
        Alice.use("DRINK ME");
        Alice.shrink();
        Alice.shrink();
        Alice.printStats();
        Alice.grab("SMELL ME");
        Alice.examine("SMELL ME");
        Alice.use("SMELL ME");
        Alice.fly(14, 20);
        Alice.undo();
        Alice.fly(3,2);
        
        
    }
}