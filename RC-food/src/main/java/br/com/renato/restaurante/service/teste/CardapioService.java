package br.com.renato.restaurante.service.teste;

import br.com.renato.restaurante.dao.CardapioDao;
import br.com.renato.restaurante.util.CargaDeDadosUtil;
import br.com.renato.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRCfood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("O produto pesquisado foi: " + cardapioDao.consultarPorNome("moqueca"));
        entityManager.close();
    }
}
