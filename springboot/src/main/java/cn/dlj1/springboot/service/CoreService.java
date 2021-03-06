package cn.dlj1.springboot.service;

import java.util.List;
import java.util.Map;

import cn.dlj1.springboot.dao.CoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoreService {

	@Autowired
	private CoreDao dao;
	
	public List<Map<String, Object>> get(){
		List<Map<String, Object>> list2 = dao.getList();
		return list2;
	}
	
	@Cacheable(value="demo",key="'demoInfo_'+#id")
	public Map<String, Object> getOne(int id){
		return dao.getOne(id);
	}
	
	public void add(){
		dao.add();
		throw new RuntimeException();
	}
}
