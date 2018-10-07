package com.siwei.worldCreator;

import java.util.Random;

public abstract class Item {
	private float x;
	private float y;
	private int id;
	private String up;
	private String down;
	private int product;

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getDown() {
		return down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItem(int id) {
		Random random = new Random();
		setId(id);
		setX(random.nextInt(1000) + 1);
		setY(random.nextInt(1000) + 1);
		setUp("");
		setDown("");
		setProduct(random.nextInt(100) + 1);
	}
}
