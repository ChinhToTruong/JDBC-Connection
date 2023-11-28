package Services.groupBy;

import java.util.Date;

public class GroupByData {
    private Long year;
    private double total;

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public GroupByData(Long year, double total) {
        this.year = year;
        this.total = total;
    }
}
