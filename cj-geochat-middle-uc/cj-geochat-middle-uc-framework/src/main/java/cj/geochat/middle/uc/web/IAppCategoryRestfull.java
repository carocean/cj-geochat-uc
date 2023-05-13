package cj.geochat.middle.uc.web;

import cj.geochat.middle.uc.model.AppCategory;

import java.util.List;

public interface IAppCategoryRestfull {
    String createCategory(String code, String name,int order, String desc);

    void removeCategory(String id);

    AppCategory getCategory(String id);

    List<AppCategory> listCategory();

    void setOrder(String id, int order);

}
