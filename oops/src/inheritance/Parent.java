package inheritance;

import java.util.logging.Logger;

class Parent extends GrandParent {

    String emotion;
    int strictnessLevel;

    private static final Logger LOGGER = Logger.getLogger(Parent.class.getName());

    Parent() {
        LOGGER.info("Parent default constructor.");
    }

    Parent(String emotion, int strictnessLevel) {
        super("unconditional love", 0);

        LOGGER.info("Parent constructor. Setting values....");
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;
    }

    void showLove() {
        super.showLove();

        LOGGER.info("(2) Parent love...");
        LOGGER.info("Parents show tough love");
        LOGGER.info("Parent emotion : " + this.emotion);
        LOGGER.info("Parent strictness level : " + this.strictnessLevel);
        LOGGER.info("Overall rating : " + this.overallParentRating() + "\n");
    }

    String overallParentRating() {
        return "Four Stars Only";
    }
}

