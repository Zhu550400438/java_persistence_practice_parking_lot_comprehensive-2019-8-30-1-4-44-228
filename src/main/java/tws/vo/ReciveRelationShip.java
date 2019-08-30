package tws.vo;

import java.util.List;

public class ReciveRelationShip {
	private int parkingBoyId;
	private List<Integer> parkingLots;
	public int getParkingBoyId() {
		return parkingBoyId;
	}
	public void setParkingBoyId(int parkingBoyId) {
		this.parkingBoyId = parkingBoyId;
	}
	public List<Integer> getParkingLots() {
		return parkingLots;
	}
	public void setParkingLots(List<Integer> parkingLots) {
		this.parkingLots = parkingLots;
	}
	public ReciveRelationShip() {
		super();
	}
	public ReciveRelationShip(int parkingBoyId, List<Integer> parkingLots) {
		super();
		this.parkingBoyId = parkingBoyId;
		this.parkingLots = parkingLots;
	}
}
