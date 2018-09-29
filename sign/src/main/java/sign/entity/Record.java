package sign.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Record {
    private Integer rid;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Integer uid;

    private Integer message;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }
}