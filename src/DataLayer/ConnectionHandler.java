/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Innes Herbst
 */
public abstract class ConnectionHandler {

    private Connection dbConnection;
    private String dbURL;

    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public ConnectionHandler() {

        dbURL = "jdbc:sqlserver://localhost:1433;databasename=dbTest;integratedSecurity=true;";

        try {
            dbConnection = DriverManager.getConnection(dbURL);

            if (!dbConnection.isValid(0)) {
                throw new DatabaseConnectionException("Database Could Not Connect");
            }

            dbConnection.close();

        } catch (DatabaseConnectionException dce) {
            System.out.println(dce.getMessage());
            System.exit(0);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            System.exit(0);
        }

    }

    public boolean ConnectDatabase() {

        try {
            setDbConnection(DriverManager.getConnection(getDbURL()));

            if (!getDbConnection().isValid(0)) {
                throw new DatabaseConnectionException("Database Could Not Connect");
            }

        } catch (DatabaseConnectionException dce) {
            System.out.println(dce.getMessage());
            return false;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        }

        return true;
    }

    public boolean DisconnectDatabase() {
        try {
            getDbConnection().close();

            if (!getDbConnection().isClosed()) {
                throw new DatabaseConnectionException("Database not closed");
            }

        } catch (DatabaseConnectionException dce) {
            System.out.println(dce.getMessage());
            return false;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        }

        return true;
    }

}

class DatabaseConnectionException extends Exception {

    public DatabaseConnectionException(String message) {
        super(message);
    }

}
