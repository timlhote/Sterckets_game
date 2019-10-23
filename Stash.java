import java.util.Random;

class Stash {
    private static int size = 10;
    private Sterckets[] stercketsList = new Sterckets[size];
    private int lastIndex = 0;
    Random generator;
    public Stash(Random gen) {    
        this.generator = gen;
    }

    public void remove(int id){
        this.stercketsList[id] = null;
        for(int index= id+ 1;i<this.lastIndex;i++){
            this.stercketsList[index-1] = this.stercketsList[index];
        }
        this.lastIndex -= 1;
    }
       public void remove(Sterckets ster){
           int idx =lastIndex;
           for(int i=0; i < this.lastIndex;i++){
               if(this.stercketsList[i].equals(ster)){
                    idx = i;   
               }
           }
           if (idx== this.lastIndex){
               return;
           }
        this.stercketsList[idx] = null;
        for(int index= idx+ 1;index<this.lastIndex;index++){
            this.stercketsList[index-1] = this.stercketsList[index];
        }
        this.lastIndex -= 1;
    }
    public void rest(){
        for(Sterckets s: this.stercketsList){
            if(s!=null)
                s.rest();
        }
    }
    public void changeSterckets(int id){
        if (this.lastIndex<= id){
            System.out.println("This id doesn't exist.");
            return;
        }
        Sterckets tmp = this.stercketsList[0];
        this.stercketsList[0] = this.stercketsList[id];
        this.stercketsList[id] = tmp;
    }

    public Sterckets[] getList(){
        return this.stercketsList;
    }
    public void display(){
        for(int i=0; i< this.lastIndex; i++){
            System.out.println(i +" : "+this.stercketsList[i].getName());
        }
    }
    public void add(Sterckets newPLayboy){
        this.stercketsList[lastIndex]= newPLayboy;
        this.lastIndex += 1;
    }

    public Sterckets getStercketsById(int id)
    {
        if (id > this.lastIndex){
            return null;
        }
        return this.stercketsList[id];
    }

    public Sterckets getRandomSterckets()
    {
        int indexId =  generator.nextInt(this.lastIndex);
        return this.stercketsList[indexId];
    }
}