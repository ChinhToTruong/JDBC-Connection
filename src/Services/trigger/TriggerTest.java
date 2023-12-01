package Services.trigger;

public class TriggerTest {
    public static void main(String[] args) {
//        TriggerService.getInstance().createTrigger();
//
//        // past this command into mysql to see "select * from employees_audit"
//        TriggerService.getInstance().activeTrigger();

//        TriggerService.getInstance().createMultiTrigger();

        // SELECT * FROM PriceLogs;
        TriggerService.getInstance().activeMultiTrigger();
    }
}
