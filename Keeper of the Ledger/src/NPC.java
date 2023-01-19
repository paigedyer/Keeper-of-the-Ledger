import java.lang.String;
public class NPC {
    private int charisma;
    private int strength;
    private int endurance;
    private int killXP;
    private int charismaXP;

    public NPC(int charisma, int strength, int endurance, int killXP, int charismaXP) {}

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma() {
        this.strength = strength;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = strength;
    }
    public int getEndurance() {
        return endurance;
    }

    public void setEndurance() {
        this.endurance = endurance;
    }
    public int getCharismaXP() {
        return charismaXP;
    }

    public void setCharismaXP() {
        this.charismaXP = charismaXP;
    }
    public int getKillXP() {
        return killXP;
    }

    public void setKillXP() {
        this.killXP = killXP;
    }
}
