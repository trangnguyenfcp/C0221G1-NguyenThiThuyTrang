package ss19_string_regex.exercise;

public class ClassExampleTest {
    private static ClassExample classExample;
    private static String[] validClass = new String[]{"C0221G", "A8271L", "C0318G"};
    private static String[] invalidClass = new String[]{" M0318G" ,"P0323A"};

    public static void main(String[] args) {
        classExample = new ClassExample();
        for (String class1 : validClass){
            boolean isValid = classExample.validate(class1);
            System.out.println("Class is " + class1 + "is valid: " + isValid);
        }
        for (String class1 : invalidClass){
            boolean isValid = classExample.validate(class1);
            System.out.println("Class is " + class1 + "is valid: " + isValid);
        }
    }
}
