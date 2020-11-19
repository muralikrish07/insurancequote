package com.cg.model;

public class BusinessSegment {
public String busSegId;
public int busSegSeq;
public String busSegName;
public String getBusSegId() {
	return busSegId;
}
public void setBusSegId(String busSegId) {
	this.busSegId = busSegId;
}
public int getBusSegSeq() {
	return busSegSeq;
}
public void setBusSegSeq(int busSegSeq) {
	this.busSegSeq = busSegSeq;
}
public String getBusSegName() {
	return busSegName;
}
public void setBusSegName(String busSegName) {
	this.busSegName = busSegName;
}
public BusinessSegment(String busSegId, int busSegSeq, String busSegName) {
	super();
	this.busSegId = busSegId;
	this.busSegSeq = busSegSeq;
	this.busSegName = busSegName;
}
@Override
public String toString() {
	return "BusinessSegment [busSegId=" + busSegId + ", busSegSeq=" + busSegSeq + ", busSegName=" + busSegName + "]";
}

}
