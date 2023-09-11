package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeServiceTest {

  @Autowired
  private CollectionTypeService service;

  @MockBean
  private MuseumFakeDatabase database;

  @Test
  @DisplayName("Should return ok status when collection type is found")
  void test() {
    String commaSeparatedTypes = "hist, imag";

    when(database.countByCollectionType("hist")).thenReturn(1L);
    when(database.countByCollectionType("imag")).thenReturn(1L);

    CollectionTypeCount expectedTypeCount = service.countByCollectionTypes(commaSeparatedTypes);

    assertEquals(2L, expectedTypeCount.count());
  }

  @Test
  @DisplayName("Should return not found status when collection type is not found")
  void test2() {
    String commaSeparatedTypes = "hist, imag";

    when(database.countByCollectionType("hist")).thenReturn(0L);
    when(database.countByCollectionType("imag")).thenReturn(0L);

    CollectionTypeCount expectedTypeCount = service.countByCollectionTypes(commaSeparatedTypes);

    assertEquals(0L, expectedTypeCount.count());
  }
}
