package producti;

public interface IIngredients {
	
	
	public enum Cheese implements IIngredients {
		PARMESAN,COW_MILK_CHEESE,CHEDDAR,MELTED_CHEESE,EMMENTAL,MOZZARELLA
	}

	
	public enum Meat implements IIngredients  {
		SMOKED_BACON,CHORIZO,SMOKED_HAM,PEPPERONI,CHICKEN,SPICY_BEEF,TUNA_FISH
	}
	
	
	public enum Spice implements IIngredients {
		OREGANO,BASIL,PARMESAN_FLAKES,CROTON
	}
	
	public enum Topping implements IIngredients  {
		BBQ,CREME,TOMATO, OLIVE_OIL, PESTO
	}
	
	
	public enum Vegetable implements IIngredients {
		CORN, BABY_SPINACH, PICKLES, BLACK_OLIVES, MUSHROOMS, PESTO, ONION, JALAPENO, ARUGULA, TOMATOES, GREEN_PEPPERS, PINEAPPLE, AISBERG
	}
	
	
	
}
