package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

@Service
public class ParkingBoyService {
	
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;
	
	public List<ParkingBoy> getAllParkingBoys(Integer page, Integer pageSize){
		  
		  int start = 0;
		  
		  if(page != null && pageSize !=null) {
		   start = (page - 1) * pageSize;
		  }
		  
		  List<ParkingBoy> resultBoys = parkingBoyMapper.getAllParkingBoyByPageAndPageSize(start, pageSize);
		  
		  resultBoys.forEach((e) -> {
		   e.setName("中原银行-" + e.getName());
		  });
		  
		  return resultBoys;
		 }
}