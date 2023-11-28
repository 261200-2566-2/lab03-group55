public class Heroes {
    public int heroLV = 1;
    public int HP;
    public int mana;
    public double atk;
    public double def;
    public double baseRun;
    public double maxRun;
    void lvUp() {
        heroLV++;
        maxRun = baseRun * (0.1 + 0.03 * heroLV);
        HP = 100 + 10 * heroLV;
        mana = 50 + 2 * heroLV;
    }
    void equipSword(Sword s) {
        maxRun = maxRun - s.speedDecrease();
        atk = s.damage;;
    }

    void equipShield(Shield s) {
        maxRun = maxRun - s.speedDecrease();
        def = s.defense;
    }

    Heroes(double speed) {
        baseRun = speed;
        maxRun = baseRun * (0.1 + 0.03 * heroLV);
        HP = 100 + 10 * heroLV;
        mana = 50 + 2 * heroLV;
    }

    class Sword {
        public int swordLV = 1;
        public double damage;
        public double baseDamage;

        double speedDecrease() {
            return baseRun * (0.1 + 0.04 * swordLV);
        }

        void enchantSword() {
            swordLV++;
            damage += baseDamage*0.1*swordLV;
        }
        Sword(double damage) {
            this.damage = damage;
            baseDamage = damage;
        }
    }

    class Shield {
        public int shieldLV = 1;
        public double defense;
        public double baseDefense;

        public double speedDecrease() {
            return baseRun * (0.1 + 0.08 * shieldLV);
        }

        public void enchantShield() {
            shieldLV++;
            defense += baseDefense*0.05*shieldLV;
        }

        Shield(double defense) {
            this.defense = defense;
            baseDefense = defense;
        }
    }
    public static void main(String[] args) {
        Heroes h = new Heroes(25);
        System.out.println(h.maxRun);
        Heroes.Sword oldSword = h.new Sword(4.5);
        Heroes.Shield brokenShield = h.new Shield(3.2);
        System.out.println(h.maxRun);
        brokenShield.enchantShield();
        h.equipShield(brokenShield);
        System.out.println(h.def);
        h.equipSword(oldSword);
        System.out.println(h.atk);
        h.lvUp();
        h.lvUp();
        System.out.println(h.heroLV);
    }
}
