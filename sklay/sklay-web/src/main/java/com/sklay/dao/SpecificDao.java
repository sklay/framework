package com.sklay.dao;

import java.util.Date;
import java.util.List;

import com.sklay.model.Report;

public interface SpecificDao {

	List<Report> getLogReportGroupByMemberAndMonth(Long userId, List<Long> logTypeIds, Date from, Date to);

	List<Report> getLogReportGroupByMemberAndYear(Long userId, List<Long> logTypeIds, Date from, Date to);

	List<Report> getLogReportGroupByMemberAndDay(Long userId, List<Long> logTypeIds, Date from, Date to);

	List<Report> getLogReportGroupByTypeAndDay(Long userId, List<Long> logTypeIds, Date from, Date to);

	List<Report> getLogReportGroupByTypeAndMonth(Long userId, List<Long> logTypeIds,
			Date from, Date to);

	List<Report> getLogReportGroupByTypeAndYear(Long userId, List<Long> logTypeIds, Date from, Date to);

}
