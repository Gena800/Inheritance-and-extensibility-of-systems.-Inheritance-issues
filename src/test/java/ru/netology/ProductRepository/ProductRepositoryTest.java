package ru.netology.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Product one = new Book(1, "Дюна", 500, "Фрэнк Герберт");
    Product two = new Book(2, "Текст", 400, "Дмитрий глуховский");
    Product three = new Book(3, "Первому игроку приготовиться", 550, "Эрнест Клайн");
    Product four = new Smartphone(4, "Nokia", 10_000, "Финляндия");

    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
    }

    @Test
    public void shouldAddNewMovieAndFindAll() {
        Product[] expected = {one, two, three, four};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(3);
        Product[] expected = {one, two, four};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}