package bg.softuni.web.mobilelele.web;


import bg.softuni.web.mobilelele.models.bindings.OfferAddBindingModel;
import bg.softuni.web.mobilelele.models.bindings.OfferUpdateBindingModel;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;
import bg.softuni.web.mobilelele.models.service.OfferAddServiceModel;
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
import bg.softuni.web.mobilelele.models.views.ModelView;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.services.ModelService;
import bg.softuni.web.mobilelele.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final ModelService modelService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, ModelService modelService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;

        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                this.offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")

    public String showOffer(@PathVariable Long id, Model model) {

        OfferSummaryView offer = this.offerService.findById(id);
        model.addAttribute("offer", offer);
        model.addAttribute("createdOn", offer.getCreated());
        model.addAttribute("modifiedOn", offer.getModified());

        return "details";
    }

    @PreAuthorize("@offerServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable Long id, Principal principal) {

        //Most naive approach - check explicitly if the current user is an owner and throw exception if this is not the case.
/*        if(!this.offerService.isOwner(principal.getName(), id)){
            throw new Exception();
        }*/
        this.offerService.deleteOffer(id);

        return "redirect:all";
    }

    @GetMapping("/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {

        OfferSummaryView offerSummaryView = this.offerService.findById(id);

        OfferUpdateBindingModel offerModel = this.modelMapper.map(offerSummaryView, OfferUpdateBindingModel.class);

        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("offerModel", offerModel);

        return "update";
    }

    @GetMapping("/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());

        return "update";
    }

    @PatchMapping("/{id}/edit")
    public String editOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = this.modelMapper.map(offerModel, OfferUpdateServiceModel.class);
        this.offerService.updateOffer(serviceModel);
        serviceModel.setId(id);

        return "redirect:/" + id + "/details";
    }

    @GetMapping("/add")
    public String addOffer(Model model){

        List<ModelView> models= this.modelService.getModels();
        model.addAttribute("models", models);
        return "offer-add";
    }


    @PostMapping("/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Principal principal){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:add";
        }

        OfferAddServiceModel offerAddServiceModel = this.offerService.addOffer(offerAddBindingModel, principal);

        return "redirect:/offers/" + offerAddServiceModel.getId() + "/details";
    }

    public String showOffer(@PathVariable Long id) {
        return "details";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel(){
        return  new OfferAddBindingModel();
    }

}

