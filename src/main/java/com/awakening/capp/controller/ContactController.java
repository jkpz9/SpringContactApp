package com.awakening.capp.controller;

import com.awakening.capp.domain.Contact;
import com.awakening.capp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value="/user/contact_form")
    public String contactForm(Model m)
    {
        Contact c = new Contact();
        m.addAttribute("command", c);
        return "contac_form";
        
    }
    
    @RequestMapping(value="/user/save_contact")
    public String saveOrContact(@ModelAttribute("command") Contact c,Model m, HttpSession session)
    {
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if(contactId == contactId) {
            // Save 
             try{
                    Integer userId = (Integer)session.getAttribute("userId");
                    c.setUserId( userId);
                    contactService.save(c);
                    return "redirect:clist?act=sv";   
       
            } catch(Exception e) {
                    e.printStackTrace();
                    m.addAttribute("err", "Failed to save contact!");
                    return "contact_form";
            }
             
        } else {
            // Update
            try {
                c.setContactId(contactId);
                contactService.update(c);
                return "redirect:clist?act=up";
                
            } catch(Exception ex) {
                 ex.printStackTrace();
                 m.addAttribute("err", "Failed to update contact!");
                 return "contact_form";
            }
        }
       
    }
    
    @RequestMapping(value="user/clist")
    public String contactList(Model m, HttpSession session)
    {
        Integer userId = (Integer)session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "clist";
    }
    
    
    @RequestMapping(value="user/remove_contact")
    public String removeContact(@RequestParam("cid") Integer contactId)
    {
       contactService.delete(contactId);
        return "redirect:clist?act=del";
    }
    
    
     @RequestMapping(value="user/update_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId)
    {
       session.setAttribute("aContactId", contactId);
       
       Contact contact = contactService.findById(contactId);
       
       m.addAttribute("command", contact);
        return "contact_form";
    }
    
    
    
     @RequestMapping(value="user/clist")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText)
    {
        Integer userId = (Integer)session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId, freeText));
        return "clist";
    }
    
    
     @RequestMapping(value="user/remove_contact")
    public String removeMultipleContact(@RequestParam("cid") Integer[] contactIds)
    {
       contactService.delete(contactIds);
        return "redirect:clist?act=del";
    }
}
