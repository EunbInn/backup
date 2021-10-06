package com.jsoh.jsp;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final AtomicInteger counter = new AtomicInteger(0);
    
    private long id;
    private String title;	// null
    private boolean isDone;	// false
    
    public Todo() {
	id = counter.getAndIncrement();
    }
    
    public Todo(String title) {
	this();
	this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (isDone ? 1231 : 1237);
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Todo other = (Todo) obj;
	if (isDone != other.isDone)
	    return false;
	if (title == null) {
	    if (other.title != null)
		return false;
	} else if (!title.equals(other.title))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Todo [title=" + title + ", isDone=" + isDone + "]";
    }

    
    
}
