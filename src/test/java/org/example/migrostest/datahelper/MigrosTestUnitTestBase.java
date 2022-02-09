package org.example.migrostest.datahelper;

import java.security.SecureRandom;
import java.util.UUID;

/**
 *
 * @author IS96844
 *
 */
public abstract class MigrosTestUnitTestBase  {

    static {
        setupFactories();
    }

    private static SecureRandom random;

    protected static MigrosTestDTOFactory dtoFactory;

    protected static MigrosTestDOFactory doFactory;

    private static void setupFactories() {
        random = new SecureRandom(UUID.randomUUID().toString().getBytes());

        dtoFactory = new MigrosTestDTOFactory(random);
        doFactory = new MigrosTestDOFactory(random);

    }
}
