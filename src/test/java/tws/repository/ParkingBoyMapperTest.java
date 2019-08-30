package tws.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.ParkingBoy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingBoyMapperTest {

    @Autowired
    private ParkingBoyMapper parkingBoyMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Before
    public void clearDB() {
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    @Test
    public void shouldFetchAllParkingBoys() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan');");
        // when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoy();
        // then
        assertEquals(1, employeeList.size());
    }
    
    @Test
    public void shouldGetParkingBoyWhenCallInsertParkingBoy() {
        // given
        parkingBoyMapper.insertParkingBoy(new ParkingBoy(1, "parkingBoys_1"));
        // when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoy();
        // then
        assertEquals(1, employeeList.get(0).getEmployeeId());
        assertEquals("parkingBoys_1", employeeList.get(0).getName());
    }

@Test
public void shouldGetParkingBoyListWhenCallGetAllParkingBoyByPageAndPageSize() {
 // given
 for(int i = 0; i < 10; i++) {
  jdbcTemplate.execute("INSERT INTO parkingboy VALUES(" + (i+1) +",'parkingboy_" + i + "');");
 }
 
 // when
 List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoyByPageAndPageSize(2, 6);
 
 // then
 for(int i = 0; i < 6; i++) {
  assertEquals(i+3, employeeList.get(i).getEmployeeId());
  assertEquals("parkingboy_" + (i+2), employeeList.get(i).getName());
 		}
	}
}