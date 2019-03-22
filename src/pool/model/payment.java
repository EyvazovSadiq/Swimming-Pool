package pool.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/24/17
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class payment {

    private long rownum;
    private long id ;
    private String name;
    private String surname;
    private String code;
    private String category;
    private int money;
    private Date pay_date;

    public long getRownum() {
        return rownum;
    }

    public void setRownum(long rownum) {
        this.rownum = rownum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }
}
