package Magic;

import java.util.Random;

public class Player_Core {
    private String playerName; //名字
    private String playerClass; //职业
    private int health;  //血量
    private int maxHealth; //最大血量
    private int level; //等级
    private int exp; //经验
    private int mana; //魔法
    private int skillPoints; //技能点
    private int Attack;
    private Random r;

    public Player_Core(){
        this.r = new Random();
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (this.level < level) {  // 防止反复增加
            this.level = level;
            if (level == 1) {
                System.err.println("恭喜你突破了自我，成功升到1级！\n" +
                        "你的力量与智慧得到了显著提升：\n" +
                        "攻击力 +5，生命值 +20，魔法力 +3！\n" +
                        "未来的挑战等着你，勇者，继续前行吧！");
                this.health += 20;
                this.mana += 3;
                this.Attack += 5;
            } else if (level == 2) {
                System.err.println("恭喜你突破了自我，成功升到2级！\n" +
                        "你的力量与智慧得到了显著提升：\n" +
                        "攻击力 +3，生命值 +10，魔法力 +2！\n" +
                        "未来的挑战等着你，勇者，继续前行吧！");
                this.health += 10;
                this.mana += 2;
                this.Attack += 3;
            }
        }
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getAttack(){
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }
    public Player_Core(String playerName, String playerClass, int health, int maxHealth, int level, int exp, int mana, int skillPoints,int Attack) {
        this();  // 调用默认构造函数初始化 Random 对象等

        // 设置玩家名称和职业
        this.playerClass = playerClass;
        this.playerName = playerName;
        this.exp = exp;
        this.level = level;
        this.maxHealth = maxHealth;  // 初始最大生命值
        this.health = health;        // 初始生命值
        this.mana = mana;            // 初始魔法值
        this.skillPoints = skillPoints;
        this.Attack = Attack;
    }

    public void Normal_Attack(Monster_Core obj) {
        int Normal_Damage = r.nextInt(getAttack()) + 5;  // 计算普通攻击伤害
        int monsterHealth = obj.getMonster_Health();  // 获取怪物当前生命值
        monsterHealth -= Normal_Damage;  // 减去怪物的当前生命值
        // 确保怪物生命值不为负
        obj.setMonster_Health(Math.max(monsterHealth, 0));
        // 输出攻击结果
        System.out.println(playerName + " 对 " + obj.getMonster_Health() + " 进行了普通攻击，造成了 " + Normal_Damage + " 点伤害！");
        System.err.println(obj.getMonster_Name() + "还剩下:" + obj.getMonster_Health() + "血量");
    }

    public void easy_Attack(Monster_Core obj) {
        int Normal_Damage = r.nextInt(getAttack()) + 20;  // 计算普通攻击伤害
        int monsterHealth = obj.getMonster_Health();  // 获取怪物当前生命值
        monsterHealth -= Normal_Damage;  // 减去怪物的当前生命值
        // 确保怪物生命值不为负
        obj.setMonster_Health(Math.max(monsterHealth, 0));
        // 输出攻击结果
        System.out.println(playerName + " 对 " + obj.getMonster_Health() + " 进行了魔法攻击，造成了 " + Normal_Damage + " 点伤害！");
        System.err.println( obj.getMonster_Name() +"还剩下:" + obj.getMonster_Health() + "血量");
    }

    public boolean isVlan(Monster_Core monster){
        return monster.getMonster_Health() > 0;
    }
}
