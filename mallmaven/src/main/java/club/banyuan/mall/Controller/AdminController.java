package club.banyuan.mall.Controller;
import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.api.ResultCode;
import club.banyuan.mall.common.model.UmsRole;
import club.banyuan.mall.dao.param.AdminQueryParam;
import club.banyuan.mall.dto.*;
import club.banyuan.mall.exception.CommonException;
import club.banyuan.mall.service.UmsAdminService;
import club.banyuan.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "AdminController", description = "管理员相关接口")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation(value = "登录(返回 token)", notes = "登录接口备注")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UmsAdminCreateParam param) {
        try {
            adminService.createUser(param);
            return CommonResult.success("OK");
        } catch (CommonException e) {
            // e.printStackTrace();
            return CommonResult.failed(ResultCode.BUSINESS_FAILED, e.getMessage());
        }
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "用户列表")
    public CommonResult list(
            @ApiParam(name = "keyword", value = "关键词") @RequestParam(value = "keyword",required = false) String keyword,
            @ApiParam(name = "pageSize",value = "每页多少条") @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @ApiParam(name = "pageNum", value = "页码", required = false) @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        AdminQueryParam param = new AdminQueryParam();
        if (!StringUtils.isEmpty(keyword)){
            param.setKeyword('%' + keyword + '%');
        }
        param.setPageNum(pageNum);
        param.setPageSize(pageSize);
        UmsAdminListResponse response = adminService.list(param);
        return CommonResult.success(response);
    }

    @ApiOperation(value = "修改指定用户密码")
    @PostMapping(value = "/updatePassword")
    public CommonResult upatePassword(@RequestBody UmsAdminUpdatePasswordParam param){
        try {
            adminService.updatePassword(param);
            return CommonResult.success("OK");
        } catch (CommonException e) {
            return CommonResult.failed(ResultCode.BUSINESS_FAILED, e.getMessage());
        }
    }

    @ApiOperation(value = "修改用户的角色")
    @PostMapping(value = "/role/update")
    public CommonResult roleUpdate(@RequestBody UmsAdminRoleUpdateParam param){
        adminService.roleUpdate(param);
        return CommonResult.success("OK");
    }

    @Autowired
    private UmsRoleService roleService;

    @GetMapping(value = "/role/{adminId}")
    @ApiOperation(value = "查询用户角色列表")
    public CommonResult roles(@ApiParam(name = "adminId", value = "管理员ID") @PathVariable(value = "adminId") Long adminId) {
        List<UmsRole> roles = roleService.getRolesByAdminId(adminId);
        return CommonResult.success(roles);
    }
}
