package model;

import java.io.Serializable;

/** Base class for rewards shown after a task is completed. */
public abstract class Reward implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public Reward(
            int id,
            String name
    ) {

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {

        this.name = name;
    }

    /** Returns the user-facing message displayed when this reward is earned. */
    public abstract String getRewardMessage();
}