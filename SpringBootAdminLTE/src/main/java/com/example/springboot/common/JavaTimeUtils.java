package com.example.springboot.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility functions for java.time API (introduced since JDK 8).
 * 
 * https://www.baeldung.com/java-convert-localdate-sql-date
 * https://www.baeldung.com/java-date-to-localdate-and-localdatetime
 * 
 * @author bobyuan
 */
public class JavaTimeUtils {
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// ---------- Parse and format ----------

	/** Parse date string like "2017-11-15" */
	public static LocalDate parseLocalDateISO(final String strDate) {
		return LocalDate.parse(strDate);
	}

	/** Format date string like "2017-11-15" */
	public static String formatLocalDateISO(final LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	/**
	 * Parse date time string like "2017-11-15T08:22:12" or "2017-11-15T08:22:12.896". 
	 * Will also be capable to parse default format like "2017-11-15 08:22:12".
	 */
	public static LocalDateTime parseLocalDateTimeISO(final String strDateTime) {
		try {
			return LocalDateTime.parse(strDateTime);
		} catch (DateTimeParseException e1) {
			// continue by using default format.
			return LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
		}
	}

	/**
	 * Format date time string like "2017-11-15T08:22:12" or "2017-11-15T08:22:12.896"
	 */
	public static String formatLocalDateTimeISO(final LocalDateTime localDateTime) {
		return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	// ---------- LocalDate converting methods ----------

	public static LocalDate sqlDateToLocalDate(final java.sql.Date sqlDateToConvert) {
		// return Optional.ofNullable(sqlDateToConvert).map(java.sql.Date::toLocalDate).orElse(null);
		return sqlDateToConvert.toLocalDate();
	}

	public static java.sql.Date localDateToSqlDate(final LocalDate localDateToConvert) {
		// return Optional.ofNullable(localDateToConvert).map(java.sql.Date::valueOf).orElse(null);
		return java.sql.Date.valueOf(localDateToConvert);
	}

	public static LocalDate utilDateToLocalDate(final java.util.Date utilDateToConvert) {
		return utilDateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static java.util.Date localDateToUtilDate(final LocalDate localDateToConvert) {
		return java.util.Date.from(localDateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	// ---------- LocalDateTime converting methods ----------

	public static LocalDateTime sqlTimestampToLocalDateTime(final java.sql.Timestamp sqlTimestampToConvert) {
		return new java.sql.Timestamp(sqlTimestampToConvert.getTime()).toLocalDateTime();
	}

	public static java.sql.Timestamp localDateTimeToSqlTimestamp(final LocalDateTime localDateTimeToConvert) {
		return java.sql.Timestamp.valueOf(localDateTimeToConvert);
	}

	public static LocalDateTime utilDateToLocalDateTime(final java.util.Date utilDateToConvert) {
		return utilDateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static java.util.Date localDateTimeToUtilDate(final LocalDateTime localDateTimeToConvert) {
		return java.util.Date.from(localDateTimeToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

	// ---------- LocalDateTime to ZonedDateTime ----------
	// https://stackoverflow.com/questions/34626382/convert-localdatetime-to-localdatetime-in-utc

	public static ZonedDateTime localDateTimeToZonedDateTimeInSystemDefault(final LocalDateTime localDateTime) {
		ZonedDateTime ldtZoned = localDateTime.atZone(ZoneId.systemDefault());
		return ldtZoned;
	}

	public static ZonedDateTime localDateTimeToZonedDateTimeInUTC(final LocalDateTime localDateTime) {
		ZonedDateTime ldtZoned = localDateTime.atZone(ZoneId.systemDefault());
		ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneOffset.UTC);
		return utcZoned;
	}

	// ---------- Utility functions ----------

	public static int calcAge(final LocalDate beginDate, final LocalDate endDate) {
		Period p = Period.between(beginDate, endDate);
		int years = p.getYears();
		// int months = p.getMonths();
		// int days = p.getDays();
		return years;
	}

	public static int calcAge(final LocalDate beginDate) {
		LocalDate endDate = LocalDate.now();
		return calcAge(beginDate, endDate);
	}
}
