package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.AppCategory;
import cj.geochat.uc.middle.service.IAppCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/category")
@Tag(name = "应用类别管理")
public class AppCategoryRestfull implements IAppCategoryRestfull {
    @Autowired
    IAppCategoryService categoryService;

    @GetMapping("/createCategory")
    @ApiResult
    @Operation(summary = "新建类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createCategory(String code, String name, int order, @RequestParam(required = false) String desc) {
        return categoryService.createCategory(code, name, order, desc);
    }

    @GetMapping("/removeCategory")
    @ApiResult
    @Operation(summary = "移除类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeCategory(String id) {
        categoryService.removeCategory(id);
    }

    @GetMapping("/getCategory")
    @ApiResult
    @Operation(summary = "获取类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppCategory getCategory(String id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/listCategory")
    @ApiResult
    @Operation(summary = "列出类别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppCategory> listCategory() {
        return categoryService.listCategory();
    }

    @GetMapping("/setOrder")
    @ApiResult
    @Operation(summary = "更新类别顺序")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setOrder(String id, int order) {
        categoryService.setOrder(id, order);
    }
}
