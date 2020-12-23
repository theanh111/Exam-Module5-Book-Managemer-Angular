package service;

import model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl implements IBrandService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/skateshop?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "TheanHtran111@";

    private static final String SELECT_ALL_BRAND_SQL = "{CALL selectAllBrandSQL()}";

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
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_BRAND_SQL)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String brandId = rs.getString("brandId");
                String brandName = rs.getString("brandName");
                String brandAddress = rs.getString("brandAddress");
                brands.add(new Brand(brandId, brandName, brandAddress));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brands;
    }
}
