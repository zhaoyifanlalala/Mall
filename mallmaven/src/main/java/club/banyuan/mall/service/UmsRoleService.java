package club.banyuan.mall.service;

import club.banyuan.mall.common.model.UmsRole;

import java.util.List;

public interface UmsRoleService {
    /**
     * 创建角色
     */
    void create(UmsRole role);

    /**
     * 查询一个用户的所有角色
     */
    List<UmsRole> getRolesByAdminId(Long adminId);

    /**
     * 查询一个用户的所有角色
     */
    List<UmsRole> findRolesByAdminId(Long adminId);

}
