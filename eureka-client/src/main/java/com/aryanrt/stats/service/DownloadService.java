package com.aryanrt.stats.service;

import java.io.File;

public interface DownloadService {

	String getStatDate(String date);

	File getStatDateRange(String dateFrom, String dateTo);

	String getStatDate(String date, String[] teams);

	File getStatDateRange(String dateFrom, String dateTo, String[] teams);

}
