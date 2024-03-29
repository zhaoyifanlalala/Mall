package club.banyuan.mall.dto;

import club.banyuan.mall.common.model.UmsAdmin;

import java.util.List;

public class UmsAdminListResponse {
    private Integer pageSize;

    private Integer pageNum;

    private Integer totalPage;

    private Integer total;

    private List<UmsAdmin> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<UmsAdmin> getList() {
        return list;
    }

    public void setList(List<UmsAdmin> list) {
        this.list = list;
    }
}
