package controller;

import db.util.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import models.Post;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/post")
public class PostController {
    @RequestMapping("/create")
    public String asd(Model theModel)
    {  theModel.addAttribute("posts",new Post());
        return "CreatePostForm";
    }


    @RequestMapping("/delete/{id}")
    public String  delete(@PathVariable("id")int id)
    {  Post p;
      SessionFactory sessionFactory=new DBConnection().getConnection();
      Session session=sessionFactory.openSession();
      session.getTransaction().begin();
         p=session.find(Post.class,id);
        session.delete(p);
      session.getTransaction().commit();

    return "deleteConfirm";

    }


    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id")int id)
    {
        Post p;
        SessionFactory sessionFactory=new DBConnection().getConnection();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
         p=session.find(Post.class,id);
        session.getTransaction().commit();

          ModelAndView mv=new ModelAndView();
          mv.setViewName("update");
          mv.addObject("post",p);

        return mv;


    }
    @RequestMapping("/updateCommit/{id}")
    String updateCommit(HttpServletRequest request,@PathVariable("id")int id)
    {
        Post p;

        String title =request.getParameter("title");
        String content =request.getParameter("content");


        SessionFactory sessionFactory=new DBConnection().getConnection();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        p=session.find(Post.class,id);
        p.setTitle(title);
        p.setContent(content);
        session.update(p);


        session.getTransaction().commit();
        session.close();

        return "updateConfirm";
    }



    @RequestMapping("/savePost")
    String insert(HttpServletRequest request)
    {
        Post p=new Post();

        String title =request.getParameter("title");
        String content =request.getParameter("content");

        p.setTitle(title);

        p.setContent(content);

        SessionFactory sessionFactory=new DBConnection().getConnection();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        session.save(p);
        session.getTransaction().commit();
        session.close();

        return "createConfirm";
    }


    @RequestMapping("/show/{id}")
    public String display(@PathVariable("id") String id)
    {
        System.out.println(id);
        return "showPosts";
    }
}
