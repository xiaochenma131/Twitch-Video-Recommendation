package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FavoriteRequestBody {
  private final Item favoriteItem;

  @JsonCreator
  // Convert from Json to java item
  public FavoriteRequestBody(@JsonProperty("favorite") Item favoriteItem) {
    this.favoriteItem = favoriteItem;
  }

  public Item getFavoriteItem() {
    return favoriteItem;
  }

}
