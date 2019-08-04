package pl.wypozyczalnia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wypozyczalnia.model.Client;
import pl.wypozyczalnia.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        Client client = new Client();
        model.addAttribute("client",client);
        return "registerClient";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid Client client, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registerClient";
        }
        List<Client> clientList = clientService.findAllByEmail(client.getEmail());
        if (clientList.isEmpty()){
        clientService.saveClient(client);
        return "done";
        }
        return "error";
    }
}
