package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** MuseumController.*/
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface service;

  @Autowired
  MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /** createMuseum. */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MuseumDto createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum museum = ModelDtoConverter.dtoToModel(museumCreationDto);
    Museum createdMuseum = service.createMuseum(museum);

    return ModelDtoConverter.modelToDto(createdMuseum);
  }

  /** getClosestMuseum. */
  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public MuseumDto getClosestMuseum(
      @RequestParam("lat") Double latitude,
      @RequestParam("lng") Double longitude,
      @RequestParam("max_dist_km") Double maxDistance
  ) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum museum = service.getClosestMuseum(coordinate, maxDistance);

    return ModelDtoConverter.modelToDto(museum);
  }

}
