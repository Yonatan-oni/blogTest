package com.yonileulseged.einc.controller;

import com.yonileulseged.einc.entity.Blog;
import com.yonileulseged.einc.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class BlogController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/blog";
    private String directory = "/blog/";
    private String deleteDirectory = System.getProperty("user.dir") + "/src/main/resources/static";

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/r5i3gn54")

    public String uploadPage(Model model){
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "indexAdmin";
    }

    @GetMapping("/r5i3gn54/newBlog")
    public String createBlogForm(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "createBlog";
    }


    @PostMapping("/r5i3gn54" )
    public String saveBlog(@RequestParam("blogFile")MultipartFile file,
                           @ModelAttribute("blog")Blog blog
    ){
            Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath,file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        blog.setPath(directory+ file.getOriginalFilename());
        blogService.saveBlog(blog);
        return "redirect:/r5i3gn54";
    }

    @GetMapping("/r5i3gn54/edit/{bolgId}")

    public String editBlogForm(@PathVariable Integer bolgId, Model model){
        model.addAttribute("blog",blogService.getBlogById(bolgId));
        return "edit";
    }
    @PostMapping("/r5i3gn54/{bolgId}")
    public String updateBlog(@RequestParam("blogFile")MultipartFile file,
                             @PathVariable Integer bolgId,
                             @ModelAttribute("blog") Blog blog,
                             Model model){
        Blog blogToBeUpdated = blogService.getBlogById(bolgId);

        Path fileNameAndPathToBeDeleted = Paths.get(deleteDirectory,blogToBeUpdated.getPath());
        try {
            Files.delete(fileNameAndPathToBeDeleted);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        blogToBeUpdated.setBolgId(bolgId);
        blogToBeUpdated.setTitle(blog.getTitle());
        blogToBeUpdated.setPath(directory+ file.getOriginalFilename());
        blogToBeUpdated.setLink(blog.getLink());
        blogToBeUpdated.setContent(blog.getContent());

        blogService.editBlog(blogToBeUpdated);
        return "redirect:/r5i3gn54";
    }

    @GetMapping("/r5i3gn54/{bolgId}")
    public String deleteBlog(@PathVariable Integer bolgId){
        Blog blogToBeDeleted = blogService.getBlogById(bolgId);
        Path fileNameAndPathToBeDeleted = Paths.get(deleteDirectory,blogToBeDeleted.getPath());
        try {
            Files.delete(fileNameAndPathToBeDeleted);
        } catch (IOException e) {
            e.printStackTrace();
        }

        blogService.deleteBlogById(bolgId);

        return "redirect:/r5i3gn54";
    }
}
