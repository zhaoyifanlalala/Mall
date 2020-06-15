package club.banyuan.mall.service;

import club.banyuan.mall.common.mapper.UmsMenuMapper;
import club.banyuan.mall.common.model.UmsMenu;
import club.banyuan.mall.common.model.UmsMenuExample;
import club.banyuan.mall.dto.MenuNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private UmsMenuMapper menuMapper;

    @Override
    public void create(UmsMenu menu) {
        menu.setCreateTime(new Date());
        menuMapper.insert(menu);
    }

    @Override
    public List<MenuNode> getTreeList() {
        List<UmsMenu> menus = menuMapper.selectByExample(new UmsMenuExample());

        List<MenuNode> baseMenu = new ArrayList<>();
        for (UmsMenu menu : menus) {
            if (menu.getParentId() == 0L) {
                baseMenu.add(convertMenu2MenuNode(menu, menus));
            }
        }
        return baseMenu;
    }

    private MenuNode convertMenu2MenuNode(UmsMenu menu, List<UmsMenu> menus) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);

        List<MenuNode> children = new ArrayList<>();
        for (UmsMenu _m : menus) {
            if (_m.getParentId().equals(menu.getId())) {
                children.add(convertMenu2MenuNode(_m, menus));
            }
        }
        node.setChildren(children);
        return node;
    }
}