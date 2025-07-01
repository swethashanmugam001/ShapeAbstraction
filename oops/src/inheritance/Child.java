package inheritance;

class Child extends Parent {

    String emotion;
    int strictnessLevel;

    Child() {
        System.out.println("InheritanceExample.Child default constructor....");
    }

    Child(String emotion, int strictnessLevel) {
        super("strict", 100);

        System.out.println("InheritanceExample.Child constructor....Setting values....");
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;
        showLove();
    }

    void showLove() {
        super.showLove();

        System.out.println("3) InheritanceExample.Child love...");
        System.out.println("Children show innocent love");
        System.out.println("InheritanceExample.Child emotion : " + this.emotion);
        System.out.println("InheritanceExample.Child strictness level : " + this.strictnessLevel);
        System.out.println("Overall rating : " + this.overallRating());
    }

    String overallRating() {
        return "No need to rate Children :)";
    }

}

