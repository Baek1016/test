//package com.helloworld.quickstart.service;
//
//import java.util.HashMap;
//import com.helloworld.quickstart.dto.ItemDto;
//import com.helloworld.quickstart.mapper.QuickMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//
////Layer나누기
//public class QuickService {
//    @Autowired
//    private QuickMapper quickMapper;
//
//    public boolean registerItem(ItemDto itemDto) {
//
//        //todo : DB insert
//
//        HashMap<String, Object> paramMap = new HashMap<>();
//
//        paramMap.put("name", itemDto.getName());
//        paramMap.put("id", itemDto.getId());
//
//        quickMapper.resgisterItem(paramMap);
//
//        log.info("service ...");
//
//        return true;
//    }
//
//    public ItemDto getItemById(String id){
//
//        HashMap<String,Object> paramMap = new HashMap<>();
//        paramMap.put("id",id);
//
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//        //없는 data일때 끊김,중단됨 예외철리 해야함!!!!!!!!!!!
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String) res.get("ID"));
//        itemDto.setName((String) res.get("NAME"));
//
//        return itemDto;
//    }
//}
package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert

//        HashMap<String, Object> paramMap = new HashMap<>();
//
//        paramMap.put("id", itemDto.getId());
//        paramMap.put("name", itemDto.getName());
//
//        quickMapper.registerItem(paramMap);
//
//        log.info("service ...");

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }

    public ItemDto getItemById(String id) {

//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String)res.get("ID"));
//        itemDto.setName((String)res.get("NAME"));
//
//        return itemDto;


        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());


        return itemDto;
    }
}