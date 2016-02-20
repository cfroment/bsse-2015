package org.frou.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Corentin on 17-novembre-14.
 */
public class SetupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetupService.class);

    private static final String DATABASE_NAME = "bsse_db";
    private static final String USER = "bsse2015";
    private static final String DRIVER = "org.h2.Driver";
    private static final String USER_HOME = System.getProperty("user.home");

    public void startSetup() {

        LOGGER.info(USER_HOME + File.separator + DATABASE_NAME);

        if (new File(USER_HOME + File.separator + DATABASE_NAME).exists() ||
                new File(USER_HOME + File.separator + DATABASE_NAME + ".h2.db").exists()) {
            LOGGER.info("Database exists. Will not be created ...");
        } else {
            setupDatabase();
        }
    }

    private void setupDatabase() {
        String url = "jdbc:h2:tcp://localhost/" + USER_HOME + File.separator + DATABASE_NAME;
        LOGGER.info("Creation of the database with URL: {}", url);
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, USER, null);
            LOGGER.info("... connection created!");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("... Database created!");
    }
}
