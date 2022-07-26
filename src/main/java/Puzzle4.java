public class Puzzle4 {
    public static void main(String [] args) {
        Puzzle4b[] obs = new Puzzle4b[6];
        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 6) {
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            y = y * 10;
            x++;
        }
        x = 6;
        while (x > 0) {
            x--;
            result = result + obs[x].doStuff(x);
        }
        System.out.println("result " + result);
    }
}
class Puzzle4b {
    int ivar;
    int doStuff(int factor) {
        if (ivar > 100) {
            return ivar * factor;
//            return ivar + factor;
        } else {
            return ivar * (5 - factor);
//            return ivar * (factor + 2);
        }
    }
}

//ivar + factor;