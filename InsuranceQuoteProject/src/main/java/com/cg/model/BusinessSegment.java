package com.cg.model;

public class BusinessSegment {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busSegId == null) ? 0 : busSegId.hashCode());
		result = prime * result + ((busSegName == null) ? 0 : busSegName.hashCode());
		result = prime * result + busSegSeq;
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
		BusinessSegment other = (BusinessSegment) obj;
		if (busSegId == null) {
			if (other.busSegId != null)
				return false;
		} else if (!busSegId.equals(other.busSegId))
			return false;
		if (busSegName == null) {
			if (other.busSegName != null)
				return false;
		} else if (!busSegName.equals(other.busSegName))
			return false;
		if (busSegSeq != other.busSegSeq)
			return false;
		return true;
	}
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
