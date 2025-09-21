package Magic;

import java.util.Random;

public class Monster_Core {
    private String monster_Name;
    private int monster_Health;
    private int monster_Attack;
    private int monster_exp;
    private String loot;
    private Random r;


    public Monster_Core(){
        this.r = new Random();
    }
    public Monster_Core(String monster_Name,int monster_Health,int monster_Attack,int monster_exp,String loot){
        this();
        this.monster_Name = monster_Name;
        this.monster_Health = monster_Health;
        this.monster_Attack = monster_Attack;
        this.monster_exp = monster_exp;
        this.loot = loot;
    }
    public String getMonster_Name(){
        return monster_Name;
    }
    public void setMonster_Name(String monster_Name){
        this.monster_Name = monster_Name;
    }

    public int getMonster_Health() {
        return monster_Health;
    }

    public void setMonster_Health(int monster_Health) {
        this.monster_Health = monster_Health;
    }

    public int getMonster_Attack() {
        return monster_Attack;
    }

    public void setMonster_Attack(int monster_Attack) {
        this.monster_Attack = monster_Attack;
    }


    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public int getMonster_exp() {
        return monster_exp;
    }

    public void setMonster_exp(int monster_exp) {
        this.monster_exp = monster_exp;
    }

    public void performAttack(Player_Core player){
        int damage = r.nextInt(getMonster_Attack());
        damage = Math.max(damage,0); //防止负数
        player.setHealth(player.getHealth() - damage);
        System.out.println(monster_Name + " 对 " + player.getPlayerName() + " 进行了攻击，造成了 " + damage + " 点伤害！");
        System.err.println(player.getPlayerName() + "还剩下:" + player.getHealth() + "血量");
    }
    public void performAttacks(Player_Core player){
        int damage = r.nextInt(getMonster_Attack()+20);
        damage = Math.max(damage,0); //防止负数
        player.setHealth(player.getHealth() - damage);
        System.out.println(monster_Name + " 对 " + player.getPlayerName() + " 进行了攻击，造成了 " + damage + " 点伤害！");
        System.err.println(player.getPlayerName() + "还剩下:" + player.getHealth() + "血量");
    }
    public boolean isVlan(Player_Core player){
        return player.getHealth() > 0;
    }
    }


