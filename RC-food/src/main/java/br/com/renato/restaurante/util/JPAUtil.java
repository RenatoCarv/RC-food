package br.com.renato.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RCFOOD = Persistence.createEntityManagerFactory("RC-food");

    public static EntityManager getEntityManagerRCfood(){
        return RCFOOD.createEntityManager();
    }
}
