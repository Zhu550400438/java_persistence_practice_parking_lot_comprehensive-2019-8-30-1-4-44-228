package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {
	@Insert("insert into parkinglot values (#{p.prakingLotId}, #{p.capacity}, #{p.availablePositionCount})")
	int insertParkingLot(@Param("p") ParkingLot parkingLot);
	
	@Select("select * from parkinglot")
	List<ParkingLot> selectAllParkingLots();
}
