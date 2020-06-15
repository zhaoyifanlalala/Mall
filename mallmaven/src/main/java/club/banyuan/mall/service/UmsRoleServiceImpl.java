package club.banyuan.mall.service;
import club.banyuan.mall.common.mapper.UmsAdminRoleRelationMapper;
import club.banyuan.mall.common.mapper.UmsRoleMapper;
import club.banyuan.mall.common.model.UmsAdminRoleRelation;
import club.banyuan.mall.common.model.UmsAdminRoleRelationExample;
import club.banyuan.mall.common.model.UmsRole;
import club.banyuan.mall.common.model.UmsRoleExample;
import club.banyuan.mall.dao.UmsAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper roleMapper;

    @Autowired
    private UmsAdminRoleRelationMapper relationMapper;
    @Override
    public void create(UmsRole role) {
        role.setCreateTime(new Date());
        roleMapper.insert(role);
    }

    @Override
    public List<UmsRole> getRolesByAdminId(Long adminId) {
        UmsAdminRoleRelationExample relationExample = new UmsAdminRoleRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        List<UmsAdminRoleRelation> relations = relationMapper.selectByExample(relationExample);

        // 取出所有的角色 ID
        List<Long> roleIds = new ArrayList<>();
        for (UmsAdminRoleRelation relation : relations) {
            roleIds.add(relation.getRoleId());
        }

        // 查出所有的角色
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(roleIds);
        return roleMapper.selectByExample(example);
    }

    @Autowired
    private UmsAdminDao adminDao;

    @Override
    public List<UmsRole> findRolesByAdminId(Long adminId) {
        return adminDao.findRolesByAdminId(adminId);
    }

}