package inheritance;

import java.util.logging.Logger;

class GrandParent {

    String emotion;
    int strictnessLevel;

    private static final Logger LOGGER = Logger.getLogger(GrandParent.class.getName());

    GrandParent() {
        LOGGER.info("Grandparent default constructor.");
    }

    GrandParent(String emotion, int strictnessLevel) {
        LOGGER.info("Grandparent constructor. Setting values....");
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;
    }

    void showLove() {
        LOGGER.info("(1) Grandparent love...");
        LOGGER.info("Grandparents show unconditional love");
        LOGGER.info("Grandparent emotion : " + this.emotion);
        LOGGER.info("Grandparent strictness level : " + this.strictnessLevel);
        LOGGER.info("Overall rating : " + this.overallGrandParentRating() + "\n");
    }

    String overallGrandParentRating(){
        return "Full Five Stars";
    }
}

