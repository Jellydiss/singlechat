package org.jellydiss.singlechat.common.config.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TestRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<HibernateTestConfigVO> getAllTest() {
		return this.hibernateTemplate.loadAll(HibernateTestConfigVO.class);
	}

	public Integer createTest(HibernateTestConfigVO hibernateTestConfigVO) {
		HibernateTestConfigVO mergeHibernateTestConfigVO = this.hibernateTemplate
				.merge(hibernateTestConfigVO);
		return mergeHibernateTestConfigVO.getId();
	}
}
