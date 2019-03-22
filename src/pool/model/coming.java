package pool.model;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/25/17
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class coming {

    private long rownum;
    private long id ;
    private String name ;
    private String surname;
    private String code;
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
