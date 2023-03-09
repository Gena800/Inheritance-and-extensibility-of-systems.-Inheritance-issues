package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.ProductRepository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product one = new Book(1, "Дюна", 500, "Фрэнк Герберт");
    Product two = new Book(2, "Текст", 400, "Дмитрий глуховский");
    Product three = new Book(3, "Первому игроку приготовиться", 550, "Эрнест Клайн");
    Product four = new Smartphone(4, "Nokia", 10_000, "Финляндия");
    Product five = new Book(5, "Дюна2", 600, "Фрэнк Герберт");


    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
    }

    @Test
    public void shouldAddProduct() {
        Product[] expected = {one, two, three, four, five};
        Product[] actual = repo.findAll();
    }

    @Test
    public void shouldFindByName() {
        Product[] expected = {four};
        Product[] actual = manager.searchBy("Nokia");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameSmartphone() {
        Product[] expected = {two};
        Product[] actual = manager.searchBy("Текст");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameIfTwo() {
        Product[] expected = {one, five};
        Product[] actual = manager.searchBy("Дюна");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Крокодил");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthor() {
        Product[] expected = {two};
        Product[] actual = manager.searchBy("Дмитрий");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindByManufacturer() {
        Product[] expected = {four};
        Product[] actual = manager.searchBy("Финляндия");
        Assertions.assertArrayEquals(expected, actual);
    }


}