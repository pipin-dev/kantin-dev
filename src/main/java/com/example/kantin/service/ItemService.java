package com.example.kantin.service;
import com.example.kantin.entity.Item;
import com.example.kantin.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repo;

    public ItemService(ItemRepository repo){ this.repo = repo; }

    public List<Item> findAll(){ return repo.findAll(); }
    public Item save(Item i){ return repo.save(i); }
}