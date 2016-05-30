package nu.info.zeeshan.rnf.model;

/**
 * Model to be extended by All type of Item so that they can used in a common way
 * Created by Zeeshan Khan on 10/29/2015.
 */
public abstract class Item {

    private short state;
    private boolean expanded;


    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public String toString() {
        return "Item{" +
                "state=" + state +
                ", expanded=" + expanded +
                '}';
    }
}
