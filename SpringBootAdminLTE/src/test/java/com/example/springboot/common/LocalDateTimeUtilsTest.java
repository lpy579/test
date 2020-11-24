package com.example.springboot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocalDateTimeUtilsTest {

	@Test
	void testParseLocalDate() {
		LocalDate localDate1 = LocalDateTimeUtils.parseLocalDate("2017-12-03");
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());

		LocalDate localDate2 = LocalDateTimeUtils.parseLocalDate("2017-02-03");
		Assertions.assertEquals(2017, localDate2.getYear());
		Assertions.assertEquals(2, localDate2.getMonthValue());
		Assertions.assertEquals(3, localDate2.getDayOfMonth());
	}

	@Test
	void testFormatLocalDate() {
		LocalDate localDate1 = LocalDate.of(2017, 12, 3);
		Assertions.assertEquals("2017-12-03", LocalDateTimeUtils.formatLocalDate(localDate1));

		LocalDate localDate2 = LocalDate.of(2017, 2, 3);
		Assertions.assertEquals("2017-02-03", LocalDateTimeUtils.formatLocalDate(localDate2));
	}

	@Test
	void testParseLocalDateTime() {
		LocalDateTime localDateTime1 = LocalDateTimeUtils.parseLocalDateTime("2017-12-03T10:15:30");
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(10, localDateTime1.getHour());
		Assertions.assertEquals(15, localDateTime1.getMinute());
		Assertions.assertEquals(30, localDateTime1.getSecond());

		LocalDateTime localDateTime2 = LocalDateTimeUtils.parseLocalDateTime("2017-02-03T21:45:23");
		Assertions.assertEquals(2017, localDateTime2.getYear());
		Assertions.assertEquals(2, localDateTime2.getMonthValue());
		Assertions.assertEquals(3, localDateTime2.getDayOfMonth());
		Assertions.assertEquals(21, localDateTime2.getHour());
		Assertions.assertEquals(45, localDateTime2.getMinute());
		Assertions.assertEquals(23, localDateTime2.getSecond());
	}

	@Test
	void testFormatLocalDateTime() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 10, 15, 30);
		Assertions.assertEquals("2017-12-03T10:15:30", LocalDateTimeUtils.formatLocalDateTime(localDateTime1));

		LocalDateTime localDateTime2 = LocalDateTime.of(2017, 2, 3, 21, 45, 23);
		Assertions.assertEquals("2017-02-03T21:45:23", LocalDateTimeUtils.formatLocalDateTime(localDateTime2));
	}

	@Test
	void testSqlDateToLocalDate() {
		java.sql.Date sqlDate1 = java.sql.Date.valueOf("2017-12-03");
		LocalDate localDate1 = LocalDateTimeUtils.sqlDateToLocalDate(sqlDate1);
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	void testLocalDateToSqlDate() {
		java.sql.Date sqlDate1 = LocalDateTimeUtils.localDateToSqlDate(LocalDate.of(2017, 12, 3));
		LocalDate localDate1 = sqlDate1.toLocalDate();
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	void testUtilDateToLocalDate() throws ParseException {
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate1 = formatdate.parse("2017-12-03");
		LocalDate localDate1 = LocalDateTimeUtils.utilDateToLocalDate(utilDate1);
		Assertions.assertEquals(2017, localDate1.getYear());
		Assertions.assertEquals(12, localDate1.getMonthValue());
		Assertions.assertEquals(3, localDate1.getDayOfMonth());
	}

	@Test
	void testLocalDateToUtilDate() {
		LocalDate localDate1 = LocalDate.of(2017, 12, 3);
		java.util.Date utilDate1 = LocalDateTimeUtils.localDateToUtilDate(localDate1);
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
		Assertions.assertEquals("2017-12-03", formatdate.format(utilDate1));
	}

	@Test
	void testSqlTimestampToLocalDateTime() {
		java.sql.Timestamp sqlTimestamp1 = java.sql.Timestamp.valueOf("2017-12-03 06:07:45");
		LocalDateTime localDateTime1 = LocalDateTimeUtils.sqlTimestampToLocalDateTime(sqlTimestamp1);
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(6, localDateTime1.getHour());
		Assertions.assertEquals(7, localDateTime1.getMinute());
		Assertions.assertEquals(45, localDateTime1.getSecond());
	}

	@Test
	void testLocalDateTimeToSqlTimestamp() {
		java.sql.Timestamp sqlTimestamp1 = LocalDateTimeUtils
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
	void testUtilDateToLocalDateTime() throws ParseException {
		SimpleDateFormat formatdatetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date utilDate1 = formatdatetime.parse("2017-12-03 06:07:45");
		LocalDateTime localDateTime1 = LocalDateTimeUtils.utilDateToLocalDateTime(utilDate1);
		Assertions.assertEquals(2017, localDateTime1.getYear());
		Assertions.assertEquals(12, localDateTime1.getMonthValue());
		Assertions.assertEquals(3, localDateTime1.getDayOfMonth());
		Assertions.assertEquals(6, localDateTime1.getHour());
		Assertions.assertEquals(7, localDateTime1.getMinute());
		Assertions.assertEquals(45, localDateTime1.getSecond());
	}

	@Test
	void testLocalDateTimeToUtilDate() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 12, 3, 6, 7, 45);
		java.util.Date utilDate1 = LocalDateTimeUtils.localDateTimeToUtilDate(localDateTime1);
		SimpleDateFormat formatdatetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Assertions.assertEquals("2017-12-03 06:07:45", formatdatetime.format(utilDate1));
	}

	@Test
	void testCalcAge() {
		Assertions.assertEquals(0, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2020, 11, 22)));
		Assertions.assertEquals(0, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(0, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 21)));
		Assertions.assertEquals(1, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 22)));
		Assertions.assertEquals(1, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2021, 11, 23)));
		Assertions.assertEquals(2, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2022, 11, 22)));
		Assertions.assertEquals(2, LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.of(2022, 11, 23)));

		Assertions.assertEquals(0, LocalDateTimeUtils.calcAge(LocalDate.of(2021, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(-1, LocalDateTimeUtils.calcAge(LocalDate.of(2021, 11, 22), LocalDate.of(2020, 11, 22)));
		Assertions.assertEquals(-1, LocalDateTimeUtils.calcAge(LocalDate.of(2022, 11, 22), LocalDate.of(2020, 11, 23)));
		Assertions.assertEquals(-2, LocalDateTimeUtils.calcAge(LocalDate.of(2022, 11, 22), LocalDate.of(2020, 11, 22)));

		Assertions.assertEquals(LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22)),
				LocalDateTimeUtils.calcAge(LocalDate.of(2020, 11, 22), LocalDate.now()));
		Assertions.assertEquals(LocalDateTimeUtils.calcAge(LocalDate.of(1980, 10, 29)),
				LocalDateTimeUtils.calcAge(LocalDate.of(1980, 10, 29), LocalDate.now()));
	}

}
