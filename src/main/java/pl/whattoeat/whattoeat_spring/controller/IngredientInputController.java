package pl.whattoeat.whattoeat_spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients_input")
@AllArgsConstructor
public class IngredientInputController {
    @GetMapping("")
    public String getIngredients(Model model, HttpSession session, HttpServletRequest request) {
//        Optional<String> sortValue = Arrays.stream(request.getCookies()).filter(
//                c -> c.getName().equals("catalogCookie" + session.getAttribute("userId"))).map(Cookie::getValue).findAny();
//
//        if(sortValue.isEmpty())
//            return "redirect:/login";
//
//        if (sortValue.get().equals("ASC"))
//            return "redirect:/catalogs/ASC";
//        else if (sortValue.get().equals("DESC"))
//            return "redirect:/catalogs/DESC";
//        else if (sortValue.get().equals("notesASC"))
//            return "redirect:/catalogs/notesASC";
//        else if (sortValue.get().equals("notesDESC"))
//            return "redirect:/catalogs/notesDESC";
//
//        List<Catalog> catalogList = catalogService.getCatalogsByUserId((Integer) session.getAttribute("userId"));
//        Optional<User> user = userService.getUserById((Integer) session.getAttribute("userId"));
//        model.addAttribute("catalogs", catalogList);
//        model.addAttribute("user", user.get());
        return "ingredients";
    }

    @GetMapping("add")
    public String getCatalogsByUserId(Model model, HttpSession session, HttpServletRequest request) {

        return "addIngredient";
    }
}
