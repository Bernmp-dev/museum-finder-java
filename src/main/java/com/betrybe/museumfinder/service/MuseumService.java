package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** MuseumService. */
@Service
public class MuseumService implements MuseumServiceInterface {

  @Autowired
  private MuseumFakeDatabase museumFakeDatabase;

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Coordinate coordinate = museum.getCoordinate();
    Boolean isValid = CoordinateUtil.isCoordinateValid(coordinate);

    if (isValid) {
      return museumFakeDatabase.saveMuseum(museum);
    }

    throw new InvalidCoordinateException();
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
