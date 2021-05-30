package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "Test List 1", false);
        TrelloList trelloList2 = new TrelloList("2", "Test List 2", true);
        TrelloList trelloList3 = new TrelloList("3", "Test List 3", false);

        List<TrelloList> list1 = new ArrayList<>();
        list1.add(trelloList1);
        list1.add(trelloList2);

        List<TrelloList> list2 = new ArrayList<>();
        list2.add(trelloList3);

        TrelloBoard trelloBoard1 = new TrelloBoard("TestBoard1", "BoardId1", list1);
        TrelloBoard trelloBoard2 = new TrelloBoard("TestBoard2", "BoardId2", list2);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(2, trelloBoardDtoList.size());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "Test List 1", false);
        TrelloList trelloList2 = new TrelloList("2", "Test List 2", true);
        List<TrelloList> list = Arrays.asList(trelloList1, trelloList2);

        //When
        List<TrelloListDto> TrelloListDto = trelloMapper.mapToListDto(list);

        //Then
        assertEquals("1", TrelloListDto.get(0).getId());
        assertEquals("Test List 1", TrelloListDto.get(0).getName());
        assertFalse(TrelloListDto.get(0).isClosed());
        assertEquals("2", TrelloListDto.get(1).getId());
        assertEquals("Test List 2", TrelloListDto.get(1).getName());
        assertTrue(TrelloListDto.get(1).isClosed());
    }

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloListDto trelloList1 = new TrelloListDto("1", "Test List 1", false);
        TrelloListDto trelloList2 = new TrelloListDto("2", "Test List 2", true);
        TrelloListDto trelloList3 = new TrelloListDto("3", "Test List 3", false);

        List<TrelloListDto> list1 = Arrays.asList(trelloList1, trelloList2);
        List<TrelloListDto> list2 = Arrays.asList(trelloList3);

        TrelloBoardDto trelloBoard1 = new TrelloBoardDto("BoardId1", "Test Board 1", list1);
        TrelloBoardDto trelloBoard2 = new TrelloBoardDto("BoardId2", "Test Board 2", list2);

        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(trelloBoard1, trelloBoard2);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(2, trelloBoardList.size());
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloList1 = new TrelloListDto("1", "Test List 1", false);
        TrelloListDto trelloList2 = new TrelloListDto("2", "Test List 2", true);
        List<TrelloListDto> list = Arrays.asList(trelloList1, trelloList2);

        //When
        List<TrelloList> TrelloList = trelloMapper.mapToList(list);

        //Then
        assertEquals("1", TrelloList.get(0).getId());
        assertEquals("Test List 1", TrelloList.get(0).getName());
        assertFalse(TrelloList.get(0).isClosed());
        assertEquals("2", TrelloList.get(1).getId());
        assertEquals("Test List 2", TrelloList.get(1).getName());
        assertTrue(TrelloList.get(1).isClosed());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("CardId1", "Test Card 1", "1", "1");
        TrelloCard trelloCard2 = new TrelloCard("CardId2", "Test Card 2", "2", "1");

        //When
        TrelloCardDto trelloCardDto1 = trelloMapper.mapToCardDto(trelloCard1);
        TrelloCardDto trelloCardDto2 = trelloMapper.mapToCardDto(trelloCard2);

        //Then
        assertEquals("CardId1", trelloCardDto1.getName());
        assertEquals("Test Card 1", trelloCardDto1.getDescription());
        assertEquals("1", trelloCardDto1.getPos());
        assertEquals("1", trelloCardDto1.getListId());
        assertEquals("CardId2", trelloCardDto2.getName());
        assertEquals("Test Card 2", trelloCardDto2.getDescription());
        assertEquals("2", trelloCardDto2.getPos());
        assertEquals("1", trelloCardDto2.getListId());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCard1 = new TrelloCardDto("CardId1", "Test Card 1", "1", "1");
        TrelloCardDto trelloCard2 = new TrelloCardDto("CardId2", "Test Card 2", "2", "1");

        //When
        TrelloCard trelloCardDto1 = trelloMapper.mapToCard(trelloCard1);
        TrelloCard trelloCardDto2 = trelloMapper.mapToCard(trelloCard2);

        //Then
        assertEquals("CardId1", trelloCardDto1.getName());
        assertEquals("Test Card 1", trelloCardDto1.getDescription());
        assertEquals("1", trelloCardDto1.getPos());
        assertEquals("1", trelloCardDto1.getListId());
        assertEquals("CardId2", trelloCardDto2.getName());
        assertEquals("Test Card 2", trelloCardDto2.getDescription());
        assertEquals("2", trelloCardDto2.getPos());
        assertEquals("1", trelloCardDto2.getListId());
    }
}
