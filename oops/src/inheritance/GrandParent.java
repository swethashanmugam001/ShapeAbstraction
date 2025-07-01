package inheritance;

class GrandParent {

    String emotion;
    int strictnessLevel;

    GrandParent()
    {
         System.out.println("Grandparent default constructor....");
    }

    GrandParent(String emotion, int strictnessLevel)
    {
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;
        System.out.println("Grandparent constructor....Setting values....");
    }

    void showLove()
    {
        System.out.println("1) Grandparent love...");
        System.out.println("Grandparents show unconditional love");
        System.out.println("Grandparent emotion : " + this.emotion);
        System.out.println("Grandparent strictness level : " + this.strictnessLevel);
        System.out.println("Overall rating : " + this.overallGrandParentRating());
    }

    String overallGrandParentRating(){
            return "full five stars";
    }
}

