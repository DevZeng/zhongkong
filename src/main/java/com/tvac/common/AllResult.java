package com.tvac.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author zou
 */
public class AllResult  implements Serializable {

    private Long total;

    private List<?> data;

    private  String  setmessage;

    public String getSetmessage() { return setmessage; }

    public void setSetmessage(String setmessage) {this.setmessage = setmessage; }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
