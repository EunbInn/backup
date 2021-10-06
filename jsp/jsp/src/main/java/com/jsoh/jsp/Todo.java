package com.jsoh.jsp;

import java.io.Serializable;

public class Todo implements Serializable {
    private String title;	// null
    private boolean isDone;	// false
    
    public Todo() {
	
    }
    
    public Todo(String title) {
	this.title = title;
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
