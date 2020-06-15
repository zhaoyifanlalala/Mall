package club.banyuan.mall.service;
import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.dao.param.AdminQueryParam;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminListResponse;
import club.banyuan.mall.dto.UmsAdminRoleUpdateParam;
import club.banyuan.mall.dto.UmsAdminUpdatePasswordParam;
import club.banyuan.mall.exception.CommonException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);
    /**
     * 登录
     */
    String login(String username, String password);

    /**
     * 根据用户名加载用户
     */
    UserDetails loadUserByUsername(String username);
    /**
     * 创建用户
     */
    void createUser(UmsAdminCreateParam param) throws CommonException;

    /**
     * 用户分页查询
     */
    UmsAdminListResponse list(AdminQueryParam param);

    /**
     * 管理员修改指定用户的密码
     */
    void updatePassword(UmsAdminUpdatePasswordParam param) throws CommonException;

    /**
     * 更新用户的角色
     */
    @Transactional
    void roleUpdate(UmsAdminRoleUpdateParam param);

}
