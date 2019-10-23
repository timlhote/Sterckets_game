import java.util.Random;
import java.util.Scanner;

class Controller 
{   
    private int size= 50;
    private boolean isRunning= true;
    private Random generator;
    private Scanner input;
    private Stash woods;
    public Controller(Random gen){
        this.input = new Scanner(System.in);
        this.generator = gen;
        this.woods = new Stash(this.generator);
        this.start();
    }

    public void start(){
        Sterckets first = askUserForSterckets();
        Stash group = new Stash(this.generator);
        group.add(first);
        do{
            this.askPlayerAction(group);
        }while(isRunning);
    }
    public void askPlayerAction(Stash stash){

        System.out.println("Selectionner une action par son id:");
        System.out.println("1: Add Sterckets to woods");
        System.out.println("2: Display your party");
        System.out.println("3: Change your champion");
        System.out.println("4: See your champion stats");
        System.out.println("5: Start a fight");
        System.out.println("6: Quit the game");
        String action = "";
        do{
            action = input.nextLine();
        }
        while(action.equals(""));

        this.woods.rest();
        stash.rest();
        switch(action){
            case "1":
                this.woods.add(askUserForSterckets());
            break;
            case "2":
                stash.display();
            break;
            case "3":
                stash.display();
                stash.changeSterckets(getSterckets());
            break;
            case "4":
                stash.getStercketsById(0).display();
            break;
            case "5":
                this.fight(stash);
            break;
            case "6":
                this.quit();
            break;
            default:
            System.out.println("Entrée non valide");
        }
        
    }

    public void fight(Stash group){
        if(this.woods.listLength()<1){
            System.out.println("Can't find Sterckets");
            return;
        }
        Sterckets random = this.woods.getRandomSterckets();
        Sterckets champ= group.getStercketsById(0);
        for(int i=0; i< 3 && random.getCurrentHp()>0 && champ.getCurrentHp()>0; i++){
            champ.attack(random);
            random.attack(champ);
        }
        if(random.getCurrentHp()== 0){
            group.add(random);
            this.woods.remove(random);
        }
    }
    public void quit(){
        this.isRunning = false;
    }
    public int getSterckets(){
        String tmp = input.nextLine();
        return Integer.parseInt(tmp);
    }
    public Sterckets askUserForSterckets(){
        System.out.println("Enter a name for a Stercket");
        String name= "";
        do{
            name = input.nextLine();
        }
        while(name.equals(""));
        return new Sterckets(name, this.generator);
    }

    public static void main(String[] args)
    {
        Random generator = new Random();
        Controller ct = new Controller(generator);
    }

}