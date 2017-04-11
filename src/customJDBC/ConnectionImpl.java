package customJDBC;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Implements java.sql.Connection Creates Statement with underlying connection
 * object
 */
public class ConnectionImpl implements java.sql.Connection {

    Connection dbConnection;

    ConnectionImpl(Connection dbConn) {
        dbConnection = dbConn;
    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        return dbConnection.isWrapperFor(arg0);
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        return dbConnection.unwrap(arg0);
    }

    @Override
    public void abort(Executor arg0) throws SQLException {
        dbConnection.abort(arg0);

    }

    @Override
    public void clearWarnings() throws SQLException {
        dbConnection.clearWarnings();
    }

    @Override
    public void close() throws SQLException {
        dbConnection.close();

    }

    @Override
    public void commit() throws SQLException {
        dbConnection.commit();
    }

    @Override
    public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
        return dbConnection.createArrayOf(arg0, arg1);
    }

    @Override
    public Blob createBlob() throws SQLException {
        return dbConnection.createBlob();
    }

    @Override
    public Clob createClob() throws SQLException {
        return dbConnection.createClob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return dbConnection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return dbConnection.createSQLXML();
    }

    @Override
    public Statement createStatement() throws SQLException {
        System.out.println("createStatement");
        StatementImpl statement = new StatementImpl(dbConnection.createStatement());
        return statement;
    }

    @Override
    public Statement createStatement(int arg0, int arg1) throws SQLException {
        return dbConnection.createStatement(arg0, arg1);
    }

    @Override
    public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
        return dbConnection.createStatement(arg0, arg1, arg2);
    }

    @Override
    public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
        return dbConnection.createStruct(arg0, arg1);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return dbConnection.getAutoCommit();
    }

    @Override
    public String getCatalog() throws SQLException {
        return dbConnection.getCatalog();
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return dbConnection.getClientInfo();
    }

    @Override
    public String getClientInfo(String arg0) throws SQLException {
        return dbConnection.getClientInfo(arg0);
    }

    @Override
    public int getHoldability() throws SQLException {
        return dbConnection.getHoldability();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return dbConnection.getMetaData();
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return dbConnection.getNetworkTimeout();
    }

    @Override
    public String getSchema() throws SQLException {
        return dbConnection.getSchema();
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return dbConnection.getTransactionIsolation();
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return dbConnection.getTypeMap();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return dbConnection.getWarnings();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return dbConnection.isClosed();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override
    public boolean isValid(int arg0) throws SQLException {
        return dbConnection.isValid(arg0);
    }

    @Override
    public String nativeSQL(String arg0) throws SQLException {
        return dbConnection.nativeSQL(arg0);
    }

    @Override
    public CallableStatement prepareCall(String arg0) throws SQLException {
        return dbConnection.prepareCall(arg0);
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
        return dbConnection.prepareCall(arg0, arg1, arg2);
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        return dbConnection.prepareCall(arg0, arg1, arg2, arg3);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0) throws SQLException {
        return dbConnection.prepareStatement(arg0);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
        return dbConnection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
        return dbConnection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
        return dbConnection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
        return dbConnection.prepareStatement(arg0, arg1, arg2);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        return dbConnection.prepareStatement(arg0, arg1, arg2, arg3);
    }

    @Override
    public void releaseSavepoint(Savepoint arg0) throws SQLException {
        dbConnection.releaseSavepoint(arg0);
    }

    @Override
    public void rollback() throws SQLException {
        dbConnection.rollback();
    }

    @Override
    public void rollback(Savepoint arg0) throws SQLException {
        dbConnection.rollback(arg0);
    }

    @Override
    public void setAutoCommit(boolean arg0) throws SQLException {
        dbConnection.setAutoCommit(arg0);
    }

    @Override
    public void setCatalog(String arg0) throws SQLException {
        dbConnection.setCatalog(arg0);
    }

    @Override
    public void setClientInfo(Properties arg0) throws SQLClientInfoException {
        dbConnection.setClientInfo(arg0);
    }

    @Override
    public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
        dbConnection.setClientInfo(arg0, arg1);
    }

    @Override
    public void setHoldability(int arg0) throws SQLException {
        dbConnection.setHoldability(arg0);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        dbConnection.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        dbConnection.setReadOnly(readOnly);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return dbConnection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return dbConnection.setSavepoint(name);

    }

    @Override
    public void setSchema(String schema) throws SQLException {
        dbConnection.setSchema(schema);
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        dbConnection.setTransactionIsolation(level);
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        dbConnection.setTypeMap(map);
    }

}
