import java.util.Random;

import javax.lang.model.util.ElementScanner6;

class Sterckets 
{
    private String name;
    private int attackScore;
    private int defenseScore;
    private int currentHp;
    private int maxHp;
    private int rank;
    private String hitElement;
    private Random generator;

    public Sterckets(String monnom, Random gen) 
    {
        this.name = monnom;
        this.generator = gen;
        this.generateCaracteristic();
    }

    public void state() 
    {
      System.out.format("Salut ! Moi c'est %s, mon élement est le %s, je suis au rang %d et j'ai %d/%d Points de vie.  Aller je me casse, tchao babe ! "
         , this.name, this.hitElement, this.rank, this.currentHp, this.maxHp); 
         System.out.println();
    } 

    private void generateCaracteristic(){
        this.rank = this.generator.nextInt(3);
        int totalPoint = this.generator.nextInt(91)+10 *( 1 + (this.rank/10)); 
        this.shareTotalPoint(this.generator, totalPoint);
        this.currentHp = this.maxHp;
        this.generateElement();
    }

    private  void shareTotalPoint(Random generator, int totalPoint){
        for(int i=0;i<totalPoint; i++){
            int monrand = generator.nextInt(3);
            if(monrand == 0){
                this.attackScore = this.attackScore + 1;
            }else if (monrand == 1){
                this.defenseScore +=1;
            }else{
                this.maxHp++;
            }
        }
    }

    public void rest()
    {
        if (this.currentHp < this.maxHp){
            this.currentHp = this.currentHp + 1;
        } 
    }
    public void generateElement()
    {
        int monRandom = this.generator.nextInt(4);
        switch(monRandom) 
        {
            case 0:
            this.hitElement = "Terre";
            break;
            
            case 1:
            this.hitElement = "Feu";
            break;
            
            case 2:
            this.hitElement = "Eau";
            break;
            
            case 3:
            this.hitElement = "Air";
            break;
            
            default:
        }
    }

    public void attack(Sterckets ennemy) 
    {
        int damage = this.attackScore - ennemy.getDefenseScore();
        if(damage< 0){
            damage = 0;
        }
        if (this.hitElement.equals("Feu") && ennemy.getHitElement().equals("Air")) {
            damage = damage * 2;
        }
        else if (this.hitElement.equals("Air") && ennemy.getHitElement().equals("Terre")) {
            damage = damage * 2;
        }
        else if (this.hitElement.equals("Terre") && ennemy.getHitElement().equals("Eau")) {
            damage = damage * 2;
        }
        else if (this.hitElement.equals("Eau") && ennemy.getHitElement().equals("Feu")) {
            damage = damage * 2;
        }

        if (ennemy.getCurrentHp() - damage < 0)
        {   
            ennemy.setCurrentHp(0);
        }else{
            ennemy.setCurrentHp(ennemy.getCurrentHp() - damage);
        }
        System.out.println(this.name + " attack "+ennemy.getName()+" with and it him for "+ damage+" dammages !");
        System.out.println("His hp are now "+ ennemy.getCurrentHp());
        if (ennemy.getCurrentHp() == 0) {
            ennemy.setMaxHp(ennemy.getMaxHp() + 1);
        }

        this.attackScore += 1;
        ennemy.setDefenseScore(ennemy.getDefenseScore() + 1);
    }

    public void display() 
    {
        System.out.format("Salut ! Moi c'est %s, mon rang est %d. J'ai %d Points de vie."+
         "Mon score d'attaque est de %d et mon score de défense est de %d.mon element est %s Aller je me casse, tchao babe ! "
         , this.name,this.rank,this.maxHp,this.attackScore,this.defenseScore, this.hitElement);
         System.out.println();
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the attackScore
     */
    public int getAttackScore() {
        return attackScore;
    }

    /**
     * @param attackScore the attackScore to set
     */
    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    /**
     * @return int return the defenseScore
     */
    public int getDefenseScore() {
        return defenseScore;
    }

    /**
     * @param defenseScore the defenseScore to set
     */
    public void setDefenseScore(int defenseScore) {
        this.defenseScore = defenseScore;
    }

    /**
     * @return int return the currentHp
     */
    public int getCurrentHp() {
        return currentHp;
    }

    /**
     * @param currentHp the currentHp to set
     */
    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    /**
     * @return int return the maxHp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * @param maxHp the maxHp to set
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * @return String return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return String return the hitElement
     */
    public String getHitElement() {
        return hitElement;
    }

    /**
     * @param hitElement the hitElement to set
     */
    public void setHitElement(String hitElement) {
        this.hitElement = hitElement;
    }

}