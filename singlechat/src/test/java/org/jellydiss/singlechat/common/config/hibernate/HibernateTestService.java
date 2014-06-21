package org.jellydiss.singlechat.common.config.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HibernateTestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<HibernateTestConfigVO> getAllTest(){
		return this.testRepository.getAllTest();
	}
	
	public Integer createTest(HibernateTestConfigVO hibernateTestConfigVO){
		return this.testRepository.createTest(hibernateTestConfigVO);
	}
}
