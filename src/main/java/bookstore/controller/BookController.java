package bookstore.controller;

import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Category;
import bookstore.domain.User;
import bookstore.services.AuthorService;
import bookstore.services.BookService;
import bookstore.services.CategoryService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @RequestMapping(value = "/add-book", method=RequestMethod.GET)
    public String showAddBook(Model model){

        List<Author> a = authorService.getAll();
        List<Category> c = categoryService.getAll();
        model.addAttribute("categoryList", c);
        model.addAttribute("authorList", a);
        //send all categorie name to categories options
        System.out.println(c);
        return "book/add-book";
    }





    //---------------


    //we have to save this file to server

//---------
    @RequestMapping(value = "/add-book-db", method = RequestMethod.POST)
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("price") double price,
                          @RequestParam("quantity") int quantity,
                          @RequestParam("author_id") int authorId,
                          @RequestParam("category_id") int categoryId,
                          @RequestParam("cover") CommonsMultipartFile cover,HttpSession s) {

        Book book = new Book();
        Author author = authorService.getById(authorId);
        Category category = categoryService.getById(categoryId);

        book.setTitle(title);
        book.setDescription(description);
        book.setPrice(price);
        book.setQuantity(quantity);
        book.setAuthor(author);
        book.setCategory(category);

        byte [] data = cover.getBytes();
        String path = s.getServletContext().getRealPath("/") + "resources" + File.separator + "images" + File.separator + cover.getOriginalFilename();


        try {
            if (!cover.isEmpty()) {
                FileOutputStream f = new FileOutputStream(path);
                f.write(data);
                f.close();
                System.out.println("file_uploaded");

            }
            book.setCover(cover.getOriginalFilename());


            bookService.save(book);
            System.out.println("File uploaded and book saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        return "book/add-book";
    }



    //All book
    @RequestMapping("/show-books")
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("bookList", books);

        List<Author> authors = authorService.getAll();
        model.addAttribute("authorList", authors);

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categoryList", categories);

        return "book/show_books";
    }



    //Edit Book

    @RequestMapping("/edit-book")
    public String showEditBook(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("bookList", books);
        System.out.println(books);
        return "book/update_book";
    }


    @RequestMapping(value = "/search-book-edit", method = RequestMethod.POST)
    public String getEditInfoById(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.getById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "book/update_book";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Book not found");
            return "redirect:/admin/book/edit-book";
        }
    }
    @RequestMapping(value = "/update-book", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book, Model model) {
        boolean isUpdated = bookService.updateBook(book);
        if (isUpdated) {
            model.addAttribute("successMessage", "Book updated successfully");
        } else {
            model.addAttribute("errorMessage", "Failed to update book");
        }
        // Redirect to the appropriate page after updating
        return "redirect:/admin/book/show-books";
    }

    //Delete
    @RequestMapping("/show-delete")
    public String showDelete(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("bookList", books);
        return "book/delete-book";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        bookService.delete(book);
        return "redirect:/admin/book/show-books";
    }
}
