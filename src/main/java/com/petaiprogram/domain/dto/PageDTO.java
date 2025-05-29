package com.petaiprogram.domain.dto;

import com.petaiprogram.domain.Guesslike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class PageDTO<T> {
//    分页数据
    private List<T> items;
//    当前第几页
    private long page;
//    一页有多少数据
    private long pageSize;

    //    数据的总条数
    private long counts;
    //    总页数
    private long pages;

    public PageDTO(List<T> items, long page, long pageSize, long counts, long pages) {
        this.items = items;
        this.page = page;
        this.pageSize = pageSize;
        this.counts = counts;
        this.pages = pages;
    }

    public PageDTO() {
    }

    public PageDTO(List<Guesslike> records, long total, long pages) {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCounts() {
        return counts;
    }

    public void setCounts(long counts) {
        this.counts = counts;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
    


}
