package co.edu.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //전체 필드 다 채워주는 생성자?

public class ShopItem {
	private String itemCode;
	private String itemName;
	private int originPrice;
	private int salePrice;
	private double likeIt;
	private String image;
}
