package bookstore.controller;

import bookstore.domain.Author;
import bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/add-author")
    public String showAddAuthor() {
        return "admin/author/add_author";
    }

    @RequestMapping(value = "/add-author", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute Author author, Model model) {
        authorService.save(author);
        return "redirect:/admin/author/show-authors";
    }

    @RequestMapping("/show-authors")
    public String showAllAuthors(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authorList", authors);
        System.out.println(authors);
        return "admin/author/show_author";
    }

    @RequestMapping("/edit-author")
    public String showEditAuthor(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authorList", authors);
        System.out.println(authors);
        return "admin/author/update_author";
    }

    @RequestMapping(value = "/search-author-edit", method = RequestMethod.POST)
    public String getEditInfoById(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Author author = authorService.getById(id);
        if (author != null) {
            model.addAttribute("author", author);
            return "admin/author/update_author";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Author not found");
            return "redirect:/admin/author/edit-author";
        }
    }

    @RequestMapping(value = "/update-author", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute Author author, Model model) {
        boolean isUpdated = authorService.updateAuthor(author);
        if (isUpdated) {
            model.addAttribute("successMessage", "Author updated successfully");
        } else {
            model.addAttribute("errorMessage", "Failed to update author");
        }
        return "redirect:/admin/author/show-authors";
    }

    @RequestMapping("/show-delete")
    public String showDelete(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authorList", authors);
        return "admin/author/delete_author";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable Integer id) {
        Author author = authorService.getById(id);
        authorService.delete(author);
        return "redirect:/admin/author/show-authors";
    }
}
