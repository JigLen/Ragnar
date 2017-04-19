import com.vikings.ragnar.daos.BaseDataDaoImpl;
import com.vikings.ragnar.entities.BaseDataEntity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

import javax.ejb.EJB;
import javax.xml.registry.infomodel.User;
import java.util.List;

/**
 * Created by User on 11-Apr-17.
 */
public class BaseDataTest extends Arquillian{

    public BaseDataTest(Class<?> testClass) throws InitializationError {
        super(testClass);
    }
/*
    @Deployment
    public static JavaArchive createTestArchive() {

        return ShrinkWrap.create("test.jar", JavaArchive.class)
                .addClasses(BaseDataEntity.class, BaseDataDaoImpl.class)
                .addManifestResource(
                        "test-persistence.xml",
                        ArchivePaths.create("persistence.xml"));

    }

    private static final String FIRST_NAME = "Agent";
    private static final String LAST_NAME = "Kay";


    @EJB
    private BaseDataDaoImpl baseDataDao;


    @Test
    public void testCanPersistUserObject() {

        User u = new User(FIRST_NAME, LAST_NAME);
        userRepository.storeAndFlush(u);
        List<User> users = userRepository.findByLastName(LAST_NAME);
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() == 1);
        Assert.assertEquals(users.get(0).getLastName(), LAST_NAME);
        Assert.assertEquals(users.get(0).getFirstName(), FIRST_NAME);

    }

*/

}
