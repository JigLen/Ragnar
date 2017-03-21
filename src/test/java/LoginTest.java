import com.vikings.ragnar.entities.UserEntity;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;


/**
 * Created by C07589301 on 08/03/2017.
 */
@RunWith(Arquillian.class)
public class LoginTest
{

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserEntity.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    UserEntity loginBean;

    @Test
    public void login_mary()
    {
        String loginResponse = loginBean.Login(45, "ssss");
        Assert.assertEquals("Id:" + 45 + " " + "Password:ssss", loginResponse);
    }
}