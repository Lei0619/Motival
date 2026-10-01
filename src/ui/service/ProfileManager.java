package service;

import model.Profile;

import java.io.*;

/** Loads and saves the student's profile. */
public class ProfileManager {

    private Profile profile;

    private static final String FILE_PATH =
            "data/profile.dat";

    public ProfileManager() {

        profile = loadProfile();

        System.out.println(
                "ProfileManager loaded."
        );

        if (profile != null) {

            System.out.println(
                    "Profile: "
                            + profile.getName()
            );

        } else {

            System.out.println(
                    "No profile found."
            );
        }
    }


        /** Returns the current profile, or null if none is available. */
    public Profile getProfile() {

        return profile;
    }


        /** Returns true once a profile has been loaded or created. */
    public boolean hasProfile() {

        return profile != null;
    }


    /**
        * Checks the required fields, updates the profile, and saves it. Returns
        * false if a value is blank or the save fails.
    */
    public boolean updateProfile(
            String name,
            String yearLevel,
            String program
    ) {

        if (
                name == null
                || name.trim().isEmpty()
        ) {

            return false;
        }

        if (
                yearLevel == null
                || yearLevel.trim().isEmpty()
        ) {

            return false;
        }

        if (
                program == null
                || program.trim().isEmpty()
        ) {

            return false;
        }

        if (profile != null) {

            profile.setName(
                    name.trim()
            );

            profile.setYearLevel(
                    yearLevel.trim()
            );

            profile.setProgram(
                    program.trim()
            );

        } else {

            profile =
                    new Profile(
                            name.trim(),
                            yearLevel.trim(),
                            program.trim()
                    );
        }

        return saveProfile();
    }


        /** Saves the current profile to {@code data/profile.dat}. */
    public boolean saveProfile() {

        if (profile == null) {

            return false;
        }

        try {

            File file =
                    new File(
                            FILE_PATH
                    );

            File parent =
                    file.getParentFile();

            if (
                    parent != null
                    && !parent.exists()
            ) {

                parent.mkdirs();
            }

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    file
                            )
                    );

            output.writeObject(
                    profile
            );

            output.close();

            System.out.println(
                    "Profile saved successfully."
            );

            return true;

        } catch (IOException e) {

            System.out.println(
                    "Error saving profile:"
            );

            e.printStackTrace();

            return false;
        }
    }


        /** Reads the saved profile, or returns null when no file is available. */
    private Profile loadProfile() {

        File file =
                new File(
                        FILE_PATH
                );

        if (
                !file.exists()
        ) {

            return null;
        }

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(
                                    file
                            )
                    );

            Profile loadedProfile =
                    (Profile) input.readObject();

            input.close();

            return loadedProfile;

        } catch (
                IOException
                | ClassNotFoundException e
        ) {

            System.out.println(
                    "Error loading profile:"
            );

            e.printStackTrace();

            return null;
        }
    }
}