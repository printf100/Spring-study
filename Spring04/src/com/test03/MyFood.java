package com.test03;

public class MyFood {

	private Food favoriteFood;
	private Food unFavoriteFood;

	public MyFood() {
		this.favoriteFood = new Food("연어", 24000);
		this.unFavoriteFood = new Food("굴", 20000);
	}

	public MyFood(Food favoriteFood, Food unFavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return "favoriteFood=" + favoriteFood + "\n unFavoriteFood=" + unFavoriteFood;
	}

}
