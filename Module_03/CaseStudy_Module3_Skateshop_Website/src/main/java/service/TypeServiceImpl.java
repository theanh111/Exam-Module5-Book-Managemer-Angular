package service;

import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceImpl implements ITypeService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/skateshop?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "TheanHtran111@";

    private static final String SELECT_ALL_TYPE_SQL = "{CALL selectAllTypeSQL()}";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_TYPE_SQL)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String typeId = rs.getString("typeId");
                String typeName = rs.getString("typeName");
                String typeStatus = rs.getString("typeStatus");
                types.add(new Type(typeId, typeName, typeStatus));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return types;
    }
}
