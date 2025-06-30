package com.oops.inheritance;


class Parent extends GrandParent {

    String emotion;
    int strictnessLevel;

    Parent() {
        System.out.println("InheritanceExample.Parent default constructor....");
    }

    Parent(String emotion, int strictnessLevel) {
        super("unconditional love", 0);
        System.out.println("InheritanceExample.Parent constructor....Setting values....");
        this.emotion = emotion;
        this.strictnessLevel = strictnessLevel;

    }

    void showLove() {
        super.showLove();
        System.out.println("2) InheritanceExample.Parent love...");
        System.out.println("Parents show tough love");
        System.out.println("InheritanceExample.Parent emotion : " + this.emotion);
        System.out.println("InheritanceExample.Parent strictness level : " + this.strictnessLevel);
        System.out.println("Overall rating :" + this.overallParentRating());
    }

    String overallParentRating() {
        return "four stars only";
    }

}

