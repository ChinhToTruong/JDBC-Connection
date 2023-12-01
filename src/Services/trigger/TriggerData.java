package Services.trigger;

public class TriggerData {
    public String name;
    public String event;
    public String tableName;
    public String statementTrigger;
    public String timing;

    public TriggerData(String name, String event, String tableName, String statementTrigger, String timing) {
        this.name = name;
        this.event = event;
        this.tableName = tableName;
        this.statementTrigger = statementTrigger;
        this.timing = timing;
    }
}
