package net.kyle.rbac_shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class Md5Test {


    @Test
    public void testMD5(){

        String hashName = "md5";

        String pwd = "1234";

        Object result = new SimpleHash(hashName, pwd, null, 2);

        System.out.println(result);


    }

}
