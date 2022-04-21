package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional //이건 조회가 아니라 저장이니까 위에 있는 어노테이션 때문에 적어줘야함
    public void saveItem(Item item){
        itemRepository.save(item);
    }
    @Transactional //commit 되면서 JPA 가 flush 날리면서 변경사항을 update 하기위해 디비에 쿼리를 날림
    public void updateItem(Long itemId, String name, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);

    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemid){
        return itemRepository.findOne(itemid);
    }



}
