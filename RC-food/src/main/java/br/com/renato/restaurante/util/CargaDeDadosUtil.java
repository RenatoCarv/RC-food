package br.com.renato.restaurante.util;

import br.com.renato.restaurante.dao.CardapioDao;
import br.com.renato.restaurante.dao.CategoriaDao;
import br.com.renato.restaurante.entity.Cardapio;
import br.com.renato.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil(){}

    public static void cadastrarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Pratos Principais");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        entityManager.clear();
    }
    public static void cadastrarProdutosCardapio(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio moqueca = new Cardapio("Moqueca", "Peixe Branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));

        Cardapio spaguetti = new Cardapio("Spaguetti", "Spaguetti ao molho de parmesão e cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));

        Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
                true, BigDecimal.valueOf(59.00), categorias.get(2));

        Cardapio cordeiro = new Cardapio("Cordeiro", "Cordeiro com risoto de funghi",
                true, BigDecimal.valueOf(88.00), categorias.get(2));

        Cardapio burrata = new Cardapio("Burrata", "Tomates queimados, cúcula e torrada",
                true, BigDecimal.valueOf(15.00), categorias.get(0));

        Cardapio bruchetta = new Cardapio("Bruchetta", "Tomates, mussarela e manjericão",
                true, BigDecimal.valueOf(20.00), categorias.get(0));

        Cardapio scappeta = new Cardapio("Scappeta", "Ragu de linguiça e torradinhas",
                true, BigDecimal.valueOf(25.00), categorias.get(0));

        Cardapio caprese = new Cardapio("Caprese", "Mini rucula e mussarela",
                true, BigDecimal.valueOf(47.00), categorias.get(1));

        Cardapio caesar = new Cardapio("Caesar", "Salada de frango com molho ceasar",
                true, BigDecimal.valueOf(40.00), categorias.get(1));

        Cardapio chevre = new Cardapio("Chevre", "Mix de folhas, mostarda e mel",
                true, BigDecimal.valueOf(59.00), categorias.get(1));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(spaguetti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(burrata);
        cardapioDao.cadastrar(bruchetta);
        cardapioDao.cadastrar(scappeta);
        cardapioDao.cadastrar(caprese);
        cardapioDao.cadastrar(caesar);
        cardapioDao.cadastrar(chevre);
        entityManager.getTransaction().commit();
        entityManager.clear();





    }
}


