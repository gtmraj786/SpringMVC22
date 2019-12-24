package db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Post;

public class DBConnection
{
   public SessionFactory getConnection()
   {
        Configuration con=new Configuration().configure().addAnnotatedClass(Post.class);//.addAnnotatedClass(SomeClassName.class);

        SessionFactory sessionFactory=con.buildSessionFactory();
        Session session=sessionFactory.openSession();

       return sessionFactory;
    }
}
