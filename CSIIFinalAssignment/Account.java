public class Account {
    private String name;
    private int ID;
    private boolean isPaidMember;
    private int age;
    public Account(String name, int ID, boolean isPaidMember, int age){
        this.name = name;
        this.ID = ID;
        this.isPaidMember = isPaidMember;
        this.age = age;
    }
    public Account(String name, int ID, boolean isPaidMember){ //Overloading
        this.name = name;
        this.ID = ID;
        this.isPaidMember = isPaidMember;
        this.age = 0;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public boolean getIsPaidMember(){
        return isPaidMember;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setIsPaidMember(boolean isPaidMember){
        this.isPaidMember = isPaidMember;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String toString(){ // toString
        return "Name: " + name + "\nID: " + ID + "\nIs a Paid Member: " + isPaidMember + "\nAge: " + age;
    }
}
