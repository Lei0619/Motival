package service;

import model.FoodReward;

import java.io.*;
import java.util.ArrayList;

/**
 * Handles the storage and retrieval of the student's food rewards so the app can
 * display earned or saved rewards consistently across the interface.
 */
public class RewardManager {

    private ArrayList<FoodReward> foodRewards;

    private static final String FILE_PATH =
            "data/rewards.dat";

    public RewardManager() {

        foodRewards = loadRewards();

        System.out.println(
                "RewardManager loaded: "
                        + foodRewards.size()
                        + " food rewards"
        );
    }

        /** Adds a reward and saves the updated list. Ignores null. */
    public void addFoodReward(
            FoodReward reward
    ) {

        if (reward == null) {
            return;
        }

        foodRewards.add(reward);

        saveRewards();
    }

        /** Returns the current food rewards. */
    public ArrayList<FoodReward> getFoodRewards() {

        return foodRewards;
    }

    public FoodReward getFoodRewardById(
            int id
    ) {

        for (
                FoodReward reward
                : foodRewards
        ) {

            if (
                    reward.getId()
                            == id
            ) {

                return reward;
            }
        }

        return null;
    }

    public void updateFoodReward(
            FoodReward updatedReward
    ) {

        if (updatedReward == null) {
            return;
        }

        for (
                int i = 0;
                i < foodRewards.size();
                i++
        ) {

            if (
                    foodRewards
                            .get(i)
                            .getId()
                            == updatedReward
                            .getId()
            ) {

                foodRewards.set(
                        i,
                        updatedReward
                );

                saveRewards();

                return;
            }
        }
    }

    public void deleteFoodReward(
            int id
    ) {

        for (
                int i = 0;
                i < foodRewards.size();
                i++
        ) {

            if (
                    foodRewards
                            .get(i)
                            .getId()
                            == id
            ) {

                foodRewards.remove(i);

                saveRewards();

                return;
            }
        }
    }

    public int getNextRewardId() {

        int highestId = 0;

        for (
                FoodReward reward
                : foodRewards
        ) {

            if (
                    reward.getId()
                            > highestId
            ) {

                highestId =
                        reward.getId();
            }
        }

        return highestId + 1;
    }

        /** Picks a random food reward, or returns null when the list is empty. */
    public FoodReward getRandomFoodReward() {

        if (
                foodRewards.isEmpty()
        ) {

            return null;
        }

        int randomIndex =
                (int)
                        (
                                Math.random()
                                        * foodRewards.size()
                        );

        return foodRewards.get(
                randomIndex
        );
    }

    private boolean saveRewards() {

        try {

            File file =
                    new File(
                            FILE_PATH
                    );

            File parentFolder =
                    file.getParentFile();

            if (
                    parentFolder != null
                    && !parentFolder.exists()
            ) {

                parentFolder.mkdirs();
            }

            System.out.println(
                    "Saving rewards to: "
                            + file.getAbsolutePath()
            );

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    file
                            )
                    );

            output.writeObject(
                    foodRewards
            );

            output.close();

            System.out.println(
                    "Saved "
                            + foodRewards.size()
                            + " rewards successfully."
            );

            return true;

        } catch (
                IOException e
        ) {

            System.out.println(
                    "Error saving rewards: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<FoodReward> loadRewards() {

        File file =
                new File(
                        FILE_PATH
                );

        System.out.println(
                "Looking for reward file at: "
                        + file.getAbsolutePath()
        );

        if (
                !file.exists()
        ) {

            System.out.println(
                    "No rewards.dat found."
                            + " Starting with empty reward list."
            );

            return new ArrayList<>();
        }

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(
                                    file
                            )
                    );

            ArrayList<FoodReward> loadedRewards =
                    (ArrayList<FoodReward>)
                            input.readObject();

            input.close();

            if (
                    loadedRewards == null
            ) {

                return new ArrayList<>();
            }

            System.out.println(
                    "Loaded "
                            + loadedRewards.size()
                            + " rewards from file."
            );

            return loadedRewards;

        } catch (
                IOException
                | ClassNotFoundException e
        ) {

            System.out.println(
                    "Error loading rewards: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}