package com.example.springboot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test case for JavaTimeUtils.
 * 
 * @author bobyuan
 */
public class JavaTimeUtilsTest {

	@Test
	public void test_parseLocalDateISO() {
		LocalDate localDate1 = JavaTimeUtils.parseLocalDateISO("2017-12-03");
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());

		LocalDate localDate2 = JavaTimeUtils.parseLocalDateISO("2017-02-03");
		Assertions.assertEquals(2017, localDate2.getYear());
		Assertions.assertEquals(2, localDate2.getMonthValue());
		Assertions.assertEquals(3, localDate2.getDayOfMonth());
	}

	@Test
	public void test_formatLocalDateISO() {
		LocalDate localDate1 = LocalDate.of(2017, 12, 3);
		Assertions.assertEquals("2017-12-03", JavaTimeUtils.formatLocalDateISO(localDate1));

		LocalDate localDate2 = LocalDate.of(2017, 2, 3);
		Assertions.assertEquals("2017-02-03", JavaTimeUtils.formatLocalDateISO(localDate2));
	}

	@Test
	public void test_parseLocalDateTimeISO() {
		LocalDateTime localDateTime1 = JavaTimeUtils.parseLocalDateTimeISO("2017-12-03T10:15:30");
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(10, localDateTime1.getHour());
		Assertions.assertEquals(15, localDateTime1.getMinute());
		Assertions.assertEquals(30, localDateTime1.getSecond());

		LocalDateTime localDateTime2 = JavaTimeUtils.parseLocalDateTimeISO("2017-02-03T21:45:23.896");
		Assertions.assertEquals(2017, localDateTime2.getYear());
		Assertions.assertEquals(2, localDateTime2.getMonthValue());
		Assertions.assertEquals(3, localDateTime2.getDayOfMonth());
		Assertions.assertEquals(21, localDateTime2.getHour());
		Assertions.assertEquals(45, localDateTime2.getMinute());
		Assertions.assertEquals(23, localDateTime2.getSecond());
		Assertions.assertEquals(896000000, localDateTime2.getNano());
		
		// test fall back to use the default date time format.
		LocalDateTime localDateTime3 = JavaTimeUtils.parseLocalDateTimeISO("2017-12-03 10:15:30");
		Assertions.assertEquals(2017, localDateTime3.getYear());
		Assertions.assertEquals(12, localDateTime3.getMonthValue());
		Assertions.assertEquals(3, localDateTime3.getDayOfMonth());
		Assertions.assertEquals(10, localDateTime3.getHour());
		Assertions.assertEquals(15, localDateTime3.getMinute());
		Assertions.assertEquals(30, localDateTime3.getSecond());
	}

	@Test
	public void test_formatLocalDateTimeISO() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 10, 15, 30);
		Assertions.assertEquals("2017-12-03T10:15:30", JavaTimeUtils.formatLocalDateTimeISO(localDateTime1));

		LocalDateTime localDateTime2 = LocalDateTime.of(2017, 2, 3, 21, 45, 23, 896000000);
		Assertions.assertEquals("2017-02-03T21:45:23.896", JavaTimeUtils.formatLocalDateTimeISO(localDateTime2));
	}
	
	
	@Test
	public void test_sqlDateToLocalDate() {
		java.sql.Date sqlDate1 = java.sql.Date.valueOf("2017-12-03");
		LocalDate localDate1 = JavaTimeUtils.sqlDateToLocalDate(sqlDate1);
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	public void test_localDateToSqlDate() {
		java.sql.Date sqlDate1 = JavaTimeUtils.localDateToSqlDate(LocalDate.of(2017, 12, 3));
		LocalDate localDate1 = sqlDate1.toLocalDate();
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	public void test_utilDateToLocalDate() throws ParseException {
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate1 = formatdate.parse("2017-12-03");
		LocalDate localDate1 = JavaTimeUtils.utilDateToLocalDate(utilDate1);
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	public void test_localDateToUtilDate() {
		LocalDate localDate1 = LocalDate.of(2017, 12, 3);
		java.util.Date utilDate1 = JavaTimeUtils.localDateToUtilDate(localDate1);
		Assertions.assertEquals("2017-12-03", new SimpleDateFormat("yyyy-MM-dd").format(utilDate1));
	}

	
	@Test
	public void test_sqlTimestampToLocalDateTime() {
		java.sql.Timestamp sqlTimestamp1 = java.sql.Timestamp.valueOf("2017-12-03 06:07:45");
		LocalDateTime localDateTime1 = JavaTimeUtils.sqlTimestampToLocalDateTime(sqlTimestamp1);
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(6, localDateTime1.getHour());
		Assertions.assertEquals(7, localDateTime1.getMinute());
		Assertions.assertEquals(45, localDateTime1.getSecond());
	}

	@Test
	public void test_localDateTimeToSqlTimestamp() {
		java.sql.Timestamp sqlTimestamp1 = JavaTimeUtils
				.localDateTimeToSqlTimestamp(LocalDateTime.of(2017, 12, 3, 6, 7, 45));
		LocalDateTime localDateTime1 = sqlTimestamp1.toLocalDateTime();
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(6, localDateTime1.getHour());
		Assertions.assertEquals(7, localDateTime1.getMinute());
		Assertions.assertEquals(45, localDateTime1.getSecond());
	}

	@Test
	public void test_utilDateToLocalDateTime() throws ParseException {
		SimpleDateFormat formatdatetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date utilDate1 = formatdatetime.parse("2017-12-03 06:07:45");
		LocalDateTime localDateTime1 = JavaTimeUtils.utilDateToLocalDateTime(utilDate1);
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(6, localDateTime1.getHour());
		Assertions.assertEquals(7, localDateTime1.getMinute());
		Assertions.assertEquals(45, localDateTime1.getSecond());
	}

	@Test
	public void test_localDateTimeToUtilDate() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 6, 7, 45);
		java.util.Date utilDate1 = JavaTimeUtils.localDateTimeToUtilDate(localDateTime1);
		Assertions.assertEquals("2017-12-03 06:07:45", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(utilDate1));
	}

	
	@Test
	public void test_localDateTimeToZonedDateTimeInSystemDefault() {
		// System.out.println("test_localDateTimeToZonedDateTimeSystemDefault: ");
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 6, 7, 45);
		// System.out.println(localDateTime1);
		ZonedDateTime zonedDateTime1 = JavaTimeUtils.localDateTimeToZonedDateTimeInSystemDefault(localDateTime1);
		// System.out.println(zonedDateTime1);
		// 2017-12-03T06:07:45+08:00[Asia/Shanghai]

		Assertions.assertEquals(localDateTime1.atZone(ZoneId.systemDefault()), zonedDateTime1);
	}

	@Test
	public void test_localDateTimeToZonedDateTimeInUTC() {
		// System.out.println("test_localDateTimeToZonedDateTimeUTC: ");
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 6, 7, 45);
		// System.out.println(localDateTime1);
		ZonedDateTime zonedDateTime1 = JavaTimeUtils.localDateTimeToZonedDateTimeInUTC(localDateTime1);
		// System.out.println(zonedDateTime1);
		// 2017-12-02T22:07:45Z[UTC]

		Assertions.assertEquals(localDateTime1.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC),
				zonedDateTime1);
	}

	
	@Test
	public void test_calcAge() {
		Assertions.assertEquals(0, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2020, 11, 22)));
		Assertions.assertEquals(0, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(0, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 21)));
		Assertions.assertEquals(1, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 22)));
		Assertions.assertEquals(1, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 23)));
		Assertions.assertEquals(2, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2022, 11, 22)));
		Assertions.assertEquals(2, JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2022, 11, 23)));

		Assertions.assertEquals(0, JavaTimeUtils.calcAge(LocalDate.of(2021, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(-1, JavaTimeUtils.calcAge(LocalDate.of(2021, 11, 22), LocalDate.of(2020, 11, 22)));
		Assertions.assertEquals(-1, JavaTimeUtils.calcAge(LocalDate.of(2022, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(-2, JavaTimeUtils.calcAge(LocalDate.of(2022, 11, 22), LocalDate.of(2020, 11, 22)));

		Assertions.assertEquals(JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22)),
				JavaTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.now()));
		Assertions.assertEquals(JavaTimeUtils.calcAge(LocalDate.of(1980, 10, 29)),
				JavaTimeUtils.calcAge(LocalDate.of(1980, 10, 29), LocalDate.now()));
	}

}
