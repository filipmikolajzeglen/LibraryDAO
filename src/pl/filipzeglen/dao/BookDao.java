package pl.filipzeglen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.filipzeglen.model.Book;
import pl.filipzeglen.util.ConnectionProvider;

public class BookDao {

    private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(?, ?, ?);";
    private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = ?;";
    private final static String UPDATE = "UPDATE book SET isbn=?, title=?, description=? WHERE isbn = ?;";
    private final static String DELETE = "DELETE FROM book WHERE isbn=?;";

    public void create(Book book) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(CREATE)) {
            prepStmt.setString(1, book.getIsbn());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getDescription());
            prepStmt.executeUpdate();
        }
    }

    public Book read(String isbn) throws SQLException {
        Book resultBook = null;
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(READ);) {
            prepStmt.setString(1, isbn);
            ResultSet resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                resultBook = new Book();
                resultBook.setIsbn(resultSet.getString("isbn"));
                resultBook.setTitle(resultSet.getString("title"));
                resultBook.setDescription(resultSet.getString("description"));
            }
        }
        return resultBook;
    }

    public void update(Book book) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(UPDATE);) {
            prepStmt.setString(1, book.getIsbn());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getDescription());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.executeUpdate();
        }
    }

    public void delete(Book book) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(DELETE);) {
            prepStmt.setString(1, book.getIsbn());
            prepStmt.executeUpdate();
        }
    }
}