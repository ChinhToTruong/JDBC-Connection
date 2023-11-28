package Services.insert;

public class InsertData {
    private int task_id;
    private String title;
    private int priority;
    private String decription;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public InsertData(int task_id, String title, int priority, String decription) {
        this.task_id = task_id;
        this.title = title;
        this.priority = priority;
        this.decription = decription;
    }
}
