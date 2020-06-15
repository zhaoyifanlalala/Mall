package club.banyuan.mall.Controller;
import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.model.UmsMenu;
import club.banyuan.mall.dto.MenuNode;
import club.banyuan.mall.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "MenuController", description = "菜单相关接口")
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "创建菜单")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UmsMenu role) {
        menuService.create(role);
        return CommonResult.success("OK");
    }

    @ApiOperation(value = "菜单树形结构")
    @GetMapping(value = "/treeList")
    public CommonResult treeList() {
        List<MenuNode> nodes = menuService.getTreeList();
        return CommonResult.success(nodes);
    }
}