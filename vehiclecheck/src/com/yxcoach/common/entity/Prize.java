package com.yxcoach.common.entity;

public class Prize {
    private int index; //序号
    private Long id; // ID
    private String name; //抽奖物品名称
    private double probability; //中奖概率

    public Prize(int index, Long id, String name, double probability) {
        this.index = index;
        this.id = id;
        this.name = name;
        this.probability = probability;
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "Prize [index=" + index + ", id=" + id + ", name=" + name + ", probability=" + probability + "]";
	}
}
