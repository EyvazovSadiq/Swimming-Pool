package pool.model;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/25/17
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class pay {

    private int swimmer_id;
    private int money ;
    private int limit;
    private String start_date;
    private String end_date;

    public int getSwimmer_id() {
        return swimmer_id;
    }

    public void setSwimmer_id(int swimmer_id) {
        this.swimmer_id = swimmer_id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

}
