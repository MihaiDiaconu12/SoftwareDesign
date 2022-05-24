package com.example.spersamergi;

import com.example.spersamergi.foodPackage.Food;
import com.example.spersamergi.foodPackage.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SpersamergiApplicationTests {

	FoodsTest underTest = new FoodsTest();
	@Test
	void itShouldAddFood() {
		//given
		Food food1=new Food("English breakfast","The best there is", (float) 2.76,"breakfast");
		Food result = underTest.add(food1);
		assertThat(result.getName()).isEqualTo("English breakfast");

		Food food2=new Food("Scottish breakfast","The best there is", (float) 2.76,"breakfast");
		Food result2 = underTest.add(food2);
		assertThat(result2.getName()).isEqualTo("Scottish breakfast");

		Food food3=new Food("Irish breakfast","The best there is", (float) 2.76,"breakfast");
		Food result3 = underTest.add(food3);
		assertThat(result3.getName()).isEqualTo("Irish breakfast");
	}

	@Autowired
	FoodService foodService;
	class FoodsTest{
		Food add(Food food){return foodService.addFood(food);};
	}
}
