package com.lexass.Model.POJO;

import java.util.List;

public class PaginatedBeautiesPOJO {
    private int count;

    private String next;

    private String  previous;

    private List<BeautyPOJO> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<BeautyPOJO> getResults() {
        return results;
    }

    public void setResults(List<BeautyPOJO> results) {
        this.results = results;
    }
}
