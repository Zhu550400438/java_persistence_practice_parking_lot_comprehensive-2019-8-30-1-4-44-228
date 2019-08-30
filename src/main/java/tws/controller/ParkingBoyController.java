package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;
import tws.repository.RelationShipMapper;
import tws.service.ParkingBoyService;
import tws.vo.ReciveRelationShip;

@RestController
@RequestMapping("/parkingboys")
public class ParkingBoyController {
	
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;
	
	@Autowired
	private RelationShipMapper relationShipMapper;
	
	@Autowired
	private ParkingBoyService parkingBoyService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createParkingBoy(@RequestBody ParkingBoy parkingBoy) {
		parkingBoyMapper.insertParkingBoy(parkingBoy);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ParkingBoy> getAllParkingBoys(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "pageSize", required = false) Integer pageSize){
		return parkingBoyService.getAllParkingBoys(page, pageSize);
	}
	
	@GetMapping("/{id}/parkingLots")
	public ResponseEntity<ReciveRelationShip> getParkingLotsBelongToPrakingBoyById(@PathVariable int id){
		return ResponseEntity.ok(new ReciveRelationShip(id, relationShipMapper.selectParkingLotIdByParkingBoyId(id)));
	}
}
