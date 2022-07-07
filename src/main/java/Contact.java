public class Contact {
    static String s;

    public static void main(String[] args) {
        Contact refer;
        for (int i = 0; i < 10; i++) {
            refer = new Contact();
        }
        System.out.println(getS());
        int x = Integer.getInteger(getS());
        System.out.println(x);
    }

    static String getS(){
        return s;
    }
}
