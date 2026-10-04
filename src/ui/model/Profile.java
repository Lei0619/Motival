package model;

import java.io.Serializable;

/**
 * Stores the student's saved profile information, including their name,
 * academic program, and year level, so the app can personalize the experience.
 */
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String yearLevel;
    private String program;

    public Profile(
            String name,
            String yearLevel,
            String program
    ) {

        this.name = name;
        this.yearLevel = yearLevel;
        this.program = program;
    }


    public String getName() {

        return name;
    }

    public String getYearLevel() {

        return yearLevel;
    }

    public String getProgram() {

        return program;
    }


    public void setName(
            String name
    ) {

        this.name = name;
    }

    public void setYearLevel(
            String yearLevel
    ) {

        this.yearLevel = yearLevel;
    }

    public void setProgram(
            String program
    ) {

        this.program = program;
    }
}