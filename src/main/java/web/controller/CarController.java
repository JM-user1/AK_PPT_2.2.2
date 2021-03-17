package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

  private final CarService carService;
  @Autowired
  public CarController(CarService carDao) {
    this.carService = carDao;
  }

  @GetMapping("/cars")
  public String cntCars(@RequestParam("count") int cnt, Model model){
    if(cnt > 5){
      cnt = 5;
      model.addAttribute("cars",carService.listCar(cnt));
      return "cars";
    }
    model.addAttribute("cars",carService.listCar(cnt));
    return "cars";
  }

  @GetMapping("/{id}")
  public String getCar(@PathVariable("id") int id, Model model){
     model.addAttribute("car",carService.getCar(id));
     return "car";
  }
}
