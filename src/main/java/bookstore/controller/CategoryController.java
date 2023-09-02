package bookstore.controller;

import bookstore.domain.Category;
import bookstore.domain.User;
import bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/add-category")
    public String showAddCategory(){
        return "admin/category/add_category";
    }

    @RequestMapping(value ="/add-category",method=RequestMethod.POST)
    public String addCategory(@ModelAttribute Category category, Model model){
        this.categoryService.save(category);
        return "redirect:/admin/category/show-category";
    }



    @RequestMapping("/show-category")
    public String showAllCategories(Model model){
        List<Category> c = categoryService.getAll();
        model.addAttribute("categoryList", c);
        System.out.println(c);
        return "admin/category/show_category";
    }


//    @RequestMapping("edit-category")
//    public String showEditCatagory(Model model){
//        return "admin/category/update_category";
//    }

    @RequestMapping("/edit-category")
    public String showEditCategory(Model model){
        List<Category> category = categoryService.getAll();
        model.addAttribute("categoryList", category);
        System.out.println(category);
        return "admin/category/update_category";
    }




    @RequestMapping(value = "/search-category-edit", method = RequestMethod.POST)
    public String getEditInfoById(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        Category user = categoryService.getById(id);
        if (user != null) {
            model.addAttribute("category", user);
            return "admin/category/update_category";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Category not found");
            return "redirect:/admin/category/edit-category";
        }
    }


    @RequestMapping(value = "/update-category", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute Category category, Model model) {
        boolean isUpdated = categoryService.updateCategory(category);
        if (isUpdated) {
            model.addAttribute("successMessage", "User updated successfully");
        } else {
            model.addAttribute("errorMessage", "Failed to update user");
        }
        // Redirect to the appropriate page after updating
        return "redirect:/admin/category/show-category";
    }

    @RequestMapping("/show-delete")
    public String showDelete(Model model){
        List<Category> category = categoryService.getAll();
        model.addAttribute("categoryList", category);
        return "admin/category/delete_category";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        categoryService.delete(category);
        return "redirect:/admin/category/show-category";
    }






}
