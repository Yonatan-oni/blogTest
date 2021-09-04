package com.yonileulseged.einc.service.impl;

import com.yonileulseged.einc.entity.Blog;
import com.yonileulseged.einc.repository.BlogRepository;
import com.yonileulseged.einc.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        super();
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Integer blogId) {
        return blogRepository.findById(blogId).get();
    }

    @Override
    public Blog editBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Integer blogId) {
        blogRepository.deleteById(blogId);
    }
}
