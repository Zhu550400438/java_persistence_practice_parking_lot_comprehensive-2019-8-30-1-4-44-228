package tws.entity;

public class RelationShip {
	private int id;
	private int parkingBoyId;
	private int parkingLotId;
	public RelationShip() {
		super();
	}
	public RelationShip(int id, int parkingBoyId, int parkingLotId) {
		super();
		this.id = id;
		this.parkingBoyId = parkingBoyId;
		this.parkingLotId = parkingLotId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParkingBoyId() {
		return parkingBoyId;
	}
	public void setParkingBoyId(int parkingBoyId) {
		this.parkingBoyId = parkingBoyId;
	}
	public int getParkingLotId() {
		return parkingLotId;
	}
	public void setParkingLotId(int parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
}
