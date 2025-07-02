package inheritance;

import java.util.logging.Logger;

class Child extends Parent {

    String emotion;
    int strictnessLevel;

    private static final Logger LOGGER = Logger.getLogger(Child.class.getName());

    Child() {
        LOGGER.info("Child default constructor.");
    }

    Child(String emotion, int strictnessLevel) {
        super("strict", 100);

        LOGGER.info("Child constructor. Setting values....\n");
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;
        showLove();
    }

    void showLove() {
        super.showLove();

        LOGGER.info("(3) Child love...");
        LOGGER.info("Children show innocent love");
        LOGGER.info("Child emotion : " + this.emotion);
        LOGGER.info("Child strictness level : " + this.strictnessLevel);
        LOGGER.info("Overall rating : " + this.overallRating() + "\n");
    }

    String overallRating() {
        return "No need to rate Children!";
    }

}

