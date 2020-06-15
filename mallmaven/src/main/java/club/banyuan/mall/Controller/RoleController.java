package club.banyuan.mall.Controller;

import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.model.UmsRole;
import club.banyuan.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "RoleController", description = "管理员相关接口")
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation(value = "创建角色")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UmsRole role){
        roleService.create(role);
        return CommonResult.success("OK");
    }
}
