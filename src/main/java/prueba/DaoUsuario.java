/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class DaoUsuario {
   public void insertar(Usuario u){
       SessionFactory sf = HibernateUtil.getSessionFactory();
       Session sesion = sf.openSession();
       Transaction t = sesion.beginTransaction();
       sesion.save(u);
       t.commit();
       sesion.close();
   } 
   public List<Usuario> buscar(){
      SessionFactory sf = HibernateUtil.getSessionFactory();
       Session sesion = sf.openSession();
       Transaction t = sesion.beginTransaction();
       List<Usuario> usuarios = sesion.createCriteria(Usuario.class).list();
              t.commit();
               sesion.close();
               return usuarios;
   }
   public Usuario buscarId(Integer id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
       Session sesion = sf.openSession();
       Transaction t = sesion.beginTransaction();
       Usuario u =(Usuario) sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id)).uniqueResult();
       t.commit();
       sesion.close();
          return u;
   }
   public void eliminar(Integer id ){
       SessionFactory sf = HibernateUtil.getSessionFactory();
       Session sesion = sf.openSession();
       Transaction t = sesion.beginTransaction();
       sesion.delete(buscarId(id));
       t.commit();
       sesion.close();
       
               
   }
}
