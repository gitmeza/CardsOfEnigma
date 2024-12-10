import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class GameManager extends JFrame {

    private JPanel gamePanel;
    private JPanel menuPanel;
    private JPanel grid;
    private JLabel lowerText;
    private JLabel text;
    private JLabel lowerText2;
    private JLabel energyText;
    private JLabel healthText;
    private Graph<Location> locations;
    private Location currentLocation;
    private String labelString;
    private Hashtable<Integer, JButton> cardButtons;
    private Card swordCard;
    private Card fireballCard;
    private Card shieldCard;
    private Card magicShieldCard;
    private Card crossbowCard;
    private Card lightningCard;
    private Card healCard;
    private Card invisibilityCard;
    private Card meteorCard;
    private Card championCard;
    private Location start;
    private Location l1;
    private Location l2;
    private Location l3;
    private Location l4;
    private Location l5;
    private Location l6;
    private Location l7;
    private Location l8;
    private Deck deck;
    private int active;
    private StoryTree story = new StoryTree();
    private Player player;
    private Enemy enemy;
    private CardAbilities abilities;
    private String desc1;
    private String desc2;
    private String desc3;
    private String desc4;
    private String desc5;
    private JLabel enemyHealth;
    private int d1;
    private int d2;
    private int d3;
    private int d4;
    private int d5;
    private int e1;
    private int e2;
    private int e3;
    private int e4;
    private int e5;

    public GameManager() {
        setTitle("Cards of Enigma");
        setBackground(Color.BLACK);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        abilities = new CardAbilities();

        //Create Game Panel with grid bag layout
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        enemy = new Enemy("Enemy");

        //Create text label for game panel
        text = new JLabel("Cards of Enigma");
        text.setFont(new Font("Arial", Font.PLAIN, 24));
        text.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gamePanel.add(text, gbc);

        //Create menu panel for buttons
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        //Lower text
        lowerText = new JLabel();
        lowerText.setFont(new Font("Arial", Font.ITALIC, 16));
        lowerText.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        menuPanel.add(lowerText, gbc);
        //Lower text 2
        lowerText2 = new JLabel();
        lowerText2.setFont(new Font("Arial", Font.ITALIC, 16));
        lowerText2.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.SOUTH;
        menuPanel.add(lowerText2, gbc);
        gbc.gridwidth = 1;

        //Health text
        healthText = new JLabel();
        healthText.setFont(new Font("Arial", Font.PLAIN, 16));
        healthText.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        menuPanel.add(healthText, gbc);

        //Energy text
        energyText = new JLabel();
        energyText.setFont(new Font("Arial", Font.PLAIN, 16));
        energyText.setForeground(Color.BLACK);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        menuPanel.add(energyText, gbc);
        
        //Enemy Health
        enemyHealth = new JLabel();
        enemyHealth.setFont(new Font("Arial", Font.PLAIN, 16));
        enemyHealth.setForeground(Color.BLACK);
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        menuPanel.add(enemyHealth, gbc);
        gbc.gridwidth = 1;

        //Grid of Buttons
        grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3, 10, 10));
        grid.setBackground(Color.BLACK);

        // Add buttons to the panel
        JButton gridButton1 = new JButton("The Cold");
        grid.add(gridButton1);
        JButton gridButton2 = new JButton("The Abyss");
        grid.add(gridButton2);
        JButton gridButton3 = new JButton("Shadow Land");
        grid.add(gridButton3);
        JButton gridButton4 = new JButton("Moonless Sky");
        grid.add(gridButton4);
        JButton gridButton5 = new JButton("The Dark");
        grid.add(gridButton5);
        JButton gridButton6 = new JButton("The Absence");
        grid.add(gridButton6);
        JButton gridButton7 = new JButton("The Shade");
        grid.add(gridButton7);
        JButton gridButton8 = new JButton("Land of Cimmeria");
        grid.add(gridButton8);
        JButton gridButton9 = new JButton("The Catacombs");
        grid.add(gridButton9);

        JButton endButton = new JButton("End Game");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton cardButton = new JButton("Click Me");
        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){
                    changeLowerText(desc1);
                    player.setEnergy(player.getEnergy() - e1);
                    if(enemy.getHealth() > 0){
                        if(enemy.getHealth() - d1 < 0){
                            setEnemyHealthText("0");
                            enemy.setHealth(0);
                        }
                        else{
                            setEnemyHealthText(String.valueOf(enemy.getHealth() - d1));
                            enemy.setHealth(enemy.getHealth() - d1);
                        }
                    }
                }
            }
        });
        JButton cardButton1 = new JButton("Click Me");
        cardButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){
                    changeLowerText(desc2);
                    player.setEnergy(player.getEnergy() - e2);
                    if(enemy.getHealth() > 0){
                        if(enemy.getHealth() - d2 < 0){
                            setEnemyHealthText("0");
                            enemy.setHealth(0);
                        }
                        else{
                            setEnemyHealthText(String.valueOf(enemy.getHealth() - d2));
                            enemy.setHealth(enemy.getHealth() - d2);
                        }
                    }
                }
            }
        });
        JButton cardButton2 = new JButton("Click Me");
        cardButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){  
                    changeLowerText(desc3);
                    player.setEnergy(player.getEnergy() - e3);
                    if(enemy.getHealth() > 0){
                        if(enemy.getHealth() - d3 < 0){
                            setEnemyHealthText("0");
                            enemy.setHealth(0);
                        }
                        else{
                            setEnemyHealthText(String.valueOf(enemy.getHealth() - d3));
                            enemy.setHealth(enemy.getHealth() - d3);
                        }
                    }
                }
            }
        });
        JButton cardButton3 = new JButton("Click Me");
        cardButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){
                    changeLowerText(desc4);
                    player.setEnergy(player.getEnergy() - e4);
                    if(enemy.getHealth() > 0){
                        if(enemy.getHealth() - d4 < 0){
                            setEnemyHealthText("0");
                            enemy.setHealth(0);
                        }
                        else{
                            setEnemyHealthText(String.valueOf(enemy.getHealth() - d4));
                            enemy.setHealth(enemy.getHealth() - d4);
                        }
                    }
                }
            }
        });
        JButton cardButton4 = new JButton("Click Me");
        cardButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){
                    changeLowerText(desc5);
                    player.setEnergy(player.getEnergy() - e5);
                    if(enemy.getHealth() > 0){
                        if(enemy.getHealth() - d5 < 0){
                            setEnemyHealthText("0");
                            enemy.setHealth(0);
                        }
                        else{
                            setEnemyHealthText(String.valueOf(enemy.getHealth() - d5));
                            enemy.setHealth(enemy.getHealth() - d5);
                        }
                    }
                }
            }
        });

        Count cbCount = new Count();
        JButton continueButton = new JButton("Continue");
        
        //First action for continue button
        ActionListener act1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1 && cbCount.getCount() == 0){
                active = 1;
                text.setText("");
                labelString = story.getRoot().getText();

                ActionListener timeAct = new ActionListener() {
                    private int index = 0;
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (index < labelString.length()) {
                            text.setText(text.getText() + labelString.charAt(index));
                            index++;
                        } else {
                            ((Timer) e.getSource()).stop();
                            cbCount.add();
                            active = 0;
                        }
                    }
                };
                Timer timer = new Timer(100, timeAct);
                timer.start();
                }
            }
        };
        continueButton.addActionListener(act1);

        //Second action for continue button
        ActionListener act2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1 && cbCount.getCount() == 1){
                active = 1;
                text.setText("");
                labelString = story.getRoot().left.getText();

                ActionListener timeAct = new ActionListener() {
                    private int index = 0;
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (index < labelString.length()) {
                            text.setText(text.getText() + labelString.charAt(index));
                            index++;
                        } else {
                            ((Timer) e.getSource()).stop();
                            cbCount.add();
                            active = 0;
                        }
                    }
                };
                Timer timer = new Timer(100, timeAct);
                timer.start();
                }
            }
        };
        continueButton.addActionListener(act2);

        //Third action for continue button
        ActionListener act3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1 && cbCount.getCount() == 2){
                active = 1;
                text.setText("");
                labelString = story.getRoot().right.getText();

                ActionListener timeAct = new ActionListener() {
                    private int index = 0;
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (index < labelString.length()) {
                            text.setText(text.getText() + labelString.charAt(index));
                            index++;
                        } else {
                            ((Timer) e.getSource()).stop();
                            cbCount.add();
                            active = 0;
                        }
                    }
                };
                Timer timer = new Timer(100, timeAct);
                timer.start();
                }
            }
        };
        continueButton.addActionListener(act3);

        //Fourth action for continue button
        ActionListener act4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1 && cbCount.getCount() == 3){
                    cbCount.add();
                    text.setText("");
                    gamePanel.add(grid);
                    changeLowerText2("You are in: " + currentLocation.getName());
                    setHealthText("100");
                    setEnergyText("100");
                }
            }
        };
        continueButton.addActionListener(act4);

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active != 1){
                active = 1;
                startGame();
                text.setText("");
                labelString = "Game Started";
                Timer timer = new Timer(100, new ActionListener() {
                    private int index = 0;
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (index < labelString.length()) {
                            text.setText(text.getText() + labelString.charAt(index));
                            index++;
                        } else {
                            ((Timer) e.getSource()).stop();
                            active = 0;
                        }
                    }
                });
                timer.start();
                menuPanel.remove(startButton);
                gbc.gridx = 4;
                gbc.gridy= 1;
                menuPanel.add(endButton, gbc);
                gbc.gridx = 2;
                gbc.gridy= 1;
                menuPanel.add(continueButton, gbc);
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.SOUTH;
                menuPanel.add(cardButton, gbc);
                gbc.gridx = 1;
                menuPanel.add(cardButton1, gbc);
                gbc.gridx = 2;
                menuPanel.add(cardButton2, gbc);
                gbc.gridx = 3;
                menuPanel.add(cardButton3, gbc);
                gbc.gridx = 4;
                menuPanel.add(cardButton4, gbc);
                }
            }
        });

        //Go to location 1
        gridButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l1)){
                    if(active != 1){
                        currentLocation = l1;
                        changeLowerText2("You are in: " + l1.getName());
                    }
                    if(l1.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 2
        gridButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l2)){
                    if(active != 1){
                        currentLocation = l2;
                        changeLowerText2("You are in: " + l2.getName());
                    }
                    if(l2.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 3
        gridButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l3)){
                    if(active != 1){
                        currentLocation = l3;
                        changeLowerText2("You are in: " + l3.getName());
                    }
                    if(l3.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 4
        gridButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l4)){
                    if(active != 1){
                        currentLocation = l4;
                        changeLowerText2("You are in: " + l4.getName());
                    }
                    if(l4.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to start "location 5"
        gridButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, start)){
                    if(active != 1){
                        currentLocation = start;
                        changeLowerText2("You are in: " + start.getName());
                    }
                    if(start.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 6
        gridButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l5)){
                    if(active != 1){
                        currentLocation = l5;
                        changeLowerText2("You are in: " + l5.getName());
                    }
                    if(l5.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 7
        gridButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l6)){
                    if(active != 1){
                        currentLocation = l6;
                        changeLowerText2("You are in: " + l6.getName());
                    }
                    if(l6.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 8
        gridButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l7)){
                    if(active != 1){
                        currentLocation = l7;
                        changeLowerText2("You are in: " + l7.getName());
                    }
                    if(l7.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });
        //Go to location 9
        gridButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(locations.hasEdge(currentLocation, l8)){
                    if(active != 1){
                        currentLocation = l8;
                        changeLowerText2("You are in: " + l8.getName());
                    }
                    if(l8.getEnemies() > 0){
                        enemy = new Enemy("Enemy");
                        setEnemyHealthText(String.valueOf(enemy.getHealth()));
                    }
                    else{
                        setEnemyHealthText("N/A");
                    }
                }
            }
        });

        cardButtons = new Hashtable<Integer, JButton>();
        cardButtons.put(1, cardButton);
        cardButtons.put(2, cardButton1);
        cardButtons.put(3, cardButton2);
        cardButtons.put(4, cardButton3);
        cardButtons.put(5, cardButton4);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        menuPanel.add(startButton, gbc);
        
        //add(lowerPanel, BorderLayout.SOUTH);
        add(menuPanel, BorderLayout.SOUTH);
        add(gamePanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    private void startGame(){
        System.out.println("Game started!");
    }
    public void changeLowerText(String name){
        lowerText.setText("");
        Timer timer = new Timer(100, new ActionListener() {
            
            private int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < name.length()) {
                    lowerText.setText(lowerText.getText() + name.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                    active = 0;
                }
            }
            
        });
        if(active != 1){
            active = 1;
            timer.start();
        }

    }
    public void changeLowerText2(String name){
        lowerText2.setText("");
        Timer timer = new Timer(100, new ActionListener() {
            
            private int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < name.length()) {
                    lowerText2.setText(lowerText2.getText() + name.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                    active = 0;
                }
            }
            
        });
        if(active != 1){
            active = 1;
            timer.start();
        }

    }
    public void setHealthText(String health){
        healthText.setText("Health: ");
        Timer timer = new Timer(100, new ActionListener() {
            private int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < health.length()) {
                    healthText.setText(healthText.getText() + health.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
            
        });
        timer.start();
    }
    public void setEnergyText(String energy){
        energyText.setText("Energy: ");
        Timer timer = new Timer(100, new ActionListener() {
            private int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < energy.length()) {
                    energyText.setText(energyText.getText() + energy.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
            
        });
        timer.start();
    }
    public void setEnemyHealthText(String health){
        enemyHealth.setText("Enemy: ");
        Timer timer = new Timer(100, new ActionListener() {
            private int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < health.length()) {
                    enemyHealth.setText(enemyHealth.getText() + health.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
            
        });
        timer.start();
    }
    public JLabel getLabel(){
        return this.text;
    }
    public JButton getCardButton(int n){
        return cardButtons.get(n);
    }
    public void generateCards(){
        //Create Cards
        swordCard = new Card("Sword", 10, 1);
        fireballCard = new Card("Fireball", 20, 2);
        shieldCard = new Card("Shield", 10, 3);
        magicShieldCard = new Card("Magic Shield", 10, 4);
        crossbowCard = new Card("Crossbow", 10, 5);
        lightningCard = new Card("Lightning", 20, 6);
        healCard = new Card("Heal", 10, 7);
        invisibilityCard = new Card("Invisibility", 10, 8);
        meteorCard = new Card("Meteor", 20, 9);
        championCard = new Card("Champion", 20, 10);

        //Add cards to deck of available cards
        deck = new Deck();
        deck.pushBottom(swordCard);
        deck.pushBottom(fireballCard);
        deck.pushBottom(shieldCard);
        deck.pushBottom(magicShieldCard);
        deck.pushBottom(crossbowCard);
        deck.pushBottom(lightningCard);
        deck.pushBottom(healCard);
        deck.pushBottom(invisibilityCard);
        deck.pushBottom(meteorCard);
        deck.pushBottom(championCard);

        deck.shuffle();
    }
    
    public void generateLocations(){
        locations = new Graph<Location>();
        start = new Location("The Dark", 0);
        l1 = new Location("The Cold", 3);
        l2 = new Location("The Abyss", 2);
        l3 = new Location("Shadow Land", 3);
        l4 = new Location("Moonless Sky", 0);
        l5 = new Location("The Abscence", 0);
        l6 = new Location("The Shade", 2);
        l7 = new Location("Land of Cimmeria", 0);
        l8 = new Location("The Catacombs", 5);

        locations.addVertex(start);
        locations.addEdge(start, l1, true);
        locations.addEdge(start, l2, true);
        locations.addEdge(start, l3, true);
        locations.addEdge(start, l4, true);
        locations.addEdge(start, l5, true);
        locations.addEdge(start, l6, true);
        locations.addEdge(start, l7, true);
        locations.addEdge(start, l8, true);

        currentLocation = start;
    }

    public void generatePlayer(String name){
        player = new Player(name);
        player.setLocation(currentLocation);
    }

    public Card getCard(){
        return deck.drawCard();
    }

    public void setLocation(Location location){
        currentLocation = location;
    }

    public static void main(String[] args){
        GameManager game = new GameManager();
        game.generateCards();
        Card card1 = game.getCard();
        Card card2 = game.getCard();
        Card card3 = game.getCard();
        Card card4 = game.getCard();
        Card card5 = game.getCard();
        game.desc1 = game.abilities.getDesc(card1.getEffectID());
        game.desc2 = game.abilities.getDesc(card2.getEffectID());
        game.desc3 = game.abilities.getDesc(card3.getEffectID());
        game.desc4 = game.abilities.getDesc(card4.getEffectID());
        game.desc5 = game.abilities.getDesc(card5.getEffectID());
        game.d1 = game.abilities.getDamage(card1.getEffectID());
        game.d2 = game.abilities.getDamage(card2.getEffectID());
        game.d3 = game.abilities.getDamage(card3.getEffectID());
        game.d4 = game.abilities.getDamage(card4.getEffectID());
        game.d5 = game.abilities.getDamage(card5.getEffectID());
        game.e1 = game.abilities.getEnergy(card1.getEffectID());
        game.e2 = game.abilities.getEnergy(card2.getEffectID());
        game.e3 = game.abilities.getEnergy(card3.getEffectID());
        game.e4 = game.abilities.getEnergy(card4.getEffectID());
        game.e5 = game.abilities.getEnergy(card5.getEffectID());

        game.getCardButton(1).setText(card1.getName());
        game.getCardButton(2).setText(card2.getName());
        game.getCardButton(3).setText(card3.getName());
        game.getCardButton(4).setText(card4.getName());
        game.getCardButton(5).setText(card5.getName());
        game.generateLocations();
        game.generatePlayer("Hero");


    }
}