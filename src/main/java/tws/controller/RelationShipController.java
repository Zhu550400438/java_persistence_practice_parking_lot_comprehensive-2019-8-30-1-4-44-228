package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.RelationShip;
import tws.repository.RelationShipMapper;
import tws.vo.ReciveRelationShip;

@RestController
@RequestMapping("/relations")
public class RelationShipController {
	
	@Autowired
	private RelationShipMapper relationShipMapper;
	
	@PostMapping("")
	public ResponseEntity<String> createRelationShip(@RequestBody ReciveRelationShip reciveRelationShip){
		List<Integer> parkingLots = reciveRelationShip.getParkingLots();
		for(Integer i : parkingLots) {
			if(relationShipMapper.countAssociatedByParkingLotId(i) > 0) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		for(Integer i : parkingLots) {
			relationShipMapper.insertRelationShip(reciveRelationShip.getParkingBoyId(), i);
		}
		return ResponseEntity.ok("Created Success!");
	}
	
	@GetMapping()
	public ResponseEntity<List<RelationShip>> getAllRelationShip(){
		return ResponseEntity.ok(relationShipMapper.selectAllRelationShip());
	}
}
