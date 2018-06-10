package model;

/**
 * Created by eisti on 13/03/17.
 */

/**
 * Class describing a level. Each class has a description, a difficulty and a status
 * (Locked or unLocked)
 */
public class Level {
    private String levelName;
    private Difficulty difficulty;
    private boolean isLocked;
    private String description;

    /**
     * Constructor of a level
     *
     * Each level has a
     * @param difficulty which is of an enumeration type Difficulty
     * @param isLocked which descibes whether is locke or not
     * @param description providing a bief level description
     */
    public Level(String levelName, Difficulty difficulty, boolean isLocked, String description) {
        this.difficulty = difficulty;
        this.isLocked = isLocked;
        this.description = description;
        this.levelName = levelName;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
