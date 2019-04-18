package com.ak.system.service.oa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.system.domain.oa.Calendar;
import com.ak.system.mapper.oa.CalendarMapper;
import com.github.pagehelper.Page;

@Service
public class CalendarServiceImpl implements ICalendarService {
	
	@Autowired
	private CalendarMapper calendarMapper;

	@Override
	public Calendar get(String id) {
		return calendarMapper.get(id);
	}

	@Override
	public List<Calendar> findList(Calendar calendar) {
		return calendarMapper.findList(calendar);
	}

	@Override
	public Page<Calendar> findPage(Page<Calendar> page, Calendar calendar) {
		return null;//calendarMapper.findPage(page, calendar);
	}

	@Override
	public void save(Calendar calendar) {
		calendarMapper.insert(calendar);
	}

	@Override
	public void delete(Calendar calendar) {
		calendarMapper.delete(calendar);
	}

}
