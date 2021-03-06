package com.ak.oa.service;

import java.util.List;

import com.ak.oa.domain.Calendar;
import com.github.pagehelper.Page;

public interface ICalendarService {
	
	public Calendar get(String id);

	public List<Calendar> findList(Calendar calendar);

	public Page<Calendar> findPage(Page<Calendar> page, Calendar calendar);

	public void save(Calendar calendar);

	public void delete(Calendar calendar);

}
