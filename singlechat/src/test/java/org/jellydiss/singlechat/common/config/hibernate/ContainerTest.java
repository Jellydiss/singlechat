package org.jellydiss.singlechat.common.config.hibernate;

import java.util.List;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


public class ContainerTest {

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("org.jellydiss");
		ctx.refresh();

		System.out.println(ctx);

		HibernateTestService hibernateTestService = ctx.getBean(
				"hibernateTestService", HibernateTestService.class);

		List<HibernateTestConfigVO> allTest = hibernateTestService.getAllTest();
		for (HibernateTestConfigVO h : allTest) {
			System.out.println(h);
		}

		HibernateTestConfigVO hibernateTestConfigVO = new HibernateTestConfigVO(
				1, "KasdfK");
		
		Integer id = hibernateTestService.createTest(hibernateTestConfigVO);
		System.out.println("newly test id = " +id);
		allTest = hibernateTestService.getAllTest();
		for(HibernateTestConfigVO h : allTest){
			System.out.println(h);
		}
				
	}

}
