package controller;

import db.util.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import models.Post;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/")
   public ModelAndView display() {
        List<Post> postList;
        SessionFactory connection = new DBConnection().getConnection();
        Session session = connection.openSession();
          session.getTransaction().begin();

         postList = session.createQuery("from models.Post").list();
         session.getTransaction().commit();
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        mv.addObject("postList", postList);

        return mv;

    }
}
