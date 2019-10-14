package org.zerock.persistencd;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try {
			System.out.println("연결 시도 ");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "book_ex", "book_ex");
			System.out.println("연결 성공 ");
			log.info(con.toString());

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
