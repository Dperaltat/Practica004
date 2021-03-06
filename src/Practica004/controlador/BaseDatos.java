/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Actor;
import Practica004.modelo.Pelicula;
import Practica004.modelo.Reseña;
import Practica004.modelo.Rol;
import Practica004.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author johne
 */
public class BaseDatos
{
    
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("Practica004PU");


      public boolean insertarPersona(Actor p)
    {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        retorno=true;
        return retorno;
    }
        public boolean insertarRol(Rol p)
    {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        retorno=true;
        return retorno;
    }
      
      public boolean insertarUsuario(Usuario u)
    {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        retorno=true;
        return retorno;
    }
      
      public boolean insertarPelicula(Pelicula p)
    {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        retorno=true;
        return retorno;
    }
      public boolean insertarReseña (Reseña p)
    {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        retorno=true;
        return retorno;
    }
      
      
       public List<Actor> leerPersona()
    {
        List<Actor> retorno=null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno=em.createQuery("SELECT p FROM Actor p ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno;
    
    }
       
       public List<Usuario> leerUsuario()
    {
        List<Usuario> retorno=null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno=em.createQuery("SELECT p FROM Usuario p ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno;
    
    }
         public List<Rol> leerRol()
    {
        List<Rol> retorno=null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno=em.createQuery("SELECT p FROM Rol p ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno;
    
    }
    
    public List<Reseña> leerReseña()
    {
        List<Reseña> retorno=null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno=em.createQuery("SELECT p FROM Reseña p ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno;
    
    }
    
        public List<Pelicula> leerPelicula()
    {
        List<Pelicula> retorno=null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        retorno=em.createQuery("SELECT p FROM Rol p ORDER BY p.id").getResultList();
        em.getTransaction().commit();
        return retorno;
    
    }
}
