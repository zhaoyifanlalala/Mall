package club.banyuan.mall.dto;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class UmsAdminRoleUpdateParam {

    @NotEmpty
    private Long adminId;

    @NotEmpty
    private List<Long> roleIds;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}