public class EchoTestDrive {
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2 = new Echo();
        int x = 0;
        while (4 != x) {
            e1.hello();
            e1.count = e1.count + 1;
            if (e2.count < 10) {
                e2.count = e2.count + 1;
            }
            if (e2.count < 10) {
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);
    }
}



/*
Pool Puzzle

public class EchoTestDrive {
    public static void main(String [] args) {
        Echo e1 = new Echo();
        _________________________
        int x = 0;
        while ( ___________ ) {
            e1.hello();
            __________________________
            if ( ____________ ) {
                e2.count = e2.count + 1;
            }
            if ( ____________ ) {
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);
    }
}
class ____________ {
    int _________ = 0;
    void ___________ {
        System.out.println(“helloooo... “);
    }
}
*/
