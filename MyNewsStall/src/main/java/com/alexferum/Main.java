package com.alexferum;

import com.alexferum.model.Magazine;
import com.alexferum.model.NewsStall;
import com.alexferum.model.Newspaper;
import com.alexferum.model.Book;
import com.alexferum.services.FileHandler;
import com.alexferum.services.NewsStall_Service;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        NewsStall_Service newsStall_service = new NewsStall_Service();
        NewsStall newsStall = new NewsStall(newsStall_service.CreateProduct());

        ShowMenu();
        int menuinput = sc.nextInt();

        try {
            while (menuinput != 7) {
                switch (menuinput) {
                    case 1: {
                        newsStall_service.ShowProduct(newsStall);
                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 2: {
                        System.out.println("\r\nInsert product name: ");
                        String name = sc.next();

                        System.out.println("\r\nInsert product quantity: ");
                        int count = sc.nextInt();

                        newsStall_service.BuyProduct(newsStall, name, count);
                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 3: {
                        System.out.println("\r\nChoose product:\n"
                                + "1. Book\n"
                                + "2. Newspaper\n"
                                + "3. Magazine\n");
                        int choice = sc.nextInt();

                        System.out.println("\r\nInsert product name: ");
                        String name = sc.next();

                        System.out.println("\r\nInsert product quantity: ");
                        int count = sc.nextInt();
                        System.out.println("\r\nInsert product value: ");
                        int price = sc.nextInt();

                        switch (choice) {
                            case 1: {
                                System.out.println("\r\nInsert book author: ");
                                String author = sc.next();

                                System.out.println("\r\nInsert book publishing house: ");
                                String publish = sc.next();

                                Book book = new Book(name, price, publish, author);
                                newsStall_service.GetProducts(newsStall, book, count);
                            }
                            break;

                            case 2: {
                                System.out.println("\r\nInsert newspaper issue: ");
                                String number = sc.next();

                                Newspaper newspaper = new Newspaper(name, price, number);
                                newsStall_service.GetProducts(newsStall, newspaper, count);
                            }
                            break;

                            case 3: {
                                System.out.println("\r\nInsert magazine issue: ");
                                String number = sc.next();

                                Magazine magazine = new Magazine(name, price, number);
                                newsStall_service.GetProducts(newsStall, magazine, count);
                            }
                            break;

                            default: {
                                System.out.println("\r\nInput error");
                                ShowMenu();

                                menuinput = sc.nextInt();
                                break;
                            }
                        }

                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 4: {
                        newsStall_service.ShowProduct(newsStall);

                        System.out.println("\r\nInsert product name: ");
                        String name = sc.next();

                        System.out.println("\r\nInsert new quantity: ");
                        int count = sc.nextInt();

                        newsStall_service.Change(newsStall, count, name);
                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 5: {
                        System.out.println("\r\nChoose option:\n1.Serialize\n2.JSON\n");
                        int choice = sc.nextInt();

                        System.out.println("\r\nInsert file name");
                        String name = sc.next();

                        switch (choice) {
                            case (1): {
                                fileHandler.serialize(newsStall, name);
                                System.out.println("\r\nSuccessfully");
                            }
                            break;

                            case (2): {
                                fileHandler.JSONize(newsStall, name);
                                System.out.println("\r\nSuccessfully");
                            }
                            break;
                        }

                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 6: {
                        System.out.println("\r\nInsert file name: ");
                        String name = sc.next();

                        System.out.println("\r\nInsert file format (dat or json): ");
                        String format = sc.next();

                        newsStall = fileHandler.loadFromFile(name, format);
                        ShowMenu();
                        menuinput = sc.nextInt();
                    }
                    break;

                    case 7: {
                        System.exit(0);
                        break;
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    public static void ShowMenu() {
        System.out.println(
                "\r\nChoose:" + "\n"
                        + "1. Show products" + "\n"
                        + "2. Buy product" + "\n"
                        + "3. New arrivals " + "\n"
                        + "4. Edit information" + "\n"
                        + "5. Save to file" + "\n"
                        + "6. Download from file" + "\n"
                        + "7. Exit" + "\n");
    }
}

