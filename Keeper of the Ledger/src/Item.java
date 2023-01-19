public class Item {
    private boolean inInventory;
    private int weight;

    public Item(boolean inInventory, int weight) {}

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setInInventory(boolean inInventory) {
        this.inInventory = inInventory;
    }

    public boolean isInInventory() {
        return inInventory;
    }
}
