package club.banyuan.mall.Controller;
import club.banyuan.mall.common.api.CommonResult;
import club.banyuan.mall.common.api.ResultCode;
import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminLoginParam;
import club.banyuan.mall.exception.CommonException;
import club.banyuan.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "AdminController", description = "管理员相关接口")
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsAdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "登录(返回 token)", notes = "登录接口备注")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
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
    @ResponseBody
    public CommonResult create(@RequestBody UmsAdminCreateParam param) {
        try {
            adminService.createUser(param);
            return CommonResult.success("OK");
        } catch (CommonException e) {
            // e.printStackTrace();
            return CommonResult.failed(ResultCode.BUSINESS_FAILED, e.getMessage());
        }
    }

    public CommonResult list(@RequestParam )
}
