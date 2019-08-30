package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.RelationShip;

@Mapper
public interface RelationShipMapper {
	
	@Select("select count(*) from relationship where parkingLotId = #{id}")
	int countAssociatedByParkingLotId(@Param("id") int id);
	
	@Select("select * from relationship")
	List<RelationShip> selectAllRelationShip();
	
	@Select("select parkingLotId from relationship where parkingBoyId = #{id}")
	List<Integer> selectParkingLotIdByParkingBoyId(@Param("id") int id);
	
	@Insert("insert into relationship (parkingBoyId, parkingLotId) values (#{parkingBoyId}, #{parkingLotId})")
	int insertRelationShip(@Param("parkingBoyId") int parkingBoyId, @Param("parkingLotId") int parkingLotId);

}
