package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.RelationShip;

@RunWith(SpringRunner.class)
@MybatisTest
public class RelationShipMapperTest {
	@Autowired
    private RelationShipMapper relationShipMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Before
    public void clearDB() {
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "relationship");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "relationship");
    }
    
    @Test
    public void shouldFetchAllRelationShip() {
    	// given
        jdbcTemplate.execute("INSERT INTO relationship (parkingboyId, parkingLotId) VALUES(10, 11);");
        // when
        List<RelationShip> relationShipList = relationShipMapper.selectAllRelationShip();
        // then
        assertEquals(1, relationShipList.size());
    }
    
    @Test
    public void shouldCountAssociatedByParkingLotId() {
    	// given
        jdbcTemplate.execute("INSERT INTO relationship (parkingboyId, parkingLotId) VALUES(10, 11);");
        // when
        int count = relationShipMapper.countAssociatedByParkingLotId(11);
        // then
        assertEquals(1, count);
    }

    @Test
    public void shouldSelectParkingLotIdByParkingBoyId() {
    	// given
        jdbcTemplate.execute("INSERT INTO relationship (parkingboyId, parkingLotId) VALUES(1, 11);");
        jdbcTemplate.execute("INSERT INTO relationship (parkingboyId, parkingLotId) VALUES(1, 12);");
        jdbcTemplate.execute("INSERT INTO relationship (parkingboyId, parkingLotId) VALUES(1, 13);");
        // when
        List<Integer> list = relationShipMapper.selectParkingLotIdByParkingBoyId(1);
        // then
        assertEquals(3, list.size());
    }
    
    @Test
    public void shouldInsertRelationShip() {
    	// given
        relationShipMapper.insertRelationShip(1, 2);
        // when
        List<Map<String, Object>> relationShip = jdbcTemplate.queryForList("select * from relationship");
        // then
        // System.out.println(relationShip.size());
        assertEquals(1, relationShip.size());
        assertEquals(1, relationShip.get(0).get("parkingboyId"));
        assertEquals(2, relationShip.get(0).get("parkingLotId"));
    }
}
