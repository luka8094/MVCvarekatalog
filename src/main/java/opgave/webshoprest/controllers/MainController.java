package opgave.webshoprest.controllers;


import opgave.webshoprest.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @GetMapping("/home")
    public String renderIndexPage(){

        return "index.html";

    }

    @GetMapping("/create")
    public String renderCreatePage(){

        return "create.html";
    }

    @PostMapping("/create")
    public String create(Product product){
        //TODO: include line to reach repo upon creation
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        //TODO: include line to reach repo upon deletion
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String renderUpdatePage(@PathVariable("id") Long id, Model model){
        //TODO: include line to reach model upon product insertion
        return "update.html";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product){
        //TODO: indclude line to reach repo upon product attributes update
        return "redirect:/";
    }

}
