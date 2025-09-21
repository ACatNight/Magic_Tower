package Magic;

import java.util.Random;
import java.util.Scanner;

public class Game_Core {
    public static void main(String[] args) {
        System.out.println("=======================================\n" +
                "        欢迎来到魔塔世界\n" +
                "=======================================\n" +
                "  一个充满挑战与冒险的地方，\n" +
                "  准备好成为英雄，探索这个神秘的塔楼了吗？\n" +
                "=======================================");
        Scanner sc = new Scanner(System.in);
        int number;
        boolean running = true;
        boolean start = false;  // 标志是否已经创建角色
        Player_Core player = new Player_Core();
        Monster_Core monster = new Monster_Core();
        Random r = new Random();  // Random 只需初始化一次

        while (running) {
            System.out.println("请选择以下选项开始冒险：\n" +
                    "1. 开始游戏\n" +
                    "2. 创建角色\n" +
                    "3. 查看游戏帮助\n" +
                    "4. 退出游戏\n" +
                    "=======================================");

            number = sc.nextInt();  // 获取用户输入

            switch (number) {
                case 1:
                    if (start) {
                        System.out.println("=======================================\n" +
                                "           魔塔冒险\n" +
                                "=======================================\n" +
                                "你站在魔塔的入口前，塔楼高耸入云，仿佛有无尽的挑战等待着你。你决定：\n" +
                                "1. 进入魔塔\n" +
                                "2. 查看背包\n" +
                                "3. 查看任务\n" +
                                "=======================================\n" +
                                "请输入数字并按回车选择：");

                        int number1 = sc.nextInt();
                        switch (number1) {
                            case 1:
                                // 进入魔塔逻辑
                                System.err.println("  **你已经进入魔塔的第一层！**\n" +
                                        "  =======================================\n" +
                                        "  **目标**：探索魔塔，寻找深处的秘密。\n" +
                                        "  **小贴士**：小心塔中的怪物，它们可能会突然出现。\n" +
                                        "  =======================================");
                                System.out.println("请选择操作：\n1. 继续前进");
                                int number2 = sc.nextInt();
                                if (number2 == 1) {
                                    monster = new Monster_Core("史莱姆", 100, 5, r.nextInt(10) + 1, "粘液球");
                                    System.out.println("=======================================\n" +
                                            "        遇到史莱姆！\n" +
                                            "=======================================");
                                    System.err.println("你看到一个闪着绿色光芒的黏液状物体在不远处缓缓爬行...");
                                    fightMonster(sc, r, player, monster);  // 继续战斗
                                } else {
                                    System.err.println("无效输入");
                                }
                                break;

                            case 2:
                                // 显示背包
                                String[] bag = new String[10];
                                boolean empty = true;
                                for (String item : bag) {
                                    if (item != null) {
                                        System.err.println(item);
                                        empty = false;
                                    }
                                }
                                if (empty) {
                                    System.err.println("当前背包空空如也");
                                }
                                break;

                            case 3:
                                System.out.println("当前没有任务");
                                break;

                            default:
                                System.out.println("无效输入");
                        }
                    } else {
                        System.out.println("请先创建角色");
                    }
                    break;

                case 2:
                    System.out.println("=======================================\n" +
                            "          创建你的角色\n" +
                            "=======================================\n" +
                            "  选择你想扮演的角色类型，勇士、法师、游侠。\n" +
                            "  请输入职业编号：\n" +
                            "  1. 战士\n" +
                            "  2. 法师\n" +
                            "  3. 游侠\n" +
                            "=======================================");
                    int Value = sc.nextInt();
                    sc.nextLine();  // 解决名字读取问题

                    switch (Value) {
                        case 1:

                            player = new Player_Core(sc.next(), "战士", 120, 120, 1, 0, 10, 0, 8);
                            System.err.println("请输入你的ID");
                            break;
                        case 2:
                            player = new Player_Core(sc.next(), "法师", 60, 60, 1, 0, 20, 0, 10);
                            System.err.println("请输入你的ID");

                            break;
                        case 3:
                            player = new Player_Core(sc.next(), "游侠", 100, 100, 1, 0, 15, 0, 5);
                            System.err.println("请输入你的ID");

                            break;
                        default:
                            System.out.println("无效输入，请重新选择职业！");
                            continue;
                    }

                    System.out.println("=======================================");
                    System.out.println("        角色创建完成！\n" +
                            "=======================================");
                    System.out.println("  角色名称：" + player.getPlayerName());
                    System.out.println("  职业：" + player.getPlayerClass());
                    System.out.println("  攻击力：" + player.getAttack());
                    System.out.println("  魔法值：" + player.getMana());
                    System.out.println("  生命值：" + player.getHealth());
                    start = true;  // 设置角色已创建
                    break;

                case 3:
                    System.out.println("游戏帮助：\n1. 开始游戏：开始你的冒险之旅。\n2. 创建角色：选择你的职业并开始游戏。\n3. 查看帮助：查看游戏指南。\n4. 退出游戏：退出游戏。");
                    break;

                case 4:
                    running = false;  // 退出游戏
                    System.out.println("谢谢游玩，欢迎下次再来！");
                    break;

                default:
                    System.out.println("无效输入，请重新选择！");
            }
        }
    }

    // 战斗逻辑
    private static void fightMonster(Scanner sc, Random r, Player_Core player, Monster_Core monster) {
        boolean Game_Online = true;
        while (Game_Online) {
            System.out.println("请选择技能：\n1. 普通攻击\n2. 魔法攻击");
            String skill = sc.next();
            int ai_Skill = r.nextInt(2) + 1;

            // 怪物攻击玩家
            if (ai_Skill == 1) {
                monster.performAttack(player);
                if (!monster.isVlan(player)) {  // 玩家是否死亡
                    System.err.println(monster.getMonster_Name() + " 战胜了 " + player.getPlayerName());
                    Game_Online = false;
                    break;  // 退出战斗
                }
            } else {
                monster.performAttacks(player);
                if (!monster.isVlan(player)) {  // 玩家是否死亡
                    System.err.println(monster.getMonster_Name() + " 战胜了 " + player.getPlayerName());
                    Game_Online = false;
                    break;  // 退出战斗
                }
            }

            // 玩家选择技能2
            if (skill.equals("1")) {
                player.Normal_Attack(monster);  // 玩家普通攻击
                if (!player.isVlan(monster)) {  // 如果怪物死亡
                    System.err.println(player.getPlayerName() + " 战胜了 " + monster.getMonster_Name());
                    System.err.println("获得了 " + monster.getMonster_exp()+ "exp");
                    Game_Online = false;
                    break;  // 退出战斗
                }
            } else if (skill.equals("2")) {
                if (player.getMana() > 5) {
                    player.easy_Attack(monster);  // 玩家魔法攻击
                    System.err.println("释放成功");
                    if (!player.isVlan(monster)) {  // 如果怪物死亡
                        System.err.println(player.getPlayerName() + " 战胜了 " + monster.getMonster_Name());
                        System.err.println("获得了 " + monster.getMonster_exp() + "exp") ;
                        Game_Online = false;
                        break;  // 退出战斗
                    }
                } else {
                    System.err.println("蓝量不足");
                }
            } else {
                System.err.println("请重新输入");
            }
        }
    }

}
