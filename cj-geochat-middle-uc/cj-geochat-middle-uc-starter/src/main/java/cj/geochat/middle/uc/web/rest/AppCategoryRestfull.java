package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.AppCategory;
import cj.geochat.middle.uc.service.IAppCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/category")
@Api(description = "应用类别管理")
public class AppCategoryRestfull implements IAppCategoryRestfull {
    @Autowired
    IAppCategoryService categoryService;

    @GetMapping("/createCategory")
    @ApiResult
    @ApiOperation("新建类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createCategory(String code, String name, int order, @RequestParam(required = false) String desc) {
        return categoryService.createCategory(code, name, order, desc);
    }

    @GetMapping("/removeCategory")
    @ApiResult
    @ApiOperation("移除类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeCategory(String id) {
        categoryService.removeCategory(id);
    }

    @GetMapping("/getCategory")
    @ApiResult
    @ApiOperation("获取类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppCategory getCategory(String id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/listCategory")
    @ApiResult
    @ApiOperation("列出类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppCategory> listCategory() {
        return categoryService.listCategory();
    }

    @GetMapping("/setOrder")
    @ApiResult
    @ApiOperation("更新类别顺序")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setOrder(String id, int order) {
        categoryService.setOrder(id, order);
    }
}
