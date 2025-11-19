package com.example.kantin.controller;
import com.example.kantin.entity.Item;
import com.example.kantin.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service){ this.service = service; }

    @GetMapping
    public List<Item> all(){ return service.findAll(); }

    @PostMapping
    public Item add(@RequestBody Item item){ return service.save(item); }
}