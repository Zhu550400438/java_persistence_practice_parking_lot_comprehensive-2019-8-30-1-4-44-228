package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingBoy;

@Mapper
public interface ParkingBoyMapper {
   
	@Insert("insert into parkingboy values (#{parkingboy.employeeId}, #{parkingboy.name})")
	int insertParkingBoy(@Param("parkingboy") ParkingBoy parkingBoy);
	
	@Select("select * from parkingboy")
	List<ParkingBoy> getAllParkingBoy();
	
	@Select("select * from parkingboy where 1=1 order by employeeId offset #{start} rows fetch next #{pageSize} rows only ")
	 List<ParkingBoy> getAllParkingBoyByPageAndPageSize(@Param("start") int start, @Param("pageSize") int pageSize);
}
