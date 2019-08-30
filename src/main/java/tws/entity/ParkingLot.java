package tws.entity;

public class ParkingLot {
	private int prakingLotId;
	private int capacity;
	private int availablePositionCount;
	public int getPrakingLotId() {
		return prakingLotId;
	}
	public void setPrakingLotId(int prakingLotId) {
		this.prakingLotId = prakingLotId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailablePositionCount() {
		return availablePositionCount;
	}
	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}
	
	public ParkingLot() {
		super();
	}
	public ParkingLot(int prakingLotId, int capacity, int availablePositionCount) {
		super();
		this.prakingLotId = prakingLotId;
		this.capacity = capacity;
		this.availablePositionCount = availablePositionCount;
	}
}
