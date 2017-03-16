package org.arquillian.example;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.vikings.ragnar.entities.FailureClassEntity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(Arquillian.class)
public class FailureClassPersistenceTest
{
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(FailureClassEntity.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private static final String[] FAILURE_CLASS_DESCRIPTIONS = {
            "Warning",
            "Caution",
            "Error"
    };

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    // tests go here
    @Before
    public void preparePersistenceTest() throws Exception {
        clearData();
        insertData();
        startTransaction();
    }

    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Dumping old records...");
        em.createQuery("delete from FailureClassEntity ").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        int counter = 10;
        System.out.println("Inserting records...");
        for (String title : FAILURE_CLASS_DESCRIPTIONS) {
            FailureClassEntity fce = new FailureClassEntity(counter,title);
            em.persist(fce);
            counter++;
        }
        utx.commit();
        // clear the persistence context (first-level cache)
        em.clear();
    }

    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }

    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }

    @Test
    public void shouldFindAllGamesUsingJpqlQuery() throws Exception {
        // given
        String fetchingAllGamesInJpql = "select g from FailureClassEntity g order by g.id";

        // when
        System.out.println("Selecting (using JPQL)...");
        List<FailureClassEntity> games = em.createQuery(fetchingAllGamesInJpql, FailureClassEntity.class).getResultList();

        // then
        System.out.println("Found " + games.size() + " games (using JPQL):");
        assertContainsAllGames(games);
    }

    private void assertContainsAllGames(List<FailureClassEntity> failureClass) {

        Assert.assertEquals(FAILURE_CLASS_DESCRIPTIONS.length, failureClass.size());
        final Set<String> retrievedFailureClassDescriptions = new HashSet<String>();
        for (FailureClassEntity f : failureClass) {
            System.out.println("* " + f);
            retrievedFailureClassDescriptions.add(f.getDescription());
        }
        Assert.assertTrue(retrievedFailureClassDescriptions.containsAll(Arrays.asList(FAILURE_CLASS_DESCRIPTIONS)));
    }
}