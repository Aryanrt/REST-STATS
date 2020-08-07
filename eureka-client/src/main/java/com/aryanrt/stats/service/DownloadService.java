package com.aryanrt.stats.service;

import java.io.File;

public interface DownloadService {

	String getStatDate(String date);

	String getStatDateRange(String dateFrom, String dateTo);

	String getStatDate(String date, String[] teams);

	String getStatDateRange(String dateFrom, String dateTo, String[] teams);

}
