package model;

/**
 * Represents a food-based reward that can be earned by completing tasks, with an
 * optional caption that adds motivation or a personal touch to the reward.
 */
public class FoodReward extends Reward {

    private static final long serialVersionUID = 1L;

    private String foodName;
    private String caption;


    public FoodReward(
            int id,
            String foodName,
            String caption
    ) {

        super(
                id,
                foodName
        );

        this.foodName = foodName;
        this.caption = caption;
    }

    /** Retains the original constructor shape for callers without a caption. */
    public FoodReward(
            int id,
            String foodName
    ) {

        this(
                id,
                foodName,
                ""
        );
    }


    public String getFoodName() {

        return foodName;
    }

    public String getCaption() {

        return caption;
    }


    public void setFoodName(
            String foodName
    ) {

        this.foodName = foodName;

        setName(
                foodName
        );
    }

    public void setCaption(
            String caption
    ) {

        this.caption = caption;
    }


    @Override
    public String getRewardMessage() {

        if (
                caption == null
                || caption.trim().isEmpty()
        ) {

            return "You earned a food reward: "
                    + foodName
                    + "!";
        }

        return "You earned a food reward: "
                + foodName
                + " — "
                + caption;
    }
}