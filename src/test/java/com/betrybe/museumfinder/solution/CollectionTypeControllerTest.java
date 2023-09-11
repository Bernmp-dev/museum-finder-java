package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService service;

  @Test
  @DisplayName("Should return ok status when collection type is found")
  public void test1() throws Exception {
    String[] expectedCollectionTypes = {"hist", "imag"};
    String commaSeparatedTypes = String.join(", ", expectedCollectionTypes);
    CollectionTypeCount expectedTypeCount = new CollectionTypeCount(expectedCollectionTypes, 1);

    when(service.countByCollectionTypes(commaSeparatedTypes))
        .thenReturn(expectedTypeCount);

    ResultActions resultActions = mockMvc.perform(
        get("/collections/count/{types}", commaSeparatedTypes));

    resultActions.andExpect(status().isOk());
    Mockito.verify(service).countByCollectionTypes(commaSeparatedTypes);
  }

  @Test
  @DisplayName("Should return not found status when collection type is not found")
  public void test2() throws Exception {
    String[] expectedCollectionTypes = {"hist", "imag"};
    String commaSeparatedTypes = String.join(", ", expectedCollectionTypes);
    CollectionTypeCount expectedTypeCount = new CollectionTypeCount(expectedCollectionTypes, 0);

    when(service.countByCollectionTypes(commaSeparatedTypes))
        .thenReturn(expectedTypeCount);

    ResultActions resultActions = mockMvc.perform(
        get("/collections/count/{types}", commaSeparatedTypes));

    resultActions.andExpect(status().isNotFound());
    Mockito.verify(service).countByCollectionTypes(commaSeparatedTypes);
  }
}
