package tacos.controller.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.dto.Order;

@Controller
@RequestMapping("orders")
@Slf4j
public class OrderController {

    @GetMapping("current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());

        return "orderForm";
    }

    @PostMapping
    public String processOrder(Order request) {
        log.info("Orrrrrder Submit : " + request);
        return "redirect:/";
    }
}
