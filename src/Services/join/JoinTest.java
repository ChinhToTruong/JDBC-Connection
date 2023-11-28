package Services.join;

public class JoinTest {
    public static void main(String[] args) {
        JoinService.getInstance().innerJoin();
        JoinService.getInstance().leftJoin();
        JoinService.getInstance().rightJoin();
    }
}
