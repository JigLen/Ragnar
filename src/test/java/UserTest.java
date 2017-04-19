import com.vikings.ragnar.daos.UserDao;
import com.vikings.ragnar.daos.UserDaoImp;
import com.vikings.ragnar.entities.UserEntity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 11-Apr-17.
 */

@RunWith(Arquillian.class)
public class UserTest {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImp.class.getName());

    @Inject
    private UserDaoImp service;

    @Deployment
    //public static JavaArchive createDeployment() {
    public static JavaArchive createTestableDeployment() {
       //return ShrinkWrap.create(JavaArchive.class)
        //        .addClasses(UserEntity.class,  UserDaoImp.class)
        //        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");


        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "example.jar")
                .addClasses(UserEntity.class, UserDao.class, UserDaoImp.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                // Enable CDI
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
        LOGGER.info(jar.toString(Formatters.VERBOSE));
        return jar;

    }

    @Test
    public void callServiceToAddNewUserToDB() {
        final UserEntity user = new UserEntity(100,"King", 3,"Customer Rep");
        service.addUser(user);
        assertEquals(java.util.Optional.of(100), user.getUserId());
    }

}
