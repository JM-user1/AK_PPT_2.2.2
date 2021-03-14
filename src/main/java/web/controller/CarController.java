package web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

@Controller
public class CarController {

  private final CarDao carDao;
  @Autowired
  public CarController(CarDao carDao) {
    this.carDao = carDao;
  }

  @GetMapping("/cars")
  public String cntCars(@RequestParam("count") int cnt, Model model){
    if(cnt <= 5){
      model.addAttribute("cars",carDao.listCar(cnt));
    }else {
      cnt = 5;
      model.addAttribute("cars",carDao.listCar(cnt));
    }
    return "cars";
  }

  @GetMapping("/{id}")
  public String getCar(@PathVariable("id") int id, Model model){
     model.addAttribute("car",carDao.getCar(id));
     return "car";
  }
}
