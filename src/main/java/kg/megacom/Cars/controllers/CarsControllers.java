package kg.megacom.Cars.controllers;


import kg.megacom.Cars.dao.CarDAO;
import kg.megacom.Cars.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarsControllers {

    private CarDAO carDAO;

    @Autowired
    public CarsControllers(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("cars", carDAO.index());
        return "index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carDAO.show(id));
        return "show";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car";
    }

    @PostMapping("/sendCarForm")
    public String addNewCar(@ModelAttribute("car") Car car){
        carDAO.save(car);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id, Model model){
        carDAO.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carDAO.show(id));
        return "update-car";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@ModelAttribute("car") Car car, @PathVariable("id") int id){
        carDAO.update(car, id);
        return "redirect:/index";
    }
}
































































