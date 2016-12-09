package com.jg2b.seoBrand.dao;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.jg2b.seoDto.CompanyDto;

public class KindDaoTest extends BaseDaoTest{
	
	@Autowired
	private BrandKindDao brandKindDao;

	/***
	 * @function 查询当前分类 分类供应商
	 * @throws Exception
	 * @author gongjp
	 * @date 2016.06.29 18:11:21
	 */
	@Test
	public void testQueryCompanyUpKind() throws Exception{
		 List<CompanyDto> list = brandKindDao.queryCompanyUpKind("dd3a823ac41e475e987306ff3cf0f56f",1,10);
		 if(CollectionUtils.isNotEmpty(list)){
			for (CompanyDto companyDto : list) {
				System.out.println(companyDto.getCompanyName());
			} 
		 }
	}
	/***
	 * @function 查询当前分类 分类供应商数量
	 * @throws Exception
	 * @author gongjp
	 * @date 2016.06.29 18:11:21
	 */
	@Test
	public void testQueryCompanyUpKindCount() throws Exception{
         int count = brandKindDao.queryCompanyUpKindCounts("dd3a823ac41e475e987306ff3cf0f56f");
				System.out.println(count);
		 }
}
