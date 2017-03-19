package uk.co.umbaska.module.access.skript.mysql.types.model;

import java.sql.Connection;

/**
 * @author Andrew Tran
 */
public interface SQLConnection{
    String[] getDatabases();
    Connection getConnection();
}
