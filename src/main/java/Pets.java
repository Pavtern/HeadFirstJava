public class Pets {
    public static void main(String[] args) {
        Dog[] pets = new Dog[7];
        for (int i = 0; i < 5; i++) {
            pets[i] = new Dog();
        }
        Dog bury = new Dog();
        bury.bark();
        bury.name = "Bury";
        pets[6] = bury;
        pets[1].name = "Hol";
        pets[0].name = "Mol";
        pets[0].bark();
        pets[1].bark();
        pets[6].bark();
        pets[5].bark();

    }
}
