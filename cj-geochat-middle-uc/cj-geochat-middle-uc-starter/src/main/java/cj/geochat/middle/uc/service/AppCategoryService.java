package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.AppCategoryDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.AppCategoryMapper;
import cj.geochat.middle.uc.model.AppCategory;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppCategoryService implements IAppCategoryService {
    @Autowired
    AppCategoryMapper categoryMapper;

    @Transactional
    @Override
    public String createCategory(String code, String name, int order, String desc) {
        AppCategory category = new AppCategory();
        category.setId(UlidCreator.getUlid().toLowerCase());
        category.setOrder(order);
        category.setCateCode(code);
        category.setCateName(name);
        category.setCateDesc(desc);
        categoryMapper.insertSelective(category);
        return category.getId();
    }

    @Transactional
    @Override
    public void removeCategory(String id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public AppCategory getCategory(String id) {
        return categoryMapper.selectByPrimaryKey(id).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<AppCategory> listCategory() {
        return categoryMapper.select(c -> c
                .orderBy(AppCategoryDynamicSqlSupport.order)
        );
    }

    @Transactional
    @Override
    public void setOrder(String id, int order) {
        categoryMapper.update(c -> c
                .set(AppCategoryDynamicSqlSupport.order).equalTo(order)
                .where(AppCategoryDynamicSqlSupport.id, SqlBuilder.isEqualTo(id))
        );
    }
}
