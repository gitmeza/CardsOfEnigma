import java.util.LinkedList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class GameClasses {
    public static void main(String[] args){
        
    }
}

class Card{
    private String name;
    private int energy;
    private int effectID;

    public Card(String name, int energy, int effectID){
        this.name = name;
        this.energy = energy;
        this.effectID = effectID;
    }
    public String getName(){
        return this.name;
    }
    public int getEnergy(){
        return this.energy;
    }
    public int getEffectID(){
        return this.effectID;
    }
}
class Deck{
    private LinkedList<Card> list;

    public Deck(){
        list = new LinkedList<Card>();
    }

    public Card popTop(){
        return list.removeLast();
    }

    public void pushTop(Card n){
        list.add(n);
    }

    public Card popBottom(){
        return list.removeFirst();
    }

    public void pushBottom(Card n){
        list.addFirst(n);
    }

    public Card drawCard(){
        return list.removeFirst();
    }
    
    public void shuffle(){
        Collections.shuffle(list);
    }
}

class Player{
    private String name;
    private int health;
    private int energy;
    private Deck deck;
    private Location location;

    public Player(String name){
        this.name = name;
        this.health = 100;
        this.energy = 100;
        this.location = null;
    }
    
    public void setDeck(Deck deck){
        this.deck = deck;
    }

    public Deck getDeck(){
        return this.deck;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public void setLocation(Location location){
        this.location = location;
    }
}
class Enemy{
    private String name;
    private int health;

    public Enemy(String name){
        this.name = name;
        this.health = 100;
    }
    public String getName(){
        return this.name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
}

class StoryNode{
    String text;
    StoryNode left;
    StoryNode right;
    
    public StoryNode(String text){
        this.text = text;
        left = null;
        right = null;
    }

    public StoryNode setLeft(String text){
        this.left = new StoryNode(text);
        return this.left;
    }

    public StoryNode setRight(String text){
        this.right = new StoryNode(text);
        return this.right;
    }

    public String getText(){
        return this.text;
    }
}
class StoryTree{
    StoryNode root;

    public StoryTree(){
        root = new StoryNode("Welcome to Cards of Enigma");
        StoryNode left1 = root.setLeft("You may be wondering why it is dark in here...");
        StoryNode right1 = root.setRight("The Sun was stolen from us. Please find it...");
        
    }
    public StoryNode getRoot(){
        return this.root;
    }
}
class CardAbilities{
    private Hashtable<Integer, String> desc;
    private Hashtable<Integer, Integer> damage;
    private Hashtable<Integer, Integer> energy;

    public CardAbilities(){
        desc = new Hashtable<Integer, String>();
        desc.put(1, "A sword with a sharp edge.");
        desc.put(2, "A giant ball of fire.");
        desc.put(3, "A large metal shield.");
        desc.put(4, "A shield made of pure magic.");
        desc.put(5, "A powerful crossbow");
        desc.put(6, "A lightning strike summoned from beyond the sky.");
        desc.put(7, "Powerful healing magic.");
        desc.put(8, "The power of the unseen.");
        desc.put(9, "Summon a giant metor from beyond the sky.");
        desc.put(10,"The pinnacle of mankind.");

        damage = new Hashtable<Integer, Integer>();
        damage.put(1, 20);
        damage.put(2, 40);
        damage.put(3, 20);
        damage.put(4, 40);
        damage.put(5, 20);
        damage.put(6, 50);
        damage.put(7, 50);
        damage.put(8, 0);
        damage.put(9, 80);
        damage.put(10, 100);

        energy = new Hashtable<Integer, Integer>();
        energy.put(1, 20);
        energy.put(2, 40);
        energy.put(3, 20);
        energy.put(4, 40);
        energy.put(5, 20);
        energy.put(6, 40);
        energy.put(7, 20);
        energy.put(8, 20);
        energy.put(9, 60);
        energy.put(10, 100);
    }

    public int getDamage(int i){
        return damage.get(i);
    }

    public int getEnergy(int i){
        return energy.get(i);
    }
    
    public String getDesc(int key){
        return this.desc.get(key);
    }
}
class Location{
    private String name;
    private int enemies;
    private ArrayList<Enemy> enemy;

    public Location(String name, int enemies){
        this.name = name;
        this.enemies = enemies;
        enemy = new ArrayList<Enemy>();
        addEnemy(enemies);
    }
    public String getName(){
        return this.name;
    }
    public void addEnemy(int n){
        for(int i = 0; i < n; i++){
            enemy.add(new Enemy("Enemy " + i));
        }        
    }
    public Enemy getEnemy(int n){
        return enemy.get(n);
    }
    public int getEnemies(){
        return this.enemies;
    }
}
class Graph<T> {

    private Map<T, List<T> > map = new HashMap<>();

    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    public void addEdge(T source, T destination, boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    public boolean hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            return true;
        }
        else {
            return false;
        }
    }
}
class Count{
    int num;

    public Count(){
        num = 0;
    }
    public void add(){
        num++;
    }
    public int getCount(){
        return num;
    }
    public void setCount(int i){
        this.num = i;
    }
}