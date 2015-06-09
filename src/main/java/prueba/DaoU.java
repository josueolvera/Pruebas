/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.List;
import org.hibernate.*;

/**
 *
 * @author JOSUE
 */
public class DaoU {
    public void insertar(Usuario u){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        s.save(u);
        t.commit();
        s.close();
    }
    public List<Usuario> leer(){
      SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("* from usuario");
        List<Usuario> lista = q.list();
         t.commit();
        s.close();
        return lista;
    }
    
    public Usuario buscar(Integer id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Usuario u = (Usuario) s.get(Usuario.class, id);
        t.commit();
        s.close();
        return u;
    }
    
    public void borrar (Integer id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Usuario u = (Usuario) s.get(Usuario.class, id);
        s.delete(u);
        t.commit();
        s.close();
    }
}
