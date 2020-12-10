import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCode {

    static class Hero {
        String name;
        int hp;
        int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        public int getHp() {
            return this.hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getMp() {
            return this.mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countHeroes = Integer.parseInt(scanner.nextLine());
        Map<String , Hero> heroData = new HashMap<>();

        for (int i = 0; i < countHeroes; i++) {
            String[] heroInformation = scanner.nextLine().split("\\s+");
            String heroName = heroInformation[0];
            int hp = Integer.parseInt(heroInformation[1]);
            int mp = Integer.parseInt(heroInformation[2]);
            if (0 < hp && hp <= 100 || 0 < mp && mp <= 200){
                Hero hero = new Hero(heroName , hp , mp);
                heroData.put(heroName , hero);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String nameOfHero = tokens[1];

            switch (command){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroData.get(nameOfHero).getMp() >= mpNeeded){
                        int remainingMP = heroData.get(nameOfHero).getMp() - mpNeeded;
                        heroData.get(nameOfHero).setMp(remainingMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                nameOfHero , spellName , remainingMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", nameOfHero , spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attackerName = tokens[3];
                    if (heroData.get(nameOfHero).getHp() > damage){
                        int remainingHp = heroData.get(nameOfHero).getHp() - damage;
                        heroData.get(nameOfHero).setHp(remainingHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                nameOfHero , damage , attackerName , remainingHp);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", nameOfHero , attackerName);
                        heroData.remove(nameOfHero);
                    }
                    break;
                case "Recharge":
                    int rechargeMP = Integer.parseInt(tokens[2]);
                    if (heroData.get(nameOfHero).getMp() + rechargeMP > 200){
                        rechargeMP = 200 - heroData.get(nameOfHero).getMp();
                        heroData.get(nameOfHero).setMp(200);
                    } else {
                        int newMp = heroData.get(nameOfHero).getMp() + rechargeMP;
                        heroData.get(nameOfHero).setMp(newMp);
                    }
                    System.out.printf("%s recharged for %d MP!%n", nameOfHero , rechargeMP);
                    break;
                case "Heal":
                    int rechargeHP = Integer.parseInt(tokens[2]);
                    if (heroData.get(nameOfHero).getHp() + rechargeHP > 100){
                        rechargeHP = 100 - heroData.get(nameOfHero).getHp();
                        heroData.get(nameOfHero).setHp(100);
                    } else {
                        int newHp = heroData.get(nameOfHero).getHp() + rechargeHP;
                        heroData.get(nameOfHero).setHp(newHp);
                    }
                    System.out.printf("%s healed for %d HP!%n", nameOfHero , rechargeHP);
                    break;
            }
            input = scanner.nextLine();
        }
        heroData
                .entrySet()
                .stream()
                .sorted((h1 , h2) -> {
                    int result = Integer.compare(h2.getValue().getHp() , h1.getValue().getHp());
                    if (result == 0){
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach(h -> {
                    System.out.println(h.getKey());
                    System.out.printf(" HP: %d%n", h.getValue().getHp());
                    System.out.printf(" MP: %d%n", h.getValue().getMp());
                });
    }
}
