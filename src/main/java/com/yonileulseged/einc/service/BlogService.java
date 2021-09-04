package com.yonileulseged.einc.service;

import com.yonileulseged.einc.entity.Blog;
import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    Blog saveBlog(Blog blog);
    Blog getBlogById(Integer blogId);
    Blog editBlog(Blog blog);
    void deleteBlogById(Integer blogId);
}
