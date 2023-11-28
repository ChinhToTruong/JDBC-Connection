package Services.select;

import Services.select.SelectService;

public class TestSelect {
    public static void main(String[] args) {
        SelectService.getInstance().select();
        SelectService.getInstance().selectDistinct();
    }
}
