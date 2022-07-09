package bg.softuni.web.mobilelele.web;


import bg.softuni.web.mobilelele.models.bindings.OfferUpdateBindingModel;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;

    }


    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                this.offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")

    public String showOffer(@PathVariable Long id, Model model) {

        OfferSummaryView offer = this.offerService.findById(id);
        model.addAttribute("offer", offer);
        model.addAttribute("createdOn", offer.getCreated());
        model.addAttribute("modifiedOn", offer.getModified());

        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id) {
        this.offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {

        OfferSummaryView offerSummaryView = this.offerService.findById(id);

        OfferUpdateBindingModel offerModel = this.modelMapper.map(offerSummaryView, OfferUpdateBindingModel.class);

        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("offerModel", offerModel);

        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());

        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = this.modelMapper.map(offerModel, OfferUpdateServiceModel.class);
        this.offerService.updateOffer(serviceModel);
        serviceModel.setId(id);

        return "redirect:/offers/" + id + "/details";
    }

    public String showOffer(@PathVariable Long id) {
        return "details";
    }

}

