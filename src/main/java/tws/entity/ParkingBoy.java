package tws.entity;

public class ParkingBoy {
    private int employeeId;
    private String name;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ParkingBoy() {
		super();
	}
	public ParkingBoy(int employeeId, String name) {
		super();
		this.employeeId = employeeId;
		this.name = name;
	}   
}
