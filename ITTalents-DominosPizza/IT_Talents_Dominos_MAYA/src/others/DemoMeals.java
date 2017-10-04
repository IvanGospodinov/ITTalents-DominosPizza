package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import producti.Appetizer;
import producti.Chicken;
import producti.IIngredients;
import producti.ITypeMeal;
import producti.Meal;
import producti.Pasta;
import producti.Pizza;
import producti.Pizza.Size;
import producti.Salad;
import producti.Sause;

public class DemoMeals {

	public static void main(String[] args) {
		
		Menu m=new Menu();
		
		//new ArrayList<Type>( Arrays.asList(Object o1, Object o2, Object o3, ....so on));
		
		Meal margarita=new Pizza (ITypeMeal.TypePizza.VEGETARIAN_PIZZA, "Margarita", 450 , 5.50, new ArrayList<IIngredients>( Arrays.asList(IIngredients.Meat.CHICKEN,IIngredients.Vegetable.GREEN_PEPPERS)));
		m.addMeal(margarita);
				
		Meal gybena=new Pizza (ITypeMeal.TypePizza.VEGETARIAN_PIZZA, "Gybkite", 420 , 4.30, new ArrayList<IIngredients>( Arrays.asList(IIngredients.Meat.CHICKEN,IIngredients.Vegetable.GREEN_PEPPERS)));
		m.addMeal(gybena);
		
		Meal ribena=new Pizza (ITypeMeal.TypePizza.MEAT_PIZZA, "Mediteraneo", 470 , 8.60 , new ArrayList<IIngredients>( Arrays.asList(IIngredients.Meat.CHICKEN,IIngredients.Vegetable.GREEN_PEPPERS)));
		m.addMeal(ribena);
		
		Meal shunka=new Pizza (ITypeMeal.TypePizza.MEAT_PIZZA, "Shunkata", 520 , 7.50,  new ArrayList<IIngredients>( ));
		m.addMeal(shunka);
		
		
		
	
		
		//m.printCatalog();	
		
		
		// change size margaritata
		
		Size sizeJumbo=Size.JUMBO;
		Size sizeMiddle=Size.MIDDLE;
		
		Meal margaritaOgromna=m.modifySizeMeal(margarita, sizeJumbo);
		System.out.println(margaritaOgromna);
		
		Meal gybenaMIDDLE=m.modifySizeMeal(gybena, sizeMiddle);
		System.out.println(gybenaMIDDLE);
		
		
		
		
		
		System.out.println(margaritaOgromna);
		
		
		
		//real SALADS !!!!!!!!
		
		Meal saladRoka=new Salad (ITypeMeal.TypeSalad.VEGETARIAN_SALAD, "SALAD ROKA", 220 ,5.30,   new ArrayList<IIngredients>( Arrays.asList(IIngredients.Vegetable.AISBERG, IIngredients.Vegetable.ARUGULA,IIngredients.Vegetable.TOMATOES, IIngredients.Cheese.PARMESAN, IIngredients.Topping.OLIVE_OIL)));
		m.addMeal(saladRoka);
		
		Meal saladTrikolore=new Salad (ITypeMeal.TypeSalad.VEGETARIAN_SALAD, "SALAD TRIKOLORE", 380 ,5.30,  new ArrayList<IIngredients>( Arrays.asList(IIngredients.Vegetable.TOMATOES,IIngredients.Topping.OLIVE_OIL, IIngredients.Cheese.COW_MILK_CHEESE, IIngredients.Topping.PESTO)));
		m.addMeal(saladTrikolore);
		
		Meal cezarBecon=new Salad (ITypeMeal.TypeSalad.MEAT_SALAD, "SALAD CEZAR WITH BECON", 330 , 5.80,   new ArrayList<IIngredients>(Arrays.asList(IIngredients.Vegetable.CORN,IIngredients.Meat.SMOKED_BACON, IIngredients.Cheese.PARMESAN,IIngredients.Spice.CROTON)));
		m.addMeal(cezarBecon);
		
		Meal cezarChicken=new Salad (ITypeMeal.TypeSalad.MEAT_SALAD, "SALAD CEZAR WITH CHICKEN", 380 ,5.80,  new ArrayList<IIngredients>(Arrays.asList(IIngredients.Vegetable.CORN,IIngredients.Meat.CHICKEN, IIngredients.Cheese.PARMESAN,IIngredients.Spice.CROTON)));
		m.addMeal(cezarChicken);
		
		Meal cezarFish=new Salad (ITypeMeal.TypeSalad.MEAT_SALAD, "SALAD CEZAR WITH FISH", 280 ,5.80,  new ArrayList<IIngredients>(Arrays.asList( IIngredients.Topping.OLIVE_OIL,IIngredients.Meat.TUNA_FISH, IIngredients.Vegetable.CORN, IIngredients.Vegetable.BLACK_OLIVES)));
		m.addMeal(cezarFish);
		
		
		// real APPETIZER
		
		Meal breadMocarela=new Appetizer(ITypeMeal.TypeAppetizer.ALL, "BREAD WITH MOCARELA", 195, 3.50,  new ArrayList<IIngredients>( ),"Прясно изпечено пухкаво хлебче с моцарела и специалната подправка на Доминос, придружено с доматен сос ");
		m.addMeal(breadMocarela);
		
		// real ChickenMeals
		
		Meal chickenKikersMeal=new Chicken(ITypeMeal.TypeChicken.SPICY, "CHICKEN KIKERS", 225, 6.50,  new ArrayList<IIngredients>( )," Късчета от сочни пикантни пилешки гърди, с хрупкава обвивка, изпечени на фурна придружени със сос Барбекю ");
		m.addMeal(chickenKikersMeal);
		
		Meal chickenStripers=new Chicken(ITypeMeal.TypeChicken.NO_SPICY, "CHICKEN STRIPERS", 210, 6.50,  new ArrayList<IIngredients>( )," Сочни филенца, от пилешки гърди, с хрупкава обвивка, изпечени на фурна, придружени със сладко лютив сос");
		m.addMeal(chickenStripers);

		Meal chickenBuffaloWings=new Chicken(ITypeMeal.TypeChicken.NO_SPICY, "BUFFALO WINGS", 230, 6.50,  new ArrayList<IIngredients>( )," 8 прясно изпечени пилешки крилца със сос Барбекю ");
		m.addMeal(chickenBuffaloWings);
		
		Meal chickenBuffaloWingsSpicy=new Chicken(ITypeMeal.TypeChicken.SPICY, "BUFFALO WINGS SPICY", 230, 6.50,  new ArrayList<IIngredients>( )," 8 прясно изпечени пилешки крилца в лют сос Franks ");
		m.addMeal(chickenBuffaloWingsSpicy);
		
		// real PASTA
		
		Meal pastaCarbonara=new Pasta (ITypeMeal.TypePasta.NO_SPICY, "PASTA CARBONARA", 440, 6.80,  new ArrayList<IIngredients>(Arrays.asList( IIngredients.Topping.CREME,IIngredients.Meat.SMOKED_BACON, IIngredients.Vegetable.MUSHROOMS, IIngredients.Cheese.PARMESAN)));
		m.addMeal(pastaCarbonara);
		
		Meal pastaNapolitana=new Pasta (ITypeMeal.TypePasta.NO_SPICY, "PASTA NAPOLITANA", 440, 6.80,  new ArrayList<IIngredients>(Arrays.asList( IIngredients.Topping.CREME,IIngredients.Topping.TOMATO, IIngredients.Cheese.PARMESAN)));
		m.addMeal(pastaNapolitana);
		
		Meal pastaPeperoni=new Pasta (ITypeMeal.TypePasta.SPICY, "PASTA PEPERONI", 410, 6.80,  new ArrayList<IIngredients>(Arrays.asList( IIngredients.Topping.CREME,IIngredients.Topping.TOMATO, IIngredients.Cheese.PARMESAN, IIngredients.Meat.PEPPERONI)));
		m.addMeal(pastaPeperoni);
		
		// real SAUSE
		
		//TOMATO_DIP, MILK_DIP, RANCH_DIP, CEZAR_DIP, FRANKS_SPISY_DIP, HANEY_AND_MUSTARD_DIP, GARLIC_AND_HURB_DIP, BBQ_DIP, SWEET_CHILLI_DIP;
		
		Meal tomatoDip=new Sause (ITypeMeal.TypeSause.TOMATO_DIP, "Tomato dip",45,1);
		m.addMeal(tomatoDip);

		Meal milkDip=new Sause (ITypeMeal.TypeSause.MILK_DIP, "Milk dip",60,1);
		m.addMeal(milkDip);
		
		Meal ranchDip=new Sause (ITypeMeal.TypeSause.RANCH_DIP, "Ranch dip",45,1);
		m.addMeal(ranchDip);
		
		Meal cezarDip=new Sause (ITypeMeal.TypeSause.CEZAR_DIP, "Cezar dip",45,1);
		m.addMeal(cezarDip);
		
		Meal franksSpicyDip=new Sause (ITypeMeal.TypeSause.FRANKS_SPISY_DIP, "Frank's Spicy dip",25,1);
		m.addMeal(franksSpicyDip);
		
		Meal honeyAndMustardDip=new Sause (ITypeMeal.TypeSause.HANEY_AND_MUSTARD_DIP, "Honey & Mustard dip",25,1);
		m.addMeal(honeyAndMustardDip);
		
		Meal garlicAndHurbDip=new Sause (ITypeMeal.TypeSause.GARLIC_AND_HURB_DIP, "Garlic & Hurb dip",25,1);
		m.addMeal(garlicAndHurbDip);
		
		Meal bbqDip=new Sause (ITypeMeal.TypeSause.BBQ_DIP, "BBQ dip",25,1);
		m.addMeal(bbqDip);
		
		Meal sweetChillyDip=new Sause (ITypeMeal.TypeSause.SWEET_CHILLI_DIP, "Sweet Chilli dip",25,1);
		m.addMeal(sweetChillyDip);
		
		
		
		m.printCatalog();	

		
		
		
		
		
	}

}
