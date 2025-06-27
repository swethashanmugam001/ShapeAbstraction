package InheritanceExample;

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

 class Child extends Parent{

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

