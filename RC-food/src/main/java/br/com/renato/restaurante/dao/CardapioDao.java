package br.com.renato.restaurante.dao;

import br.com.renato.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorID(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public Cardapio consultarPorNome(String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).
                    setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public List<Cardapio> consultarPorValor(BigDecimal filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class)
                    .setParameter("valor", filtro).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarTodos(){
        try {
            String jpql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
        }catch(Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
